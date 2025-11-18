package org.springframework.boot.autoconfigure.dao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

/**
 * Bean definitions for {@link PersistenceExceptionTranslationAutoConfiguration}.
 */
@Generated
public class PersistenceExceptionTranslationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'persistenceExceptionTranslationAutoConfiguration'.
   */
  public static BeanDefinition getPersistenceExceptionTranslationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PersistenceExceptionTranslationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(PersistenceExceptionTranslationAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'persistenceExceptionTranslationPostProcessor'.
   */
  private static BeanInstanceSupplier<PersistenceExceptionTranslationPostProcessor> getPersistenceExceptionTranslationPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PersistenceExceptionTranslationPostProcessor>forFactoryMethod(PersistenceExceptionTranslationAutoConfiguration.class, "persistenceExceptionTranslationPostProcessor", Environment.class)
            .withGenerator((registeredBean, args) -> PersistenceExceptionTranslationAutoConfiguration.persistenceExceptionTranslationPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'persistenceExceptionTranslationPostProcessor'.
   */
  public static BeanDefinition getPersistenceExceptionTranslationPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PersistenceExceptionTranslationAutoConfiguration.class);
    beanDefinition.setTargetType(PersistenceExceptionTranslationPostProcessor.class);
    beanDefinition.setInstanceSupplier(getPersistenceExceptionTranslationPostProcessorInstanceSupplier());
    return beanDefinition;
  }
}
