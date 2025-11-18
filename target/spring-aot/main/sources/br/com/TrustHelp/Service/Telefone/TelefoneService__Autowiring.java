package br.com.TrustHelp.Service.Telefone;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TelefoneService}.
 */
@Generated
public class TelefoneService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TelefoneService apply(RegisteredBean registeredBean, TelefoneService instance) {
    AutowiredFieldValueResolver.forRequiredField("telefoneRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("usuarioRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
