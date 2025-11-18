package org.springframework.boot.autoconfigure.orm.jpa;

import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.orm.jpa.persistenceunit.PersistenceManagedTypes;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Bean definitions for {@link JpaBaseConfiguration}.
 */
@Generated
public class JpaBaseConfiguration__BeanDefinitions {
  /**
   * Bean definitions for {@link JpaBaseConfiguration.PersistenceManagedTypesConfiguration}.
   */
  @Generated
  public static class PersistenceManagedTypesConfiguration {
    /**
     * Get the bean definition for 'persistenceManagedTypesConfiguration'.
     */
    public static BeanDefinition getPersistenceManagedTypesConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaBaseConfiguration.PersistenceManagedTypesConfiguration.class);
      beanDefinition.setInstanceSupplier(JpaBaseConfiguration.PersistenceManagedTypesConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance for 'persistenceManagedTypes'.
     */
    private static PersistenceManagedTypes getPersistenceManagedTypesInstance() {
      List<String> managedClassNames = List.of("br.com.TrustHelp.Model.Chamado.Chamado", "br.com.TrustHelp.Model.EmpresaAtendimento.EmpresaAtendimento", "br.com.TrustHelp.Model.Endereco.Endereco", "br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamado", "br.com.TrustHelp.Model.Organizacao.Organizacao", "br.com.TrustHelp.Model.PapelPermissao.PapelPermissao", "br.com.TrustHelp.Model.PapelPermissao.PapelPermissaoId", "br.com.TrustHelp.Model.Papel.Papel", "br.com.TrustHelp.Model.ParametroConfiguracao.ParametroConfiguracao", "br.com.TrustHelp.Model.Permissao.Permissao", "br.com.TrustHelp.Model.Telefone.Telefone", "br.com.TrustHelp.Model.User.Usuario");
      List<String> managedPackages = List.of();
      return PersistenceManagedTypes.of(managedClassNames, managedPackages);
    }

    /**
     * Get the bean definition for 'persistenceManagedTypes'.
     */
    public static BeanDefinition getPersistenceManagedTypesBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaBaseConfiguration.PersistenceManagedTypesConfiguration.class);
      beanDefinition.setTargetType(PersistenceManagedTypes.class);
      beanDefinition.setPrimary(true);
      beanDefinition.setInstanceSupplier(PersistenceManagedTypesConfiguration::getPersistenceManagedTypesInstance);
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link JpaBaseConfiguration.JpaWebConfiguration}.
   */
  @Generated
  public static class JpaWebConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration'.
     */
    private static BeanInstanceSupplier<JpaBaseConfiguration.JpaWebConfiguration> getJpaWebConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<JpaBaseConfiguration.JpaWebConfiguration>forConstructor(JpaProperties.class)
              .withGenerator((registeredBean, args) -> new JpaBaseConfiguration.JpaWebConfiguration(args.get(0)));
    }

    /**
     * Get the bean definition for 'jpaWebConfiguration'.
     */
    public static BeanDefinition getJpaWebConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaBaseConfiguration.JpaWebConfiguration.class);
      beanDefinition.setInstanceSupplier(getJpaWebConfigurationInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'openEntityManagerInViewInterceptor'.
     */
    private static BeanInstanceSupplier<OpenEntityManagerInViewInterceptor> getOpenEntityManagerInViewInterceptorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<OpenEntityManagerInViewInterceptor>forFactoryMethod(JpaBaseConfiguration.JpaWebConfiguration.class, "openEntityManagerInViewInterceptor")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration", JpaBaseConfiguration.JpaWebConfiguration.class).openEntityManagerInViewInterceptor());
    }

    /**
     * Get the bean definition for 'openEntityManagerInViewInterceptor'.
     */
    public static BeanDefinition getOpenEntityManagerInViewInterceptorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenEntityManagerInViewInterceptor.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration");
      beanDefinition.setInstanceSupplier(getOpenEntityManagerInViewInterceptorInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'openEntityManagerInViewInterceptorConfigurer'.
     */
    private static BeanInstanceSupplier<WebMvcConfigurer> getOpenEntityManagerInViewInterceptorConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<WebMvcConfigurer>forFactoryMethod(JpaBaseConfiguration.JpaWebConfiguration.class, "openEntityManagerInViewInterceptorConfigurer", OpenEntityManagerInViewInterceptor.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration", JpaBaseConfiguration.JpaWebConfiguration.class).openEntityManagerInViewInterceptorConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'openEntityManagerInViewInterceptorConfigurer'.
     */
    public static BeanDefinition getOpenEntityManagerInViewInterceptorConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(WebMvcConfigurer.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration");
      beanDefinition.setInstanceSupplier(getOpenEntityManagerInViewInterceptorConfigurerInstanceSupplier());
      return beanDefinition;
    }
  }
}
