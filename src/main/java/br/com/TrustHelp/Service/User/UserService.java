package br.com.TrustHelp.Service.User;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.Organizacao.OrganizacaoInfo;
import br.com.TrustHelp.Model.Papel.Papel;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Model.User.UsuarioInfo;
import br.com.TrustHelp.Model.User.Input.UsuarioInput;
import br.com.TrustHelp.Repository.PapelRepository;
import br.com.TrustHelp.Repository.UsuarioRepository;
import br.com.TrustHelp.Service.Organizacao.OrganizacaoService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PapelRepository papelRepository;
    @Autowired
    private OrganizacaoService organizacaoRepository;
    private BCryptPasswordEncoder passwordEncoder;

    // Salva um usuário e retorna o DTO (UsuarioInfo)
    public UsuarioInfo save(UsuarioInput usuarioInput) {
        if (usuarioInput.getEmail() == null || usuarioInput.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        Optional<Usuario> existing = usuarioRepository.findByEmail(usuarioInput.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        // Converter UsuarioInput para Usuario
        Usuario usuarioEntity = convertInputToEntity(usuarioInput);

        Usuario savedUsuario = usuarioRepository.save(usuarioEntity);
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
        info.setIdPapel(usuario.getIdPapel() != null ? usuario.getIdPapel().getId() : null);
        info.setIdOrganizacao(usuario.getIdOrganizacao() != null ? usuario.getIdOrganizacao().getId() : null);
        // Adicione outros campos que quiser expor na API
        return info;
    }

    private Usuario convertInputToEntity(UsuarioInput input) {
        Usuario usuario = new Usuario();
        usuario.setNome(input.getNome());
        usuario.setEmail(input.getEmail());

        // Codifica a senha
        if (input.getSenha() != null && !input.getSenha().trim().isEmpty()) {
            this.passwordEncoder = new BCryptPasswordEncoder();
            usuario.setPassword(passwordEncoder.encode(input.getSenha()));
        }

        usuario.setAtivo(input.getAtivo() != null ? input.getAtivo() : true); // Default true se não informado

        // Busca o Papel pelo ID e associa a entidade completa
        if (input.getIdPapel() != 0) {
            Papel papel = this.papelRepository.findById(input.getIdPapel())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Papel não encontrado com ID: " + input.getIdPapel()));
            usuario.setIdPapel(papel); // Associa o objeto Papel completo
        } else {
            throw new IllegalArgumentException("ID do Papel é obrigatório");
        }

        // Busca a Organização pelo ID e associa a entidade completa
        if (input.getIdOrganizacao() != 0) {
            OrganizacaoInfo organizacao = this.organizacaoRepository.findById(input.getIdOrganizacao());
            Organizacao orgEntity = new Organizacao();
            orgEntity.setId(organizacao.getId());
            orgEntity.setOrgNome(organizacao.getOrgNome());
            orgEntity.setOrgCnpj(organizacao.getOrgCnpj());
            orgEntity.setOrgEmail(organizacao.getOrgEmail());
            orgEntity.setOrgTelefone(organizacao.getOrgTelefone());
            orgEntity.setOrgAtivo(organizacao.getOrgAtivo());
            usuario.setIdOrganizacao(orgEntity); // Associa o objeto Organizacao completo
        }
        // Se idOrganizacao for null, pode manter como null (depende da regra de negócio)

        return usuario;
    }
}