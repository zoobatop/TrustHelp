package br.com.TrustHelp.Service.User;

import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Model.User.UsuarioInfo;
import br.com.TrustHelp.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Salva um usuário e retorna o DTO (UsuarioInfo)
    public UsuarioInfo save(Usuario usuario) {
        // Validações antes de salvar
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        // Verifica se email já existe (para update, verifica se é outro usuário)
        if (usuario.getId() == null) { // Novo usuário
            Optional<Usuario> existing = usuarioRepository.findByEmail(usuario.getEmail());
            if (existing.isPresent()) {
                throw new IllegalArgumentException("Email já cadastrado");
            }
        }

        // Salva no banco (método save já existe no JpaRepository)
        Usuario savedUsuario = usuarioRepository.save(usuario);

        // Converte para DTO e retorna
        return convertToUsuarioInfo(savedUsuario);
    }

    // Salva e retorna a entidade completa (se precisar)
    public Usuario saveUsuario(Usuario usuario) {
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

    public Optional<UsuarioInfo> findByEmailAndPassword(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndPassword(email, password);
        return usuario.map(this::convertToUsuarioInfo);
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
        if (usuarioDetails.getPassword() != null) {
            usuario.setPassword(usuarioDetails.getPassword());
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
        return info;
    }
}