package br.com.TrustHelp.Service.EmpresaAtendimento;

import br.com.TrustHelp.Model.EmpresaAtendimento.EmpresaAtendimento;
import br.com.TrustHelp.Repository.EmpresaAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaAtendimentoService {

    @Autowired
    private EmpresaAtendimentoRepository empresaAtendimentoRepository;

    public List<EmpresaAtendimento> findAll() {
        return empresaAtendimentoRepository.findAll();
    }

    public Optional<EmpresaAtendimento> findById(Integer id) {
        return empresaAtendimentoRepository.findById(id);
    }

    public Optional<EmpresaAtendimento> findByCnpj(String cnpj) {
        return empresaAtendimentoRepository.findByEmpCnpj(cnpj);
    }

    public Optional<EmpresaAtendimento> findByEmail(String email) {
        return empresaAtendimentoRepository.findByEmpEmail(email);
    }

    public List<EmpresaAtendimento> findByNomeContaining(String nome) {
        return empresaAtendimentoRepository.findByEmpNomeContainingIgnoreCase(nome);
    }

    public EmpresaAtendimento save(EmpresaAtendimento empresaAtendimento) {
        // Validações antes de salvar
        validateEmpresaAtendimento(empresaAtendimento);

        // Limpar e formatar CNPJ (remover caracteres não numéricos)
        if (empresaAtendimento.getEmpCnpj() != null) {
            empresaAtendimento.setEmpCnpj(empresaAtendimento.getEmpCnpj().replaceAll("\\D", ""));
        }

        // Limpar e formatar telefone
        if (empresaAtendimento.getEmpTelefone() != null) {
            empresaAtendimento.setEmpTelefone(empresaAtendimento.getEmpTelefone().replaceAll("\\D", ""));
        }

        return empresaAtendimentoRepository.save(empresaAtendimento);
    }

    public EmpresaAtendimento update(Integer id, EmpresaAtendimento empresaDetails) {
        Optional<EmpresaAtendimento> optionalEmpresa = empresaAtendimentoRepository.findById(id);

        if (optionalEmpresa.isPresent()) {
            EmpresaAtendimento empresa = optionalEmpresa.get();

            // Atualizar campos se não forem nulos
            if (empresaDetails.getEmpNome() != null) {
                empresa.setEmpNome(empresaDetails.getEmpNome().trim());
            }
            if (empresaDetails.getEmpCnpj() != null) {
                // Verificar se o CNPJ já existe em outra empresa
                String novoCnpj = empresaDetails.getEmpCnpj().replaceAll("\\D", "");
                if (!novoCnpj.equals(empresa.getEmpCnpj())) {
                    Optional<EmpresaAtendimento> empresaComMesmoCnpj = empresaAtendimentoRepository.findByEmpCnpj(novoCnpj);
                    if (empresaComMesmoCnpj.isPresent()) {
                        throw new IllegalArgumentException("Já existe uma empresa com este CNPJ");
                    }
                }
                empresa.setEmpCnpj(novoCnpj);
            }
            if (empresaDetails.getEmpEmail() != null) {
                // Verificar se o email já existe em outra empresa
                String novoEmail = empresaDetails.getEmpEmail().trim().toLowerCase();
                if (!novoEmail.equals(empresa.getEmpEmail())) {
                    Optional<EmpresaAtendimento> empresaComMesmoEmail = empresaAtendimentoRepository.findByEmpEmail(novoEmail);
                    if (empresaComMesmoEmail.isPresent()) {
                        throw new IllegalArgumentException("Já existe uma empresa com este email");
                    }
                }
                empresa.setEmpEmail(novoEmail);
            }
            if (empresaDetails.getEmpTelefone() != null) {
                empresa.setEmpTelefone(empresaDetails.getEmpTelefone().replaceAll("\\D", ""));
            }

            return empresaAtendimentoRepository.save(empresa);
        }

        return null;
    }

    public boolean delete(Integer id) {
        if (empresaAtendimentoRepository.existsById(id)) {
            empresaAtendimentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsByCnpj(String cnpj) {
        return empresaAtendimentoRepository.findByEmpCnpj(cnpj.replaceAll("\\D", "")).isPresent();
    }

    public boolean existsByEmail(String email) {
        return empresaAtendimentoRepository.findByEmpEmail(email.trim().toLowerCase()).isPresent();
    }

    public List<EmpresaAtendimento> search(String termo) {
        return empresaAtendimentoRepository.findByEmpNomeContainingIgnoreCaseOrEmpCnpjContaining(termo);
    }

    private void validateEmpresaAtendimento(EmpresaAtendimento empresa) {
        if (empresa.getEmpNome() == null || empresa.getEmpNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da empresa é obrigatório");
        }

        if (empresa.getEmpCnpj() == null || empresa.getEmpCnpj().trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ da empresa é obrigatório");
        }

        // Validar formato do CNPJ (14 dígitos)
        String cnpjLimpo = empresa.getEmpCnpj().replaceAll("\\D", "");
        if (cnpjLimpo.length() != 14) {
            throw new IllegalArgumentException("CNPJ deve conter 14 dígitos");
        }

        // Validar email se fornecido
        if (empresa.getEmpEmail() != null && !empresa.getEmpEmail().trim().isEmpty()) {
            if (!isValidEmail(empresa.getEmpEmail())) {
                throw new IllegalArgumentException("Email inválido");
            }
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public long count() {
        return empresaAtendimentoRepository.count();
    }
}