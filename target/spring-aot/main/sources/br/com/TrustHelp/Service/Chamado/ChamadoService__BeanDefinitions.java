package br.com.TrustHelp.Service.Chamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChamadoService}.
 */
@Generated
public class ChamadoService__BeanDefinitions {
  /**
   * Get the bean definition for 'chamadoService'.
   */
  public static BeanDefinition getChamadoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChamadoService.class);
    InstanceSupplier<ChamadoService> instanceSupplier = InstanceSupplier.using(ChamadoService::new);
    instanceSupplier = instanceSupplier.andThen(ChamadoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
