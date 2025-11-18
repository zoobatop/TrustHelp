package org.springframework.boot.autoconfigure.jdbc.metadata;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;

/**
 * Bean definitions for {@link DataSourcePoolMetadataProvidersConfiguration}.
 */
@Generated
public class DataSourcePoolMetadataProvidersConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourcePoolMetadataProvidersConfiguration'.
   */
  public static BeanDefinition getDataSourcePoolMetadataProvidersConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetadataProvidersConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourcePoolMetadataProvidersConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration}.
   */
  @Generated
  public static class HikariPoolDataSourceMetadataProviderConfiguration {
    /**
     * Get the bean definition for 'hikariPoolDataSourceMetadataProviderConfiguration'.
     */
    public static BeanDefinition getHikariPoolDataSourceMetadataProviderConfigurationBeanDefinition(
        ) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration.class);
      beanDefinition.setInstanceSupplier(DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'hikariPoolDataSourceMetadataProvider'.
     */
    private static BeanInstanceSupplier<DataSourcePoolMetadataProvider> getHikariPoolDataSourceMetadataProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<DataSourcePoolMetadataProvider>forFactoryMethod(DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration.class, "hikariPoolDataSourceMetadataProvider")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration", DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration.class).hikariPoolDataSourceMetadataProvider());
    }

    /**
     * Get the bean definition for 'hikariPoolDataSourceMetadataProvider'.
     */
    public static BeanDefinition getHikariPoolDataSourceMetadataProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourcePoolMetadataProvider.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration");
      beanDefinition.setInstanceSupplier(getHikariPoolDataSourceMetadataProviderInstanceSupplier());
      return beanDefinition;
    }
  }
}
