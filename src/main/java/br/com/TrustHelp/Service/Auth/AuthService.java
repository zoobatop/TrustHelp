package br.com.TrustHelp.Service.Auth;

import br.com.TrustHelp.Model.Auth.LoginRequest;
import br.com.TrustHelp.Model.Auth.LoginResponse;
import br.com.TrustHelp.Model.Auth.RegisterRequest;
import br.com.TrustHelp.Model.Auth.RegisterResponse;
import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Service.Auth.JWT.JwtTokenService;
import br.com.TrustHelp.Service.Organizacao.OrganizacaoService;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Model.User.UsuarioInfo;
import br.com.TrustHelp.Repository.PapelRepository;
import br.com.TrustHelp.Repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private OrganizacaoService organizacaoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenService jwtTokenService; // Vamos criar esta classe

    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();

        try {
            // Busca usuário pelo email
            Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(loginRequest.getEmail());

            if (usuarioOptional.isEmpty()) {
                response.setSucesso(false);
                response.setMensagem("Credenciais inválidas");
                return response;
            }

            Usuario usuario = usuarioOptional.get();

            // Verifica se o usuário está ativo
            if (Boolean.FALSE.equals(usuario.getAtivo())) {
                response.setSucesso(false);
                response.setMensagem("Usuário inativo. Contate o administrador.");
                return response;
            }

            // Verifica a senha
            if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.getPassword())) {
                // Incrementa tentativas de login (se tiver esse campo)
                response.setSucesso(false);
                response.setMensagem("Credenciais inválidas");
                return response;
            }

            // Gera token JWT
            String token = jwtTokenService.generateToken(usuario);

            // Prepara resposta
            response.setSucesso(true);
            response.setToken(token);
            response.setMensagem("Login realizado com sucesso");
            response.setUsuario(convertToUsuarioInfo(usuario));
            response.setExpiraEm(jwtTokenService.getExpirationDateFromToken(token));

        } catch (Exception e) {
            response.setSucesso(false);
            response.setMensagem("Erro durante o login: " + e.getMessage());
        }

        return response;
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResponse response = new RegisterResponse();

        try {
            // 1. Validação básica
            if (!registerRequest.isValid()) {
                response.setSucesso(false);
                response.setMensagem(
                        "Dados inválidos. Verifique se todos os campos estão preenchidos e as senhas coincidem.");
                return response;
            }

            // 2. Validação de email
            if (!isValidEmail(registerRequest.getEmail())) {
                response.setSucesso(false);
                response.setMensagem("Email inválido.");
                return response;
            }

            // 3. Verifica se email já existe
            Optional<Usuario> existingUser = usuarioRepository.findByEmail(registerRequest.getEmail());
            if (existingUser.isPresent()) {
                response.setSucesso(false);
                response.setMensagem("Email já cadastrado.");
                return response;
            }

            // 4. Validação de senha
            if (registerRequest.getSenha().length() < 6) {
                response.setSucesso(false);
                response.setMensagem("A senha deve ter pelo menos 6 caracteres.");
                return response;
            }

            // 5. Verifica papel (se fornecido)
            Integer papelId = registerRequest.getIdPapel();
            if (papelId != null) {
                if (papelRepository.findById(papelId) != null) {
                    response.setSucesso(false);
                    response.setMensagem("Papel não encontrado.");
                    return response;
                }
            } else {
                // Papel padrão (CLIENTE ou VISITANTE)
                papelId = getDefaultPapelId();
            }

            // 6. Verifica organização (se fornecida)
            Integer organizacaoId = registerRequest.getIdOrganizacao();
            if (organizacaoId != null) {
                if (organizacaoService.findById(organizacaoId) == null) {
                    response.setSucesso(false);
                    response.setMensagem("Organização não encontrada.");
                    return response;
                }
            } else {
                organizacaoId = getDefaultOrganizacaoId();
            }

            // 7. Cria o usuário
            Usuario usuario = new Usuario();
            usuario.setNome(registerRequest.getNome().trim());
            usuario.setEmail(registerRequest.getEmail().trim().toLowerCase());
            usuario.setPassword(passwordEncoder.encode(registerRequest.getSenha()));
            usuario.setAtivo(true); // Ativo por padrão

            // Associa papel
            if (papelId != null) {
                papelRepository.findById(papelId).ifPresent(papel -> {
                    usuario.setIdPapel(papel);
                });
            }

            // Associa organização (se fornecida)
            if (organizacaoId != null) {
                if (organizacaoService.findById(organizacaoId) != null) {
                    Organizacao org = new Organizacao();
                    org.setId(organizacaoId);
                    usuario.setIdOrganizacao(org);
                }
            }

            // 8. Salva o usuário
            Usuario savedUsuario = usuarioRepository.save(usuario);

            // 9. Prepara resposta
            response.setSucesso(true);
            response.setMensagem("Usuário registrado com sucesso!");
            response.setUsuario(convertToUsuarioInfo(savedUsuario));

            // 10. Gera token para login automático (opcional)
            String token = jwtTokenService.generateToken(savedUsuario);
            response.setToken(token);

            // 11. Log
            System.out.println("Novo usuário registrado: " + savedUsuario.getEmail());

        } catch (Exception e) {
            response.setSucesso(false);
            response.setMensagem("Erro durante o registro: " + e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

    public boolean checkEmailExists(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }

    private boolean isValidEmail(String email) {
        // Validação simples de email
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && email.matches(emailRegex);
    }

    private Integer getDefaultPapelId() {
        // Busca o papel padrão (CLIENTE ou VISITANTE)
        // Ajuste conforme seus papéis padrão
        return papelRepository.findByPapNome("CLIENTE")
                .orElse(papelRepository.findByPapNome("VISITANTE")
                        .orElseThrow(() -> new RuntimeException("Papel padrão não encontrado")))
                .getId();
    }

    private Integer getDefaultOrganizacaoId() {
        return organizacaoService.findActive().get(0).getId();
    }

    public boolean validateToken(String token) {
        try {
            return jwtTokenService.validateToken(token);
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return jwtTokenService.getUsernameFromToken(token);
    }

    private UsuarioInfo convertToUsuarioInfo(Usuario usuario) {
        UsuarioInfo info = new UsuarioInfo();
        info.setId(usuario.getId());
        info.setNome(usuario.getNome());
        info.setEmail(usuario.getEmail());
        info.setAtivo(usuario.getAtivo());

        if (usuario.getIdPapel() != null) {
            info.setIdPapel(usuario.getIdPapel().getId());
        }

        if (usuario.getIdOrganizacao() != null) {
            info.setIdOrganizacao(usuario.getIdOrganizacao().getId());
        }

        return info;
    }

    public void logout(String token) {

    }
}