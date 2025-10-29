package br.com.TrustHelp.Service.Organizacao;

import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.Organizacao.OrganizacaoInfo;
import br.com.TrustHelp.Repository.OrganizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizacaoService {

    @Autowired
    private OrganizacaoRepository organizacaoRepository;

    // Salvar organização
    public OrganizacaoInfo save(Organizacao organizacao) {
        // Validações
        if (organizacao.getOrgCnpj() == null || organizacao.getOrgCnpj().trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ é obrigatório");
        }
        if (organizacao.getOrgEmail() == null || organizacao.getOrgEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        if (organizacao.getOrgNome() == null || organizacao.getOrgNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        // Verifica se CNPJ já existe
        if (organizacao.getId() == null) { // Nova organização
            Optional<Organizacao> existingByCnpj = organizacaoRepository.findByOrgCnpj(organizacao.getOrgCnpj());
            if (existingByCnpj.isPresent()) {
                throw new IllegalArgumentException("CNPJ já cadastrado");
            }

            Optional<Organizacao> existingByEmail = organizacaoRepository.findByOrgEmail(organizacao.getOrgEmail());
            if (existingByEmail.isPresent()) {
                throw new IllegalArgumentException("Email já cadastrado");
            }
        }

        // Define como ativo por padrão se não informado
        if (organizacao.getOrgAtivo() == null) {
            organizacao.setOrgAtivo(true);
        }

        Organizacao savedOrganizacao = organizacaoRepository.save(organizacao);
        return convertToOrganizacaoInfo(savedOrganizacao);
    }

    // Buscar todas as organizações
    public List<OrganizacaoInfo> findAll() {
        List<Organizacao> organizacoes = organizacaoRepository.findAll();
        return organizacoes.stream()
                .map(this::convertToOrganizacaoInfo)
                .collect(Collectors.toList());
    }

    // Buscar organização por ID
    public OrganizacaoInfo findById(Integer id) {
        Optional<Organizacao> organizacao = organizacaoRepository.findById(id);
        return organizacao.map(this::convertToOrganizacaoInfo).orElse(null);
    }

    // Buscar organização por CNPJ
    public OrganizacaoInfo findByCnpj(String cnpj) {
        Optional<Organizacao> organizacao = organizacaoRepository.findByOrgCnpj(cnpj);
        return organizacao.map(this::convertToOrganizacaoInfo).orElse(null);
    }

    // Buscar organização por email
    public OrganizacaoInfo findByEmail(String email) {
        Optional<Organizacao> organizacao = organizacaoRepository.findByOrgEmail(email);
        return organizacao.map(this::convertToOrganizacaoInfo).orElse(null);
    }

    // Atualizar organização
    public OrganizacaoInfo update(Integer id, Organizacao organizacaoDetails) {
        Organizacao organizacao = organizacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Organização não encontrada"));

        // Atualiza campos
        if (organizacaoDetails.getOrgNome() != null) {
            organizacao.setOrgNome(organizacaoDetails.getOrgNome());
        }
        if (organizacaoDetails.getOrgEmail() != null) {
            // Verifica se o novo email já existe em outra organização
            Optional<Organizacao> existingByEmail = organizacaoRepository.findByOrgEmail(organizacaoDetails.getOrgEmail());
            if (existingByEmail.isPresent() && !existingByEmail.get().getId().equals(id)) {
                throw new IllegalArgumentException("Email já cadastrado em outra organização");
            }
            organizacao.setOrgEmail(organizacaoDetails.getOrgEmail());
        }
        if (organizacaoDetails.getOrgTelefone() != null) {
            organizacao.setOrgTelefone(organizacaoDetails.getOrgTelefone());
        }
        if (organizacaoDetails.getOrgAtivo() != null) {
            organizacao.setOrgAtivo(organizacaoDetails.getOrgAtivo());
        }

        Organizacao updatedOrganizacao = organizacaoRepository.save(organizacao);
        return convertToOrganizacaoInfo(updatedOrganizacao);
    }

    // Deletar organização (desativar)
    public OrganizacaoInfo deactivate(Integer id) {
        Organizacao organizacao = organizacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Organização não encontrada"));

        organizacao.setOrgAtivo(false);
        Organizacao deactivatedOrganizacao = organizacaoRepository.save(organizacao);
        return convertToOrganizacaoInfo(deactivatedOrganizacao);
    }

    // Buscar organizações ativas
    public List<OrganizacaoInfo> findActive() {
        List<Organizacao> organizacoes = organizacaoRepository.findAll();
        return organizacoes.stream()
                .filter(Organizacao::getOrgAtivo)
                .map(this::convertToOrganizacaoInfo)
                .collect(Collectors.toList());
    }

    // Converter Entity para DTO
    private OrganizacaoInfo convertToOrganizacaoInfo(Organizacao organizacao) {
        OrganizacaoInfo info = new OrganizacaoInfo();
        info.setId(organizacao.getId());
        info.setOrgNome(organizacao.getOrgNome());
        info.setOrgCnpj(organizacao.getOrgCnpj());
        info.setOrgEmail(organizacao.getOrgEmail());
        info.setOrgTelefone(organizacao.getOrgTelefone());
        info.setOrgAtivo(organizacao.getOrgAtivo());
        return info;
    }
}