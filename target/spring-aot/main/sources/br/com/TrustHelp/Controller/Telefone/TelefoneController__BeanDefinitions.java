package br.com.TrustHelp.Controller.Telefone;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TelefoneController}.
 */
@Generated
public class TelefoneController__BeanDefinitions {
  /**
   * Get the bean definition for 'telefoneController'.
   */
  public static BeanDefinition getTelefoneControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TelefoneController.class);
    InstanceSupplier<TelefoneController> instanceSupplier = InstanceSupplier.using(TelefoneController::new);
    instanceSupplier = instanceSupplier.andThen(TelefoneController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
