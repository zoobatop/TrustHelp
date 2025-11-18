package org.springframework.transaction.annotation;

import java.util.Collection;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProxyTransactionManagementConfiguration}.
 */
@Generated
public class ProxyTransactionManagementConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProxyTransactionManagementConfiguration apply(RegisteredBean registeredBean,
      ProxyTransactionManagementConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setConfigurers", Collection.class).resolve(registeredBean, args -> instance.setConfigurers(args.get(0)));
    return instance;
  }
}
