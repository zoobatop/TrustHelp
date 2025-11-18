package br.com.TrustHelp.Controller.ParametroConfiguracao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ParametroConfiguracaoController}.
 */
@Generated
public class ParametroConfiguracaoController__BeanDefinitions {
  /**
   * Get the bean definition for 'parametroConfiguracaoController'.
   */
  public static BeanDefinition getParametroConfiguracaoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ParametroConfiguracaoController.class);
    InstanceSupplier<ParametroConfiguracaoController> instanceSupplier = InstanceSupplier.using(ParametroConfiguracaoController::new);
    instanceSupplier = instanceSupplier.andThen(ParametroConfiguracaoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
