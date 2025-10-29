package br.com.TrustHelp.Service.ParametroConfiguracao;

import br.com.TrustHelp.Model.ParametroConfiguracao.ParametroConfiguracao;
import br.com.TrustHelp.Repository.ParametroConfiguracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ParametroConfiguracaoService {

    @Autowired
    private ParametroConfiguracaoRepository parametroConfiguracaoRepository;

    public List<ParametroConfiguracao> findAll() {
        return parametroConfiguracaoRepository.findAll();
    }

    public Optional<ParametroConfiguracao> findById(Integer id) {
        return parametroConfiguracaoRepository.findById(id);
    }

    public Optional<ParametroConfiguracao> findByChave(String chave) {
        return parametroConfiguracaoRepository.findByParChave(chave);
    }

    public Optional<String> findValorByChave(String chave) {
        return parametroConfiguracaoRepository.findValorByChave(chave);
    }

    public List<ParametroConfiguracao> findByCategoria(String categoria) {
        return parametroConfiguracaoRepository.findByParCategoria(categoria);
    }

    public List<ParametroConfiguracao> findAtivos() {
        return parametroConfiguracaoRepository.findByParAtivoTrue();
    }

    public List<ParametroConfiguracao> findInativos() {
        return parametroConfiguracaoRepository.findByParAtivoFalse();
    }

    public List<ParametroConfiguracao> findByCategoriaAndAtivo(String categoria, Boolean ativo) {
        return parametroConfiguracaoRepository.findByParCategoriaAndParAtivo(categoria, ativo);
    }

    public List<ParametroConfiguracao> search(String termo) {
        return parametroConfiguracaoRepository.search(termo);
    }

    public List<ParametroConfiguracao> findByChaveContaining(String chave) {
        return parametroConfiguracaoRepository.findByParChaveContainingIgnoreCase(chave);
    }

    public List<String> findDistinctCategorias() {
        return parametroConfiguracaoRepository.findDistinctCategorias();
    }

    @Transactional
    public ParametroConfiguracao save(ParametroConfiguracao parametro) {
        validateParametro(parametro);

        // Atualizar timestamp
        parametro.setParAtualizadoEm(Instant.now());

        // Garantir valores padrão
        if (parametro.getParAtivo() == null) {
            parametro.setParAtivo(true);
        }

        return parametroConfiguracaoRepository.save(parametro);
    }

    @Transactional
    public ParametroConfiguracao update(Integer id, ParametroConfiguracao parametroDetails) {
        Optional<ParametroConfiguracao> optionalParametro = parametroConfiguracaoRepository.findById(id);

        if (optionalParametro.isPresent()) {
            ParametroConfiguracao parametro = optionalParametro.get();

            // Atualizar campos permitidos (não atualizamos a chave diretamente)
            if (parametroDetails.getParValor() != null) {
                parametro.setParValor(parametroDetails.getParValor().trim());
            }
            if (parametroDetails.getParCategoria() != null) {
                parametro.setParCategoria(parametroDetails.getParCategoria().trim());
            }
            if (parametroDetails.getParDescricao() != null) {
                parametro.setParDescricao(parametroDetails.getParDescricao().trim());
            }
            if (parametroDetails.getParAtivo() != null) {
                parametro.setParAtivo(parametroDetails.getParAtivo());
            }

            // Atualizar timestamp
            parametro.setParAtualizadoEm(Instant.now());

            return parametroConfiguracaoRepository.save(parametro);
        }

        return null;
    }

    @Transactional
    public ParametroConfiguracao updateByChave(String chave, String novoValor) {
        Optional<ParametroConfiguracao> optionalParametro = parametroConfiguracaoRepository.findByParChave(chave);

        if (optionalParametro.isPresent()) {
            ParametroConfiguracao parametro = optionalParametro.get();
            parametro.setParValor(novoValor.trim());
            parametro.setParAtualizadoEm(Instant.now());

            return parametroConfiguracaoRepository.save(parametro);
        }

        return null;
    }

    @Transactional
    public ParametroConfiguracao create(String chave, String valor, String categoria, String descricao) {
        // Verificar se chave já existe
        if (parametroConfiguracaoRepository.existsByParChave(chave)) {
            throw new IllegalArgumentException("Já existe um parâmetro com a chave: " + chave);
        }

        ParametroConfiguracao parametro = new ParametroConfiguracao();
        parametro.setParChave(chave.trim().toUpperCase());
        parametro.setParValor(valor.trim());
        parametro.setParCategoria(categoria.trim());
        parametro.setParDescricao(descricao != null ? descricao.trim() : null);
        parametro.setParAtivo(true);
        parametro.setParAtualizadoEm(Instant.now());

        return save(parametro);
    }

    public boolean delete(Integer id) {
        if (parametroConfiguracaoRepository.existsById(id)) {
            parametroConfiguracaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteByChave(String chave) {
        Optional<ParametroConfiguracao> parametro = parametroConfiguracaoRepository.findByParChave(chave);
        if (parametro.isPresent()) {
            parametroConfiguracaoRepository.delete(parametro.get());
            return true;
        }
        return false;
    }

    @Transactional
    public ParametroConfiguracao toggleAtivo(Integer id) {
        Optional<ParametroConfiguracao> optionalParametro = parametroConfiguracaoRepository.findById(id);

        if (optionalParametro.isPresent()) {
            ParametroConfiguracao parametro = optionalParametro.get();
            parametro.setParAtivo(!parametro.getParAtivo());
            parametro.setParAtualizadoEm(Instant.now());

            return parametroConfiguracaoRepository.save(parametro);
        }

        return null;
    }

    @Transactional
    public ParametroConfiguracao toggleAtivoByChave(String chave) {
        Optional<ParametroConfiguracao> optionalParametro = parametroConfiguracaoRepository.findByParChave(chave);

        if (optionalParametro.isPresent()) {
            ParametroConfiguracao parametro = optionalParametro.get();
            parametro.setParAtivo(!parametro.getParAtivo());
            parametro.setParAtualizadoEm(Instant.now());

            return parametroConfiguracaoRepository.save(parametro);
        }

        return null;
    }

    public boolean existsByChave(String chave) {
        return parametroConfiguracaoRepository.existsByParChave(chave);
    }

    public List<ParametroConfiguracao> findByMultiplasCategorias(List<String> categorias) {
        return parametroConfiguracaoRepository.findByParCategoriaIn(categorias);
    }

    public String getValorOrDefault(String chave, String valorPadrao) {
        return parametroConfiguracaoRepository.findValorByChave(chave)
                .orElse(valorPadrao);
    }

    public Integer getValorAsInteger(String chave, Integer valorPadrao) {
        try {
            return parametroConfiguracaoRepository.findValorByChave(chave)
                    .map(Integer::parseInt)
                    .orElse(valorPadrao);
        } catch (NumberFormatException e) {
            return valorPadrao;
        }
    }

    public Boolean getValorAsBoolean(String chave, Boolean valorPadrao) {
        return parametroConfiguracaoRepository.findValorByChave(chave)
                .map(valor -> "true".equalsIgnoreCase(valor) || "1".equals(valor))
                .orElse(valorPadrao);
    }

    private void validateParametro(ParametroConfiguracao parametro) {
        if (parametro.getParChave() == null || parametro.getParChave().trim().isEmpty()) {
            throw new IllegalArgumentException("Chave do parâmetro é obrigatória");
        }

        if (parametro.getParValor() == null || parametro.getParValor().trim().isEmpty()) {
            throw new IllegalArgumentException("Valor do parâmetro é obrigatório");
        }

        if (parametro.getParCategoria() == null || parametro.getParCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria do parâmetro é obrigatória");
        }

        // Validar formato da chave (apenas letras, números e underscore)
        if (!parametro.getParChave().matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalArgumentException("Chave deve conter apenas letras, números e underscore");
        }

        // Validar tamanho máximo
        if (parametro.getParChave().length() > 100) {
            throw new IllegalArgumentException("Chave deve ter no máximo 100 caracteres");
        }

        if (parametro.getParValor().length() > 500) {
            throw new IllegalArgumentException("Valor deve ter no máximo 500 caracteres");
        }

        if (parametro.getParCategoria().length() > 50) {
            throw new IllegalArgumentException("Categoria deve ter no máximo 50 caracteres");
        }
    }

    public long count() {
        return parametroConfiguracaoRepository.count();
    }

    public long countByCategoria(String categoria) {
        return parametroConfiguracaoRepository.findByParCategoria(categoria).size();
    }

    public long countAtivos() {
        return parametroConfiguracaoRepository.findByParAtivoTrue().size();
    }

    public List<ParametroConfiguracao> findAtualizadosApos(Instant data) {
        return parametroConfiguracaoRepository.findByParAtualizadoEmAfter(data);
    }

    @Transactional
    public void importarConfiguracoes(List<ParametroConfiguracao> configuracoes) {
        for (ParametroConfiguracao config : configuracoes) {
            // Se já existe, atualiza; se não, cria
            parametroConfiguracaoRepository.findByParChave(config.getParChave())
                    .ifPresentOrElse(
                            existente -> {
                                existente.setParValor(config.getParValor());
                                existente.setParCategoria(config.getParCategoria());
                                existente.setParDescricao(config.getParDescricao());
                                existente.setParAtivo(config.getParAtivo());
                                existente.setParAtualizadoEm(Instant.now());
                                parametroConfiguracaoRepository.save(existente);
                            },
                            () -> {
                                config.setParAtualizadoEm(Instant.now());
                                parametroConfiguracaoRepository.save(config);
                            }
                    );
        }
    }
}