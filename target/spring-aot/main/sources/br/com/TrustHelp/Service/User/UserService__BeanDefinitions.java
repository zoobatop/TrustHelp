package br.com.TrustHelp.Service.User;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserService}.
 */
@Generated
public class UserService__BeanDefinitions {
  /**
   * Get the bean definition for 'userService'.
   */
  public static BeanDefinition getUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserService.class);
    InstanceSupplier<UserService> instanceSupplier = InstanceSupplier.using(UserService::new);
    instanceSupplier = instanceSupplier.andThen(UserService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
