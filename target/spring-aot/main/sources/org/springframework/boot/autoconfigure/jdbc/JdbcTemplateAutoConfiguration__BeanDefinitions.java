package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JdbcTemplateAutoConfiguration}.
 */
@Generated
public class JdbcTemplateAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jdbcTemplateAutoConfiguration'.
   */
  public static BeanDefinition getJdbcTemplateAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcTemplateAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(JdbcTemplateAutoConfiguration::new);
    return beanDefinition;
  }
}
