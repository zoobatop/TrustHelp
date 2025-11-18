package org.springframework.boot.autoconfigure.jdbc;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Bean definitions for {@link JdbcTemplateConfiguration}.
 */
@Generated
public class JdbcTemplateConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jdbcTemplateConfiguration'.
   */
  public static BeanDefinition getJdbcTemplateConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcTemplateConfiguration.class);
    beanDefinition.setInstanceSupplier(JdbcTemplateConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jdbcTemplate'.
   */
  private static BeanInstanceSupplier<JdbcTemplate> getJdbcTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<JdbcTemplate>forFactoryMethod(JdbcTemplateConfiguration.class, "jdbcTemplate", DataSource.class, JdbcProperties.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.jdbc.JdbcTemplateConfiguration", JdbcTemplateConfiguration.class).jdbcTemplate(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'jdbcTemplate'.
   */
  public static BeanDefinition getJdbcTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcTemplate.class);
    beanDefinition.setDependsOn("dataSourceScriptDatabaseInitializer");
    beanDefinition.setPrimary(true);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.jdbc.JdbcTemplateConfiguration");
    beanDefinition.setInstanceSupplier(getJdbcTemplateInstanceSupplier());
    return beanDefinition;
  }
}
