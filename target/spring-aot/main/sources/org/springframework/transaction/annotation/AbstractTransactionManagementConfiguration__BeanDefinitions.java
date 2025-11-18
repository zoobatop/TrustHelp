package org.springframework.transaction.annotation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.transaction.event.TransactionalEventListenerFactory;

/**
 * Bean definitions for {@link AbstractTransactionManagementConfiguration}.
 */
@Generated
public class AbstractTransactionManagementConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'internalTransactionalEventListenerFactory'.
   */
  public static BeanDefinition getInternalTransactionalEventListenerFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProxyTransactionManagementConfiguration.class);
    beanDefinition.setTargetType(TransactionalEventListenerFactory.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<TransactionalEventListenerFactory>forFactoryMethod(AbstractTransactionManagementConfiguration.class, "transactionalEventListenerFactory").withGenerator((registeredBean) -> AbstractTransactionManagementConfiguration.transactionalEventListenerFactory()));
    return beanDefinition;
  }
}
