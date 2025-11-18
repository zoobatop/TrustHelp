package br.com.TrustHelp.Controller.Papel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PapelController}.
 */
@Generated
public class PapelController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PapelController apply(RegisteredBean registeredBean, PapelController instance) {
    AutowiredFieldValueResolver.forRequiredField("papelService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
