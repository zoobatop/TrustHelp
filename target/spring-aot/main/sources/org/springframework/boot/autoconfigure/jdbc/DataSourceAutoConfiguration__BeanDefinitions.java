package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceAutoConfiguration}.
 */
@Generated
public class DataSourceAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceAutoConfiguration'.
   */
  public static BeanDefinition getDataSourceAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourceAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DataSourceAutoConfiguration.PooledDataSourceConfiguration}.
   */
  @Generated
  public static class PooledDataSourceConfiguration {
    /**
     * Get the bean definition for 'pooledDataSourceConfiguration'.
     */
    public static BeanDefinition getPooledDataSourceConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceAutoConfiguration.PooledDataSourceConfiguration.class);
      beanDefinition.setInstanceSupplier(DataSourceAutoConfiguration.PooledDataSourceConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'jdbcConnectionDetails'.
     */
    private static BeanInstanceSupplier<PropertiesJdbcConnectionDetails> getJdbcConnectionDetailsInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<PropertiesJdbcConnectionDetails>forFactoryMethod(DataSourceAutoConfiguration.PooledDataSourceConfiguration.class, "jdbcConnectionDetails", DataSourceProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$PooledDataSourceConfiguration", DataSourceAutoConfiguration.PooledDataSourceConfiguration.class).jdbcConnectionDetails(args.get(0)));
    }

    /**
     * Get the bean definition for 'jdbcConnectionDetails'.
     */
    public static BeanDefinition getJdbcConnectionDetailsBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(PropertiesJdbcConnectionDetails.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$PooledDataSourceConfiguration");
      beanDefinition.setInstanceSupplier(getJdbcConnectionDetailsInstanceSupplier());
      return beanDefinition;
    }
  }
}
