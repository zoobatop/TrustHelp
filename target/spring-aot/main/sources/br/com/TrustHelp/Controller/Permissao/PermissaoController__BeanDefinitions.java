package br.com.TrustHelp.Controller.Permissao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PermissaoController}.
 */
@Generated
public class PermissaoController__BeanDefinitions {
  /**
   * Get the bean definition for 'permissaoController'.
   */
  public static BeanDefinition getPermissaoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PermissaoController.class);
    InstanceSupplier<PermissaoController> instanceSupplier = InstanceSupplier.using(PermissaoController::new);
    instanceSupplier = instanceSupplier.andThen(PermissaoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
