package br.com.TrustHelp;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TrustHelpApplication}.
 */
@Generated
public class TrustHelpApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'trustHelpApplication'.
   */
  public static BeanDefinition getTrustHelpApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TrustHelpApplication.class);
    InstanceSupplier<TrustHelpApplication> instanceSupplier = InstanceSupplier.using(TrustHelpApplication::new);
    instanceSupplier = instanceSupplier.andThen(TrustHelpApplication__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
