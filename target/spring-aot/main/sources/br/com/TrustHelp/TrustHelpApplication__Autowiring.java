package br.com.TrustHelp;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TrustHelpApplication}.
 */
@Generated
public class TrustHelpApplication__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TrustHelpApplication apply(RegisteredBean registeredBean,
      TrustHelpApplication instance) {
    AutowiredFieldValueResolver.forRequiredField("server").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
