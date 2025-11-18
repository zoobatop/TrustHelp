package org.springframework.boot.autoconfigure.orm.jpa;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HibernateJpaAutoConfiguration}.
 */
@Generated
public class HibernateJpaAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'hibernateJpaAutoConfiguration'.
   */
  public static BeanDefinition getHibernateJpaAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HibernateJpaAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(HibernateJpaAutoConfiguration::new);
    return beanDefinition;
  }
}
