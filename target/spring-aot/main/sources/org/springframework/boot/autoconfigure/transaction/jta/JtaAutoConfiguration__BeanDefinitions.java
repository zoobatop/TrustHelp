package org.springframework.boot.autoconfigure.transaction.jta;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JtaAutoConfiguration}.
 */
@Generated
public class JtaAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jtaAutoConfiguration'.
   */
  public static BeanDefinition getJtaAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JtaAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(JtaAutoConfiguration::new);
    return beanDefinition;
  }
}
