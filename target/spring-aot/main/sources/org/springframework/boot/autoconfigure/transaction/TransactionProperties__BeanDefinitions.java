package org.springframework.boot.autoconfigure.transaction;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TransactionProperties}.
 */
@Generated
public class TransactionProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'transactionProperties'.
   */
  public static BeanDefinition getTransactionPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionProperties.class);
    beanDefinition.setInstanceSupplier(TransactionProperties::new);
    return beanDefinition;
  }
}
