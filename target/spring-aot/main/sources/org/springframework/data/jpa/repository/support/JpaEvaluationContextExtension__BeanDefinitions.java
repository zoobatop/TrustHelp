package org.springframework.data.jpa.repository.support;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JpaEvaluationContextExtension}.
 */
@Generated
public class JpaEvaluationContextExtension__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.data.jpa.repository.support.JpaEvaluationContextExtension'.
   */
  private static BeanInstanceSupplier<JpaEvaluationContextExtension> getJpaEvaluationContextExtensionInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JpaEvaluationContextExtension>forConstructor(char.class)
            .withGenerator((registeredBean, args) -> new JpaEvaluationContextExtension(args.get(0)));
  }

  /**
   * Get the bean definition for 'jpaEvaluationContextExtension'.
   */
  public static BeanDefinition getJpaEvaluationContextExtensionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaEvaluationContextExtension.class);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, '\\');
    beanDefinition.setInstanceSupplier(getJpaEvaluationContextExtensionInstanceSupplier());
    return beanDefinition;
  }
}
