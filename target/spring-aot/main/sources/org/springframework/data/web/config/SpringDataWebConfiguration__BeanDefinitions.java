package org.springframework.data.web.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.data.web.OffsetScrollPositionHandlerMethodArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;

/**
 * Bean definitions for {@link SpringDataWebConfiguration}.
 */
@Generated
public class SpringDataWebConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.data.web.config.SpringDataWebConfiguration'.
   */
  private static BeanInstanceSupplier<SpringDataWebConfiguration> getSpringDataWebConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDataWebConfiguration>forConstructor(ApplicationContext.class, ObjectFactory.class)
            .withGenerator((registeredBean, args) -> new SpringDataWebConfiguration(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'springDataWebConfiguration'.
   */
  public static BeanDefinition getSpringDataWebConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataWebConfiguration.class);
    beanDefinition.setInstanceSupplier(getSpringDataWebConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'pageableResolver'.
   */
  private static BeanInstanceSupplier<PageableHandlerMethodArgumentResolver> getPageableResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PageableHandlerMethodArgumentResolver>forFactoryMethod(SpringDataWebConfiguration.class, "pageableResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.data.web.config.SpringDataWebConfiguration", SpringDataWebConfiguration.class).pageableResolver());
  }

  /**
   * Get the bean definition for 'pageableResolver'.
   */
  public static BeanDefinition getPageableResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PageableHandlerMethodArgumentResolver.class);
    beanDefinition.setFactoryBeanName("org.springframework.data.web.config.SpringDataWebConfiguration");
    beanDefinition.setInstanceSupplier(getPageableResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sortResolver'.
   */
  private static BeanInstanceSupplier<SortHandlerMethodArgumentResolver> getSortResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SortHandlerMethodArgumentResolver>forFactoryMethod(SpringDataWebConfiguration.class, "sortResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.data.web.config.SpringDataWebConfiguration", SpringDataWebConfiguration.class).sortResolver());
  }

  /**
   * Get the bean definition for 'sortResolver'.
   */
  public static BeanDefinition getSortResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SortHandlerMethodArgumentResolver.class);
    beanDefinition.setFactoryBeanName("org.springframework.data.web.config.SpringDataWebConfiguration");
    beanDefinition.setInstanceSupplier(getSortResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'offsetResolver'.
   */
  private static BeanInstanceSupplier<OffsetScrollPositionHandlerMethodArgumentResolver> getOffsetResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OffsetScrollPositionHandlerMethodArgumentResolver>forFactoryMethod(SpringDataWebConfiguration.class, "offsetResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.data.web.config.SpringDataWebConfiguration", SpringDataWebConfiguration.class).offsetResolver());
  }

  /**
   * Get the bean definition for 'offsetResolver'.
   */
  public static BeanDefinition getOffsetResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OffsetScrollPositionHandlerMethodArgumentResolver.class);
    beanDefinition.setFactoryBeanName("org.springframework.data.web.config.SpringDataWebConfiguration");
    beanDefinition.setInstanceSupplier(getOffsetResolverInstanceSupplier());
    return beanDefinition;
  }
}
