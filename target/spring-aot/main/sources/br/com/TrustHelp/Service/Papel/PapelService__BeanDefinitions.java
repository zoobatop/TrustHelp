package br.com.TrustHelp.Service.Papel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PapelService}.
 */
@Generated
public class PapelService__BeanDefinitions {
  /**
   * Get the bean definition for 'papelService'.
   */
  public static BeanDefinition getPapelServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PapelService.class);
    InstanceSupplier<PapelService> instanceSupplier = InstanceSupplier.using(PapelService::new);
    instanceSupplier = instanceSupplier.andThen(PapelService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
