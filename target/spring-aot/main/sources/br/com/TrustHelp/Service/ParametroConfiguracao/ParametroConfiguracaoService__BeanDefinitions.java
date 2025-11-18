package br.com.TrustHelp.Service.ParametroConfiguracao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ParametroConfiguracaoService}.
 */
@Generated
public class ParametroConfiguracaoService__BeanDefinitions {
  /**
   * Get the bean definition for 'parametroConfiguracaoService'.
   */
  public static BeanDefinition getParametroConfiguracaoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ParametroConfiguracaoService.class);
    InstanceSupplier<ParametroConfiguracaoService> instanceSupplier = InstanceSupplier.using(ParametroConfiguracaoService::new);
    instanceSupplier = instanceSupplier.andThen(ParametroConfiguracaoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
