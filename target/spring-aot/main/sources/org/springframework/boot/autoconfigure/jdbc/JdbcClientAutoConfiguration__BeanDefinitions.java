package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link JdbcClientAutoConfiguration}.
 */
@Generated
public class JdbcClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jdbcClientAutoConfiguration'.
   */
  public static BeanDefinition getJdbcClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(JdbcClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jdbcClient'.
   */
  private static BeanInstanceSupplier<JdbcClient> getJdbcClientInstanceSupplier() {
    return BeanInstanceSupplier.<JdbcClient>forFactoryMethod(JdbcClientAutoConfiguration.class, "jdbcClient", NamedParameterJdbcTemplate.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.jdbc.JdbcClientAutoConfiguration", JdbcClientAutoConfiguration.class).jdbcClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'jdbcClient'.
   */
  public static BeanDefinition getJdbcClientBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcClient.class);
    beanDefinition.setDependsOn("dataSourceScriptDatabaseInitializer");
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.jdbc.JdbcClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getJdbcClientInstanceSupplier());
    return beanDefinition;
  }
}
