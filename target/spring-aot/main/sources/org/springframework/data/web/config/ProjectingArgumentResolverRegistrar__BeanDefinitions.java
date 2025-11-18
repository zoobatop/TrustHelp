package org.springframework.data.web.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProjectingArgumentResolverRegistrar}.
 */
@Generated
public class ProjectingArgumentResolverRegistrar__BeanDefinitions {
  /**
   * Get the bean definition for 'projectingArgumentResolverRegistrar'.
   */
  public static BeanDefinition getProjectingArgumentResolverRegistrarBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProjectingArgumentResolverRegistrar.class);
    beanDefinition.setInstanceSupplier(ProjectingArgumentResolverRegistrar::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'projectingArgumentResolverBeanPostProcessor'.
   */
  private static BeanInstanceSupplier<ProjectingArgumentResolverRegistrar.ProjectingArgumentResolverBeanPostProcessor> getProjectingArgumentResolverBeanPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ProjectingArgumentResolverRegistrar.ProjectingArgumentResolverBeanPostProcessor>forFactoryMethod(ProjectingArgumentResolverRegistrar.class, "projectingArgumentResolverBeanPostProcessor", ObjectFactory.class)
            .withGenerator((registeredBean, args) -> ProjectingArgumentResolverRegistrar.projectingArgumentResolverBeanPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'projectingArgumentResolverBeanPostProcessor'.
   */
  public static BeanDefinition getProjectingArgumentResolverBeanPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProjectingArgumentResolverRegistrar.class);
    beanDefinition.setTargetType(ProjectingArgumentResolverRegistrar.ProjectingArgumentResolverBeanPostProcessor.class);
    beanDefinition.setInstanceSupplier(getProjectingArgumentResolverBeanPostProcessorInstanceSupplier());
    return beanDefinition;
  }
}
