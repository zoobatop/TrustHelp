package org.springframework.boot.autoconfigure.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.env.Environment;

/**
 * Bean definitions for {@link DataSourceConfiguration}.
 */
@Generated
public class DataSourceConfiguration__BeanDefinitions {
  /**
   * Bean definitions for {@link DataSourceConfiguration.Hikari}.
   */
  @Generated
  public static class Hikari {
    /**
     * Get the bean definition for 'hikari'.
     */
    public static BeanDefinition getHikariBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceConfiguration.Hikari.class);
      beanDefinition.setInstanceSupplier(DataSourceConfiguration.Hikari::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'jdbcConnectionDetailsHikariBeanPostProcessor'.
     */
    private static BeanInstanceSupplier<HikariJdbcConnectionDetailsBeanPostProcessor> getJdbcConnectionDetailsHikariBeanPostProcessorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HikariJdbcConnectionDetailsBeanPostProcessor>forFactoryMethod(DataSourceConfiguration.Hikari.class, "jdbcConnectionDetailsHikariBeanPostProcessor", ObjectProvider.class)
              .withGenerator((registeredBean, args) -> DataSourceConfiguration.Hikari.jdbcConnectionDetailsHikariBeanPostProcessor(args.get(0)));
    }

    /**
     * Get the bean definition for 'jdbcConnectionDetailsHikariBeanPostProcessor'.
     */
    public static BeanDefinition getJdbcConnectionDetailsHikariBeanPostProcessorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceConfiguration.Hikari.class);
      beanDefinition.setTargetType(HikariJdbcConnectionDetailsBeanPostProcessor.class);
      beanDefinition.setInstanceSupplier(getJdbcConnectionDetailsHikariBeanPostProcessorInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'dataSource'.
     */
    private static BeanInstanceSupplier<HikariDataSource> getDataSourceInstanceSupplier() {
      return BeanInstanceSupplier.<HikariDataSource>forFactoryMethod(DataSourceConfiguration.Hikari.class, "dataSource", DataSourceProperties.class, JdbcConnectionDetails.class, Environment.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Hikari", DataSourceConfiguration.Hikari.class).dataSource(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'dataSource'.
     */
    public static BeanDefinition getDataSourceBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(HikariDataSource.class);
      beanDefinition.setDestroyMethodNames("close");
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Hikari");
      beanDefinition.setInstanceSupplier(getDataSourceInstanceSupplier());
      return beanDefinition;
    }
  }
}
