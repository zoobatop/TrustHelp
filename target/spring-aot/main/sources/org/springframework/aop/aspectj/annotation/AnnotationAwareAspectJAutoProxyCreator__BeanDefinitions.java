package org.springframework.aop.aspectj.annotation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AnnotationAwareAspectJAutoProxyCreator}.
 */
@Generated
public class AnnotationAwareAspectJAutoProxyCreator__BeanDefinitions {
  /**
   * Get the bean definition for 'internalAutoProxyCreator'.
   */
  public static BeanDefinition getInternalAutoProxyCreatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AnnotationAwareAspectJAutoProxyCreator.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getPropertyValues().addPropertyValue("order", -2147483648);
    beanDefinition.getPropertyValues().addPropertyValue("proxyTargetClass", true);
    beanDefinition.setInstanceSupplier(AnnotationAwareAspectJAutoProxyCreator::new);
    return beanDefinition;
  }
}
