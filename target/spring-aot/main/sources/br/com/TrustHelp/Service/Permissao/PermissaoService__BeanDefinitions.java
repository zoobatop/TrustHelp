package br.com.TrustHelp.Service.Permissao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PermissaoService}.
 */
@Generated
public class PermissaoService__BeanDefinitions {
  /**
   * Get the bean definition for 'permissaoService'.
   */
  public static BeanDefinition getPermissaoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PermissaoService.class);
    InstanceSupplier<PermissaoService> instanceSupplier = InstanceSupplier.using(PermissaoService::new);
    instanceSupplier = instanceSupplier.andThen(PermissaoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
