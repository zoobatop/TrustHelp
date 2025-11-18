package org.springframework.boot.autoconfigure.transaction;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TransactionManagerCustomizationAutoConfiguration}.
 */
@Generated
public class TransactionManagerCustomizationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'transactionManagerCustomizationAutoConfiguration'.
   */
  public static BeanDefinition getTransactionManagerCustomizationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionManagerCustomizationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TransactionManagerCustomizationAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'platformTransactionManagerCustomizers'.
   */
  private static BeanInstanceSupplier<TransactionManagerCustomizers> getPlatformTransactionManagerCustomizersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TransactionManagerCustomizers>forFactoryMethod(TransactionManagerCustomizationAutoConfiguration.class, "platformTransactionManagerCustomizers", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration", TransactionManagerCustomizationAutoConfiguration.class).platformTransactionManagerCustomizers(args.get(0)));
  }

  /**
   * Get the bean definition for 'platformTransactionManagerCustomizers'.
   */
  public static BeanDefinition getPlatformTransactionManagerCustomizersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionManagerCustomizers.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration");
    beanDefinition.setInstanceSupplier(getPlatformTransactionManagerCustomizersInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'transactionExecutionListeners'.
   */
  private static BeanInstanceSupplier<ExecutionListenersTransactionManagerCustomizer> getTransactionExecutionListenersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ExecutionListenersTransactionManagerCustomizer>forFactoryMethod(TransactionManagerCustomizationAutoConfiguration.class, "transactionExecutionListeners", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration", TransactionManagerCustomizationAutoConfiguration.class).transactionExecutionListeners(args.get(0)));
  }

  /**
   * Get the bean definition for 'transactionExecutionListeners'.
   */
  public static BeanDefinition getTransactionExecutionListenersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExecutionListenersTransactionManagerCustomizer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration");
    beanDefinition.setInstanceSupplier(getTransactionExecutionListenersInstanceSupplier());
    return beanDefinition;
  }
}
