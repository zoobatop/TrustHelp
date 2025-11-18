package org.springframework.boot.autoconfigure.data.web;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.data.web.config.SortHandlerMethodArgumentResolverCustomizer;
import org.springframework.data.web.config.SpringDataWebSettings;

/**
 * Bean definitions for {@link SpringDataWebAutoConfiguration}.
 */
@Generated
public class SpringDataWebAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration'.
   */
  private static BeanInstanceSupplier<SpringDataWebAutoConfiguration> getSpringDataWebAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDataWebAutoConfiguration>forConstructor(SpringDataWebProperties.class)
            .withGenerator((registeredBean, args) -> new SpringDataWebAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'springDataWebAutoConfiguration'.
   */
  public static BeanDefinition getSpringDataWebAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataWebAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getSpringDataWebAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'pageableCustomizer'.
   */
  private static BeanInstanceSupplier<PageableHandlerMethodArgumentResolverCustomizer> getPageableCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PageableHandlerMethodArgumentResolverCustomizer>forFactoryMethod(SpringDataWebAutoConfiguration.class, "pageableCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration", SpringDataWebAutoConfiguration.class).pageableCustomizer());
  }

  /**
   * Get the bean definition for 'pageableCustomizer'.
   */
  public static BeanDefinition getPageableCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PageableHandlerMethodArgumentResolverCustomizer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration");
    beanDefinition.setInstanceSupplier(getPageableCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sortCustomizer'.
   */
  private static BeanInstanceSupplier<SortHandlerMethodArgumentResolverCustomizer> getSortCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SortHandlerMethodArgumentResolverCustomizer>forFactoryMethod(SpringDataWebAutoConfiguration.class, "sortCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration", SpringDataWebAutoConfiguration.class).sortCustomizer());
  }

  /**
   * Get the bean definition for 'sortCustomizer'.
   */
  public static BeanDefinition getSortCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SortHandlerMethodArgumentResolverCustomizer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration");
    beanDefinition.setInstanceSupplier(getSortCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springDataWebSettings'.
   */
  private static BeanInstanceSupplier<SpringDataWebSettings> getSpringDataWebSettingsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDataWebSettings>forFactoryMethod(SpringDataWebAutoConfiguration.class, "springDataWebSettings")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration", SpringDataWebAutoConfiguration.class).springDataWebSettings());
  }

  /**
   * Get the bean definition for 'springDataWebSettings'.
   */
  public static BeanDefinition getSpringDataWebSettingsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataWebSettings.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration");
    beanDefinition.setInstanceSupplier(getSpringDataWebSettingsInstanceSupplier());
    return beanDefinition;
  }
}
