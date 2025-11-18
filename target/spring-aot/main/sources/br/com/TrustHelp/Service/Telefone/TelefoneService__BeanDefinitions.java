package br.com.TrustHelp.Service.Telefone;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TelefoneService}.
 */
@Generated
public class TelefoneService__BeanDefinitions {
  /**
   * Get the bean definition for 'telefoneService'.
   */
  public static BeanDefinition getTelefoneServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TelefoneService.class);
    InstanceSupplier<TelefoneService> instanceSupplier = InstanceSupplier.using(TelefoneService::new);
    instanceSupplier = instanceSupplier.andThen(TelefoneService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
