package org.springframework.data.web.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.geo.GeoModule;

/**
 * Bean definitions for {@link SpringDataJacksonConfiguration}.
 */
@Generated
public class SpringDataJacksonConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDataJacksonConfiguration'.
   */
  public static BeanDefinition getSpringDataJacksonConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataJacksonConfiguration.class);
    InstanceSupplier<SpringDataJacksonConfiguration> instanceSupplier = InstanceSupplier.using(SpringDataJacksonConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(SpringDataJacksonConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jacksonGeoModule'.
   */
  private static BeanInstanceSupplier<GeoModule> getJacksonGeoModuleInstanceSupplier() {
    return BeanInstanceSupplier.<GeoModule>forFactoryMethod(SpringDataJacksonConfiguration.class, "jacksonGeoModule")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.data.web.config.SpringDataJacksonConfiguration", SpringDataJacksonConfiguration.class).jacksonGeoModule());
  }

  /**
   * Get the bean definition for 'jacksonGeoModule'.
   */
  public static BeanDefinition getJacksonGeoModuleBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GeoModule.class);
    beanDefinition.setFactoryBeanName("org.springframework.data.web.config.SpringDataJacksonConfiguration");
    beanDefinition.setInstanceSupplier(getJacksonGeoModuleInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'pageModule'.
   */
  private static BeanInstanceSupplier<SpringDataJacksonConfiguration.PageModule> getPageModuleInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDataJacksonConfiguration.PageModule>forFactoryMethod(SpringDataJacksonConfiguration.class, "pageModule")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.data.web.config.SpringDataJacksonConfiguration", SpringDataJacksonConfiguration.class).pageModule());
  }

  /**
   * Get the bean definition for 'pageModule'.
   */
  public static BeanDefinition getPageModuleBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDataJacksonConfiguration.PageModule.class);
    beanDefinition.setFactoryBeanName("org.springframework.data.web.config.SpringDataJacksonConfiguration");
    beanDefinition.setInstanceSupplier(getPageModuleInstanceSupplier());
    return beanDefinition;
  }
}
