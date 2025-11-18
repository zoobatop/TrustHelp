package br.com.TrustHelp.Controller.InteracaoChamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InteracaoChamadoController}.
 */
@Generated
public class InteracaoChamadoController__BeanDefinitions {
  /**
   * Get the bean definition for 'interacaoChamadoController'.
   */
  public static BeanDefinition getInteracaoChamadoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(InteracaoChamadoController.class);
    InstanceSupplier<InteracaoChamadoController> instanceSupplier = InstanceSupplier.using(InteracaoChamadoController::new);
    instanceSupplier = instanceSupplier.andThen(InteracaoChamadoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
