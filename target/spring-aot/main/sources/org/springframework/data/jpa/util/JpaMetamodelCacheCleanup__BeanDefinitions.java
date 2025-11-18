package org.springframework.data.jpa.util;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JpaMetamodelCacheCleanup}.
 */
@Generated
public class JpaMetamodelCacheCleanup__BeanDefinitions {
  /**
   * Get the bean definition for 'jpaMetamodelCacheCleanup'.
   */
  public static BeanDefinition getJpaMetamodelCacheCleanupBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaMetamodelCacheCleanup.class);
    beanDefinition.setInstanceSupplier(JpaMetamodelCacheCleanup::new);
    return beanDefinition;
  }
}
