package br.com.TrustHelp.Controller.Endereco;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EnderecoController}.
 */
@Generated
public class EnderecoController__BeanDefinitions {
  /**
   * Get the bean definition for 'enderecoController'.
   */
  public static BeanDefinition getEnderecoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EnderecoController.class);
    InstanceSupplier<EnderecoController> instanceSupplier = InstanceSupplier.using(EnderecoController::new);
    instanceSupplier = instanceSupplier.andThen(EnderecoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
