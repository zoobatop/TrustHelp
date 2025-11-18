package org.springframework.boot.autoconfigure.data.jpa;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.LazyInitializationExcludeFilter;

/**
 * Bean definitions for {@link JpaRepositoriesAutoConfiguration}.
 */
@Generated
public class JpaRepositoriesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jpaRepositoriesAutoConfiguration'.
   */
  public static BeanDefinition getJpaRepositoriesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaRepositoriesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(JpaRepositoriesAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'eagerJpaMetamodelCacheCleanup'.
   */
  public static BeanDefinition getEagerJpaMetamodelCacheCleanupBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaRepositoriesAutoConfiguration.class);
    beanDefinition.setTargetType(LazyInitializationExcludeFilter.class);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<LazyInitializationExcludeFilter>forFactoryMethod(JpaRepositoriesAutoConfiguration.class, "eagerJpaMetamodelCacheCleanup").withGenerator((registeredBean) -> JpaRepositoriesAutoConfiguration.eagerJpaMetamodelCacheCleanup()));
    return beanDefinition;
  }
}
