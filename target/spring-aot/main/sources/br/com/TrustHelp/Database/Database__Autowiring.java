package br.com.TrustHelp.Database;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link Database}.
 */
@Generated
public class Database__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static Database apply(RegisteredBean registeredBean, Database instance) {
    AutowiredFieldValueResolver.forRequiredField("url").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("username").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("password").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
