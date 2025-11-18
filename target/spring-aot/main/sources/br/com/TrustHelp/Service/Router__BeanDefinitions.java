package br.com.TrustHelp.Service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Bean definitions for {@link Router}.
 */
@Generated
public class Router__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'router'.
   */
  private static BeanInstanceSupplier<Router> getRouterInstanceSupplier() {
    return BeanInstanceSupplier.<Router>forConstructor(RequestMappingHandlerMapping.class)
            .withGenerator((registeredBean, args) -> new Router(args.get(0)));
  }

  /**
   * Get the bean definition for 'router'.
   */
  public static BeanDefinition getRouterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Router.class);
    beanDefinition.setInstanceSupplier(getRouterInstanceSupplier());
    return beanDefinition;
  }
}
