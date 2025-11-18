package br.com.TrustHelp.Service.InteracaoChamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link InteracaoChamadoService}.
 */
@Generated
public class InteracaoChamadoService__BeanDefinitions {
  /**
   * Get the bean definition for 'interacaoChamadoService'.
   */
  public static BeanDefinition getInteracaoChamadoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(InteracaoChamadoService.class);
    InstanceSupplier<InteracaoChamadoService> instanceSupplier = InstanceSupplier.using(InteracaoChamadoService::new);
    instanceSupplier = instanceSupplier.andThen(InteracaoChamadoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
