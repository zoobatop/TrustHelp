package br.com.TrustHelp;

import br.com.TrustHelp.Database.Database;
import br.com.TrustHelp.Service.Router;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link Server}.
 */
@Generated
public class Server__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'server'.
   */
  private static BeanInstanceSupplier<Server> getServerInstanceSupplier() {
    return BeanInstanceSupplier.<Server>forConstructor(Database.class, Router.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> new Server(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'server'.
   */
  public static BeanDefinition getServerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Server.class);
    beanDefinition.setInitMethodNames("initializeServices");
    beanDefinition.setInstanceSupplier(getServerInstanceSupplier());
    return beanDefinition;
  }
}
