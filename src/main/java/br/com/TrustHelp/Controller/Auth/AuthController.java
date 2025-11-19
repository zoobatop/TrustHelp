package br.com.TrustHelp.Controller.Auth;

import br.com.TrustHelp.Controller.BaseController;
import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.Papel.Papel;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Model.User.UsuarioInfo;
import br.com.TrustHelp.Repository.OrganizacaoRepository;
import br.com.TrustHelp.Repository.PapelRepository;
import br.com.TrustHelp.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController extends BaseController {

    private final UserService userService;
    private final PapelRepository papelRepository;
    private final OrganizacaoRepository organizacaoRepository;

    @Autowired
    public AuthController(UserService userService,
                          PapelRepository papelRepository,
                          OrganizacaoRepository organizacaoRepository) {
        this.userService = userService;
        this.papelRepository = papelRepository;
        this.organizacaoRepository = organizacaoRepository;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, Object>> cadastro(@RequestBody CadastroRequest request) {
        System.out.println("=== ENDPOINT /auth/cadastro CHAMADO ===");
        System.out.println("Nome: " + request.getUsuNome());
        System.out.println("Email: " + request.getUsuEmail());
        System.out.println("CPF: " + request.getUsuCpf());
        System.out.println("ID Papel: " + request.getIdPapel());
        System.out.println("ID Organizacao: " + request.getIdOrganizacao());

        try {
            // Criar entidade Usuario
            Usuario usuario = new Usuario();
            usuario.setNome(request.getUsuNome());
            usuario.setEmail(request.getUsuEmail());
            usuario.setPassword(request.getUsuSenha()); // TODO: Criptografar com BCrypt
            usuario.setAtivo(true);

            // Buscar e setar Papel
            if (request.getIdPapel() != null) {
                Papel papel = papelRepository.findById(request.getIdPapel())
                        .orElseThrow(() -> new IllegalArgumentException("Papel não encontrado"));
                usuario.setIdPapel(papel);
            }

            // Buscar e setar Organizacao
            if (request.getIdOrganizacao() != null) {
                Organizacao organizacao = organizacaoRepository.findById(request.getIdOrganizacao())
                        .orElseThrow(() -> new IllegalArgumentException("Organização não encontrada"));
                usuario.setIdOrganizacao(organizacao);
            }

            // Salvar
            UsuarioInfo savedUsuario = userService.save(usuario);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Usuário cadastrado com sucesso!");
            response.put("usuario", savedUsuario);

            System.out.println("✅ Usuario salvo com sucesso!");
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            System.err.println("❌ Erro de validação: " + e.getMessage());
            return error(e.getMessage());

        } catch (Exception e) {
            System.err.println("❌ Erro interno: " + e.getMessage());
            e.printStackTrace();
            return error("Erro interno ao cadastrar usuário: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        System.out.println("=== ENDPOINT /auth/login CHAMADO ===");
        System.out.println("Email: " + request.getEmail());

        try {
            UsuarioInfo usuario = userService.findByEmail(request.getEmail());

            if (usuario == null) {
                return error("Usuário não encontrado");
            }

            // TODO: Implementar verificação de senha com BCrypt
            // Por enquanto aceita qualquer senha

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Login realizado com sucesso!");
            response.put("usuario", usuario);
            response.put("token", "token_temporario_" + usuario.getId());

            System.out.println("✅ Login bem-sucedido!");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println("❌ Erro no login: " + e.getMessage());
            e.printStackTrace();
            return error("Erro interno ao realizar login: " + e.getMessage());
        }
    }

    // DTO para cadastro
    public static class CadastroRequest {
        private String usuNome;
        private String usuEmail;
        private String usuSenha;
        private String usuCpf;
        private Integer idPapel;
        private Integer idOrganizacao;

        // Getters e Setters
        public String getUsuNome() { return usuNome; }
        public void setUsuNome(String usuNome) { this.usuNome = usuNome; }

        public String getUsuEmail() { return usuEmail; }
        public void setUsuEmail(String usuEmail) { this.usuEmail = usuEmail; }

        public String getUsuSenha() { return usuSenha; }
        public void setUsuSenha(String usuSenha) { this.usuSenha = usuSenha; }

        public String getUsuCpf() { return usuCpf; }
        public void setUsuCpf(String usuCpf) { this.usuCpf = usuCpf; }

        public Integer getIdPapel() { return idPapel; }
        public void setIdPapel(Integer idPapel) { this.idPapel = idPapel; }

        public Integer getIdOrganizacao() { return idOrganizacao; }
        public void setIdOrganizacao(Integer idOrganizacao) { this.idOrganizacao = idOrganizacao; }
    }

    // DTO para login
    public static class LoginRequest {
        private String email;
        private String senha;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
    }
}
