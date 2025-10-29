package br.com.TrustHelp.Service.Permissao;

import br.com.TrustHelp.Model.Permissao.Permissao;
import br.com.TrustHelp.Repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> findAll() {
        return permissaoRepository.findAllByOrderByPerNomeAsc();
    }

    public Optional<Permissao> findById(Integer id) {
        return permissaoRepository.findById(id);
    }

    public Optional<Permissao> findByNome(String nome) {
        return permissaoRepository.findByPerNome(nome);
    }

    public List<Permissao> findByNomeContaining(String nome) {
        return permissaoRepository.findByPerNomeContainingIgnoreCase(nome);
    }

    public List<Permissao> findByDescricaoContaining(String descricao) {
        return permissaoRepository.findByPerDescricaoContainingIgnoreCase(descricao);
    }

    public List<Permissao> search(String termo) {
        return permissaoRepository.search(termo);
    }

    public List<Permissao> findByIds(List<Integer> ids) {
        return permissaoRepository.findByIdIn(ids);
    }

    public List<String> findNomesByIds(List<Integer> ids) {
        return permissaoRepository.findNomesByIds(ids);
    }

    @Transactional
    public Permissao save(Permissao permissao) {
        validatePermissao(permissao);

        // Formatar nome (uppercase para consistência)
        permissao.setPerNome(permissao.getPerNome().toUpperCase().trim());

        return permissaoRepository.save(permissao);
    }

    @Transactional
    public Permissao update(Integer id, Permissao permissaoDetails) {
        Optional<Permissao> optionalPermissao = permissaoRepository.findById(id);

        if (optionalPermissao.isPresent()) {
            Permissao permissao = optionalPermissao.get();

            // Atualizar campos se não forem nulos
            if (permissaoDetails.getPerNome() != null) {
                // Verificar se o novo nome já existe em outra permissão
                String novoNome = permissaoDetails.getPerNome().toUpperCase().trim();
                if (!novoNome.equals(permissao.getPerNome()) &&
                        permissaoRepository.existsByPerNomeAndIdNot(novoNome, id)) {
                    throw new IllegalArgumentException("Já existe uma permissão com o nome: " + novoNome);
                }
                permissao.setPerNome(novoNome);
            }

            if (permissaoDetails.getPerDescricao() != null) {
                permissao.setPerDescricao(permissaoDetails.getPerDescricao().trim());
            }

            return permissaoRepository.save(permissao);
        }

        return null;
    }

    public boolean delete(Integer id) {
        if (permissaoRepository.existsById(id)) {
            permissaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Permissao create(String nome, String descricao) {
        // Verificar se nome já existe
        String nomeFormatado = nome.toUpperCase().trim();
        if (permissaoRepository.existsByPerNome(nomeFormatado)) {
            throw new IllegalArgumentException("Já existe uma permissão com o nome: " + nomeFormatado);
        }

        Permissao permissao = new Permissao();
        permissao.setPerNome(nomeFormatado);
        permissao.setPerDescricao(descricao != null ? descricao.trim() : null);

        return save(permissao);
    }

    @Transactional
    public List<Permissao> createMultiple(List<Permissao> permissoes) {
        return permissoes.stream()
                .map(this::save)
                .toList();
    }

    public boolean existsByNome(String nome) {
        return permissaoRepository.existsByPerNome(nome.toUpperCase().trim());
    }

    private void validatePermissao(Permissao permissao) {
        if (permissao.getPerNome() == null || permissao.getPerNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da permissão é obrigatório");
        }

        // Validar formato do nome (apenas letras, números, underscore e hífen)
        if (!permissao.getPerNome().matches("^[a-zA-Z0-9_-]+$")) {
            throw new IllegalArgumentException("Nome deve conter apenas letras, números, underscore e hífen");
        }

        // Validar tamanho máximo
        if (permissao.getPerNome().length() > 50) {
            throw new IllegalArgumentException("Nome deve ter no máximo 50 caracteres");
        }
    }

    public long count() {
        return permissaoRepository.count();
    }

    public List<Permissao> findPermissoesSistema() {
        // Permissões padrão do sistema que podem ser criadas automaticamente
        return List.of(
                createIfNotExists("USUARIO_CREATE", "Permite criar usuários"),
                createIfNotExists("USUARIO_READ", "Permite visualizar usuários"),
                createIfNotExists("USUARIO_UPDATE", "Permite atualizar usuários"),
                createIfNotExists("USUARIO_DELETE", "Permite deletar usuários"),
                createIfNotExists("CHAMADO_CREATE", "Permite criar chamados"),
                createIfNotExists("CHAMADO_READ", "Permite visualizar chamados"),
                createIfNotExists("CHAMADO_UPDATE", "Permite atualizar chamados"),
                createIfNotExists("CHAMADO_DELETE", "Permite deletar chamados"),
                createIfNotExists("RELATORIO_READ", "Permite visualizar relatórios"),
                createIfNotExists("CONFIGURACAO_UPDATE", "Permite atualizar configurações")
        );
    }

    private Permissao createIfNotExists(String nome, String descricao) {
        return permissaoRepository.findByPerNome(nome)
                .orElseGet(() -> {
                    Permissao permissao = new Permissao();
                    permissao.setPerNome(nome);
                    permissao.setPerDescricao(descricao);
                    return permissaoRepository.save(permissao);
                });
    }

    public boolean hasPermissao(Integer idPermissao) {
        return permissaoRepository.existsById(idPermissao);
    }

    public List<Permissao> findPermissoesByPattern(String pattern) {
        return permissaoRepository.findByPerNomeContainingIgnoreCase(pattern);
    }
}