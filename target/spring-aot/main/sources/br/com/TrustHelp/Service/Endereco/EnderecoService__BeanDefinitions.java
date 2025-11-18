package br.com.TrustHelp.Service.Endereco;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EnderecoService}.
 */
@Generated
public class EnderecoService__BeanDefinitions {
  /**
   * Get the bean definition for 'enderecoService'.
   */
  public static BeanDefinition getEnderecoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EnderecoService.class);
    InstanceSupplier<EnderecoService> instanceSupplier = InstanceSupplier.using(EnderecoService::new);
    instanceSupplier = instanceSupplier.andThen(EnderecoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
