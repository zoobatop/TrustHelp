package br.com.TrustHelp.Controller.User;

import br.com.TrustHelp.Service.User.UserService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserController}.
 */
@Generated
public class UserController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userController'.
   */
  private static BeanInstanceSupplier<UserController> getUserControllerInstanceSupplier() {
    return BeanInstanceSupplier.<UserController>forConstructor(UserService.class)
            .withGenerator((registeredBean, args) -> new UserController(args.get(0)));
  }

  /**
   * Get the bean definition for 'userController'.
   */
  public static BeanDefinition getUserControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserController.class);
    beanDefinition.setInstanceSupplier(getUserControllerInstanceSupplier());
    return beanDefinition;
  }
}
