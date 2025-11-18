package org.springframework.boot.autoconfigure.transaction;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Bean definitions for {@link TransactionAutoConfiguration}.
 */
@Generated
public class TransactionAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'transactionAutoConfiguration'.
   */
  public static BeanDefinition getTransactionAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TransactionAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link TransactionAutoConfiguration.TransactionTemplateConfiguration}.
   */
  @Generated
  public static class TransactionTemplateConfiguration {
    /**
     * Get the bean definition for 'transactionTemplateConfiguration'.
     */
    public static BeanDefinition getTransactionTemplateConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.TransactionTemplateConfiguration.class);
      beanDefinition.setInstanceSupplier(TransactionAutoConfiguration.TransactionTemplateConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'transactionTemplate'.
     */
    private static BeanInstanceSupplier<TransactionTemplate> getTransactionTemplateInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<TransactionTemplate>forFactoryMethod(TransactionAutoConfiguration.TransactionTemplateConfiguration.class, "transactionTemplate", PlatformTransactionManager.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$TransactionTemplateConfiguration", TransactionAutoConfiguration.TransactionTemplateConfiguration.class).transactionTemplate(args.get(0)));
    }

    /**
     * Get the bean definition for 'transactionTemplate'.
     */
    public static BeanDefinition getTransactionTemplateBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionTemplate.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$TransactionTemplateConfiguration");
      beanDefinition.setInstanceSupplier(getTransactionTemplateInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TransactionAutoConfiguration.EnableTransactionManagementConfiguration}.
   */
  @Generated
  public static class EnableTransactionManagementConfiguration {
    /**
     * Get the bean definition for 'enableTransactionManagementConfiguration'.
     */
    public static BeanDefinition getEnableTransactionManagementConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.EnableTransactionManagementConfiguration.class);
      beanDefinition.setInstanceSupplier(TransactionAutoConfiguration.EnableTransactionManagementConfiguration::new);
      return beanDefinition;
    }

    /**
     * Bean definitions for {@link TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration}.
     */
    @Generated
    public static class CglibAutoProxyConfiguration {
      /**
       * Get the bean definition for 'cglibAutoProxyConfiguration'.
       */
      public static BeanDefinition getCglibAutoProxyConfigurationBeanDefinition() {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration.class);
        beanDefinition.setInstanceSupplier(TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration::new);
        return beanDefinition;
      }
    }
  }
}
