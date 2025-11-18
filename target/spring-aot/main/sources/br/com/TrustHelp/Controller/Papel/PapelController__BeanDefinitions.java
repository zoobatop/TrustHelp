package br.com.TrustHelp.Controller.Papel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PapelController}.
 */
@Generated
public class PapelController__BeanDefinitions {
  /**
   * Get the bean definition for 'papelController'.
   */
  public static BeanDefinition getPapelControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PapelController.class);
    InstanceSupplier<PapelController> instanceSupplier = InstanceSupplier.using(PapelController::new);
    instanceSupplier = instanceSupplier.andThen(PapelController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
