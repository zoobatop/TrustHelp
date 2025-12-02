package br.com.TrustHelp.Config.Initialization;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "initialization")
public class InitialDataConfig {
    
    private boolean enabled = true;
    private boolean createDefaults = true;
    
    private List<RoleConfig> roles;
    private List<OrganizationConfig> organizations;
    private AdminConfig defaultAdmin;
    
    @Data
    public static class RoleConfig {
        private String papNome; // 'admin', 'analista', 'cliente'
        private String papDescricao;
        private List<String> permissions;
        private boolean systemRole = false;
        private int level = 99;
    }
    
    @Data
    public static class PermissionConfig {
        private String perNome; // 'abrir_chamado', 'atender_chamado', 'gerenciar_usuarios'
        private String perDescricao;
    }
    
    @Data
    public static class RolePermissionConfig {
        private Integer idPapel;
        private Integer idPermissao;
    }
    
    @Data
    public static class OrganizationConfig {
        private String orgNome;
        private String orgCnpj;
        private String orgEmail;
        private String orgTelefone;
        private String orgDescricao;
        private String orgDominio;
        private String orgEndereco;
        private boolean orgAtivo = true;
        private Map<String, Object> settings;
    }
    
    @Data
    public static class UserConfig {
        private String usuNome;
        private String usuEmail;
        private String usuSenha;
        private boolean usuAtivo = true;
        private Integer idPapel;
        private Integer idOrganizacao;
        private boolean forcePasswordChange = true;
    }
    
    @Data
    public static class AdminConfig extends UserConfig {
        private String role;
        private String organization;
    }
}