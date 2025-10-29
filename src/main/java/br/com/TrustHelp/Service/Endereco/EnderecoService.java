package br.com.TrustHelp.Service.Endereco;

import br.com.TrustHelp.Model.Endereco.Endereco;
import br.com.TrustHelp.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(Integer id) {
        return enderecoRepository.findById(id);
    }

    public List<Endereco> findByUsuario(Integer idUsuario) {
        return enderecoRepository.findByIdUsuario_Id(idUsuario);
    }

    public List<Endereco> findByOrganizacao(Integer idOrganizacao) {
        return enderecoRepository.findByIdOrganizacao_Id(idOrganizacao);
    }

    public List<Endereco> findByCep(String cep) {
        return enderecoRepository.findByEndCep(cep.replaceAll("\\D", ""));
    }

    public List<Endereco> findByUf(String uf) {
        return enderecoRepository.findByEndUfIgnoreCase(uf.toUpperCase());
    }

    public Endereco save(Endereco endereco) {
        // Validações antes de salvar
        validateEndereco(endereco);

        // Formatar dados
        formatEndereco(endereco);

        return enderecoRepository.save(endereco);
    }

    public Endereco update(Integer id, Endereco enderecoDetails) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);

        if (optionalEndereco.isPresent()) {
            Endereco endereco = optionalEndereco.get();

            // Atualizar campos se não forem nulos
            if (enderecoDetails.getIdUsuario() != null) {
                endereco.setIdUsuario(enderecoDetails.getIdUsuario());
            }
            if (enderecoDetails.getIdOrganizacao() != null) {
                endereco.setIdOrganizacao(enderecoDetails.getIdOrganizacao());
            }
            if (enderecoDetails.getEndLogradouro() != null) {
                endereco.setEndLogradouro(enderecoDetails.getEndLogradouro().trim());
            }
            if (enderecoDetails.getEndNumero() != null) {
                endereco.setEndNumero(enderecoDetails.getEndNumero().trim());
            }
            if (enderecoDetails.getEndComplemento() != null) {
                endereco.setEndComplemento(enderecoDetails.getEndComplemento().trim());
            }
            if (enderecoDetails.getEndCep() != null) {
                endereco.setEndCep(enderecoDetails.getEndCep().replaceAll("\\D", ""));
            }
            if (enderecoDetails.getEndUf() != null) {
                endereco.setEndUf(enderecoDetails.getEndUf().toUpperCase().trim());
            }

            // Validar endereço atualizado
            validateEndereco(endereco);

            return enderecoRepository.save(endereco);
        }

        return null;
    }

    public boolean delete(Integer id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Endereco> search(String termo) {
        return enderecoRepository.search(termo);
    }

    public void validateEndereco(Endereco endereco) {
        // Validar que pertence a usuário OU organização (não ambos)
        if (endereco.getIdUsuario() != null && endereco.getIdOrganizacao() != null) {
            throw new IllegalArgumentException("Endereço deve pertencer a um usuário ou uma organização, não ambos");
        }

        if (endereco.getIdUsuario() == null && endereco.getIdOrganizacao() == null) {
            throw new IllegalArgumentException("Endereço deve pertencer a um usuário ou uma organização");
        }

        if (endereco.getEndLogradouro() == null || endereco.getEndLogradouro().trim().isEmpty()) {
            throw new IllegalArgumentException("Logradouro é obrigatório");
        }

        if (endereco.getEndNumero() == null || endereco.getEndNumero().trim().isEmpty()) {
            throw new IllegalArgumentException("Número é obrigatório");
        }

        if (endereco.getEndCep() == null || endereco.getEndCep().trim().isEmpty()) {
            throw new IllegalArgumentException("CEP é obrigatório");
        }

        // Validar formato do CEP (8 dígitos)
        String cepLimpo = endereco.getEndCep().replaceAll("\\D", "");
        if (cepLimpo.length() != 8) {
            throw new IllegalArgumentException("CEP deve conter 8 dígitos");
        }

        if (endereco.getEndUf() == null || endereco.getEndUf().trim().isEmpty()) {
            throw new IllegalArgumentException("UF é obrigatória");
        }

        // Validar UF (2 caracteres)
        if (endereco.getEndUf().trim().length() != 2) {
            throw new IllegalArgumentException("UF deve conter 2 caracteres");
        }
    }

    private void formatEndereco(Endereco endereco) {
        // Formatar CEP (apenas números)
        if (endereco.getEndCep() != null) {
            endereco.setEndCep(endereco.getEndCep().replaceAll("\\D", ""));
        }

        // Formatar UF (maiúsculas)
        if (endereco.getEndUf() != null) {
            endereco.setEndUf(endereco.getEndUf().toUpperCase().trim());
        }

        // Trim em outros campos
        if (endereco.getEndLogradouro() != null) {
            endereco.setEndLogradouro(endereco.getEndLogradouro().trim());
        }
        if (endereco.getEndNumero() != null) {
            endereco.setEndNumero(endereco.getEndNumero().trim());
        }
        if (endereco.getEndComplemento() != null) {
            endereco.setEndComplemento(endereco.getEndComplemento().trim());
        }
    }

    public long count() {
        return enderecoRepository.count();
    }

    public List<Endereco> findByLogradouroContaining(String logradouro) {
        return enderecoRepository.findByEndLogradouroContainingIgnoreCase(logradouro);
    }
}