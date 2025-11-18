package br.com.TrustHelp.Controller.Health;

import br.com.TrustHelp.Server;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HealthController}.
 */
@Generated
public class HealthController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'healthController'.
   */
  private static BeanInstanceSupplier<HealthController> getHealthControllerInstanceSupplier() {
    return BeanInstanceSupplier.<HealthController>forConstructor(Server.class)
            .withGenerator((registeredBean, args) -> new HealthController(args.get(0)));
  }

  /**
   * Get the bean definition for 'healthController'.
   */
  public static BeanDefinition getHealthControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HealthController.class);
    beanDefinition.setInstanceSupplier(getHealthControllerInstanceSupplier());
    return beanDefinition;
  }
}
