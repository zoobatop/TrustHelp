package br.com.TrustHelp.Service.Organizacao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OrganizacaoService}.
 */
@Generated
public class OrganizacaoService__BeanDefinitions {
  /**
   * Get the bean definition for 'organizacaoService'.
   */
  public static BeanDefinition getOrganizacaoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrganizacaoService.class);
    InstanceSupplier<OrganizacaoService> instanceSupplier = InstanceSupplier.using(OrganizacaoService::new);
    instanceSupplier = instanceSupplier.andThen(OrganizacaoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
