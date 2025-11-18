package br.com.TrustHelp.Service.EmpresaAtendimento;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EmpresaAtendimentoService}.
 */
@Generated
public class EmpresaAtendimentoService__BeanDefinitions {
  /**
   * Get the bean definition for 'empresaAtendimentoService'.
   */
  public static BeanDefinition getEmpresaAtendimentoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmpresaAtendimentoService.class);
    InstanceSupplier<EmpresaAtendimentoService> instanceSupplier = InstanceSupplier.using(EmpresaAtendimentoService::new);
    instanceSupplier = instanceSupplier.andThen(EmpresaAtendimentoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
