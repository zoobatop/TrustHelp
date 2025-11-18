package br.com.TrustHelp.Controller.Chamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChamadoController}.
 */
@Generated
public class ChamadoController__BeanDefinitions {
  /**
   * Get the bean definition for 'chamadoController'.
   */
  public static BeanDefinition getChamadoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChamadoController.class);
    InstanceSupplier<ChamadoController> instanceSupplier = InstanceSupplier.using(ChamadoController::new);
    instanceSupplier = instanceSupplier.andThen(ChamadoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
