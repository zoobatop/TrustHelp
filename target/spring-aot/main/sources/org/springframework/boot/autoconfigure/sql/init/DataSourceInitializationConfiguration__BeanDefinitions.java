package org.springframework.boot.autoconfigure.sql.init;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceInitializationConfiguration}.
 */
@Generated
public class DataSourceInitializationConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceInitializationConfiguration'.
   */
  public static BeanDefinition getDataSourceInitializationConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceInitializationConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourceInitializationConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dataSourceScriptDatabaseInitializer'.
   */
  private static BeanInstanceSupplier<SqlDataSourceScriptDatabaseInitializer> getDataSourceScriptDatabaseInitializerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SqlDataSourceScriptDatabaseInitializer>forFactoryMethod(DataSourceInitializationConfiguration.class, "dataSourceScriptDatabaseInitializer", DataSource.class, SqlInitializationProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.sql.init.DataSourceInitializationConfiguration", DataSourceInitializationConfiguration.class).dataSourceScriptDatabaseInitializer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'dataSourceScriptDatabaseInitializer'.
   */
  public static BeanDefinition getDataSourceScriptDatabaseInitializerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SqlDataSourceScriptDatabaseInitializer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.sql.init.DataSourceInitializationConfiguration");
    beanDefinition.setInstanceSupplier(getDataSourceScriptDatabaseInitializerInstanceSupplier());
    return beanDefinition;
  }
}
