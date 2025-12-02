package br.com.TrustHelp.Initializer;

import br.com.TrustHelp.Config.Initialization.InitialDataConfig;
import br.com.TrustHelp.Model.Papel.Papel;
import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.Organizacao.OrganizacaoInfo;
import br.com.TrustHelp.Model.User.Input.UsuarioInput;
import br.com.TrustHelp.Repository.PapelRepository;
import br.com.TrustHelp.Service.Organizacao.OrganizacaoService;
import br.com.TrustHelp.Service.User.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final InitialDataConfig config;
    private final PapelRepository papelRepository;
    private final OrganizacaoService organizacaoService;
    private final UserService userService;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @PostConstruct
    @Transactional
    public void initialize() {
        if (!config.isEnabled()) {
            log.info("Initialization is disabled");
            return;
        }

        log.info("🚀 Starting system initialization...");
        log.info("Active profile: {}", activeProfile);

        try {
            if (config.isCreateDefaults()) {
                initSystemRoles();
                initOrganizations();
                initDefaultAdmin();
            }

            log.info("✅ System initialization completed successfully!");

        } catch (Exception e) {
            log.error("❌ Error during system initialization", e);
            throw new RuntimeException("Failed to initialize system data", e);
        }
    }

    private void initSystemRoles() {
        log.info("Creating system roles...");

        if (config.getRoles() == null || config.getRoles().isEmpty()) {
            log.warn("No roles defined in configuration");
            return;
        }

        config.getRoles().forEach(roleConfig -> {
            String roleName = roleConfig.getPapNome().toUpperCase();

            if (!papelRepository.existsByPapNome(roleName)) {
                Papel papel = new Papel();
                papel.setPapNome(roleName);
                papel.setPapDescricao(roleConfig.getPapDescricao());

                papelRepository.save(papel);
                log.info("✅ Created role: {}", roleName);
            } else {
                log.debug("Role already exists: {}", roleName);
            }
        });
    }

    private void initOrganizations() {
        log.info("Creating default organizations...");

        if (config.getOrganizations() == null || config.getOrganizations().isEmpty()) {
            log.warn("No organizations defined in configuration");
            return;
        }

        config.getOrganizations().forEach(orgConfig -> {
            // Verifica se organização já existe pelo CNPJ
            boolean exists = organizacaoService.findByCnpj(orgConfig.getOrgCnpj()) != null;
            
            if (!exists) {
                // Cria organização usando o serviço
                Organizacao org = new Organizacao();
                org.setOrgNome(orgConfig.getOrgNome());
                org.setOrgCnpj(orgConfig.getOrgCnpj());
                org.setOrgEmail(orgConfig.getOrgEmail());
                org.setOrgTelefone(orgConfig.getOrgTelefone());
                org.setOrgAtivo(orgConfig.isOrgAtivo());

                organizacaoService.save(org);
                log.info("✅ Created organization: {}", orgConfig.getOrgNome());
            } else {
                log.debug("Organization already exists: {}", orgConfig.getOrgNome());
            }
        });
    }

    private void initDefaultAdmin() {
        if (config.getDefaultAdmin() == null) {
            log.warn("No default admin configuration found");
            return;
        }

        InitialDataConfig.AdminConfig adminConfig = config.getDefaultAdmin();
        String adminEmail = adminConfig.getUsuEmail();

        // Verifica se usuário já existe
        boolean userExists = userService.findByEmail(adminEmail) != null;

        if (!userExists) {
            // Busca organização pelo ID da organização no adminConfig
            OrganizacaoInfo organizacao = null;
            
            if (adminConfig.getIdOrganizacao() != null) {
                organizacao = organizacaoService.findById(adminConfig.getIdOrganizacao());
            } else if (adminConfig.getOrganization() != null) {
                // Tenta buscar pelo nome da organização
                organizacao = organizacaoService.findById(adminConfig.getIdOrganizacao());
            }

            // Se não encontrou, usa a primeira disponível
            if (organizacao == null) {
                log.warn("Organization not found, using first available");
                List<OrganizacaoInfo> allOrganizations = organizacaoService.findAll();
                organizacao = allOrganizations.isEmpty() ? null : allOrganizations.get(0);
            }

            if (organizacao == null) {
                log.error("Cannot create admin: No organization available");
                return;
            }

            // Busca papel pelo nome (campo role)
            String roleName = adminConfig.getRole() != null ? 
                adminConfig.getRole().toUpperCase() : "ADMIN";
                
            Papel papel = papelRepository.findByPapNome(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));

            // Cria DTO de input para o usuário
            UsuarioInput usuarioInput = new UsuarioInput();
            usuarioInput.setNome(adminConfig.getUsuNome());
            usuarioInput.setEmail(adminEmail);
            usuarioInput.setSenha(adminConfig.getUsuSenha());
            usuarioInput.setAtivo(adminConfig.isUsuAtivo());
            usuarioInput.setIdPapel(papel.getId());
            usuarioInput.setIdOrganizacao(organizacao.getId());

            // Cria usuário admin
            userService.save(usuarioInput);

            log.info("========================================");
            log.info("DEFAULT ADMIN USER CREATED");
            log.info("Email: {}", adminEmail);
            log.info("Password: {}", adminConfig.getUsuSenha());
            log.info("Organization: {}", organizacao.getOrgNome());
            log.info("Role: {}", papel.getPapNome());
            log.info("========================================");

        } else {
            log.info("Admin user already exists: {}", adminEmail);
        }
    }
}