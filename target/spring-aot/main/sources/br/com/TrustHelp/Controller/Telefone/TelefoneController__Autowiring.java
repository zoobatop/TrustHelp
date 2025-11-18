package br.com.TrustHelp.Controller.Telefone;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TelefoneController}.
 */
@Generated
public class TelefoneController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TelefoneController apply(RegisteredBean registeredBean,
      TelefoneController instance) {
    AutowiredFieldValueResolver.forRequiredField("telefoneService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
