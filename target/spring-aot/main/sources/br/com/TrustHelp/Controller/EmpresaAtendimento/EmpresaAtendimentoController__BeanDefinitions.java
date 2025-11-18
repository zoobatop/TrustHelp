package br.com.TrustHelp.Controller.EmpresaAtendimento;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EmpresaAtendimentoController}.
 */
@Generated
public class EmpresaAtendimentoController__BeanDefinitions {
  /**
   * Get the bean definition for 'empresaAtendimentoController'.
   */
  public static BeanDefinition getEmpresaAtendimentoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmpresaAtendimentoController.class);
    InstanceSupplier<EmpresaAtendimentoController> instanceSupplier = InstanceSupplier.using(EmpresaAtendimentoController::new);
    instanceSupplier = instanceSupplier.andThen(EmpresaAtendimentoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
