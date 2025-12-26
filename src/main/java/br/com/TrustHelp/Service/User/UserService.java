package br.com.TrustHelp.Service.User;

import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Model.User.UsuarioInfo;
import br.com.TrustHelp.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Salva um usuário e retorna o DTO (UsuarioInfo)
    public UsuarioInfo save(Usuario usuario) {
        // Validações antes de salvar
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        if (usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }

        // Verifica se email já existe (para update, verifica se é outro usuário)
        if (usuario.getId() == null) { // Novo usuário
            Optional<Usuario> existing = usuarioRepository.findByEmail(usuario.getEmail());
            if (existing.isPresent()) {
                throw new IllegalArgumentException("Email já cadastrado");
            }
            // Criptografa a senha antes de salvar
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }

        // Salva no banco (método save já existe no JpaRepository)
        Usuario savedUsuario = usuarioRepository.save(usuario);

        // Converte para DTO e retorna
        return convertToUsuarioInfo(savedUsuario);
    }

    // Salva e retorna a entidade completa (se precisar)
    public Usuario saveUsuario(Usuario usuario) {
        // Criptografa a senha antes de salvar
        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuarioRepository.save(usuario);
    }

    // Outros métodos...
    public List<UsuarioInfo> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::convertToUsuarioInfo)
                .collect(Collectors.toList());
    }

    public UsuarioInfo findById(int id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(this::convertToUsuarioInfo).orElse(null);
    }

    public UsuarioInfo findByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.map(this::convertToUsuarioInfo).orElse(null);
    }

    // Método de login - Validar senha criptografada
    public Optional<UsuarioInfo> login(String email, String senhaPlainText) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if (usuario.isPresent()) {
            // Verifica se a senha em texto plano corresponde à senha criptografada
            if (passwordEncoder.matches(senhaPlainText, usuario.get().getPassword())) {
                return Optional.of(convertToUsuarioInfo(usuario.get()));
            }
        }

        return Optional.empty();
    }

    public Optional<UsuarioInfo> findByEmailAndPassword(String email, String password) {
        // Este método não funciona mais com senhas criptografadas
        // Use o método login() acima
        throw new UnsupportedOperationException("Use o método login() para autenticação");
    }

    // Método para atualizar usuário
    public UsuarioInfo update(Integer id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Atualiza campos
        if (usuarioDetails.getNome() != null) {
            usuario.setNome(usuarioDetails.getNome());
        }
        if (usuarioDetails.getEmail() != null) {
            usuario.setEmail(usuarioDetails.getEmail());
        }
        if (usuarioDetails.getPassword() != null && !usuarioDetails.getPassword().isEmpty()) {
            // Criptografa a nova senha
            usuario.setPassword(passwordEncoder.encode(usuarioDetails.getPassword()));
        }
        if (usuarioDetails.getAtivo() != null) {
            usuario.setAtivo(usuarioDetails.getAtivo());
        }

        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return convertToUsuarioInfo(updatedUsuario);
    }

    private UsuarioInfo convertToUsuarioInfo(Usuario usuario) {
        UsuarioInfo info = new UsuarioInfo();
        info.setId(usuario.getId());
        info.setNome(usuario.getNome());
        info.setEmail(usuario.getEmail());
        info.setAtivo(usuario.getAtivo());
        // Adicione outros campos que quiser expor na API
        // NÃO exponha a senha criptografada
        return info;
    }
}
