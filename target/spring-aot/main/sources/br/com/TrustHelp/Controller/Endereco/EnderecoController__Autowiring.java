package br.com.TrustHelp.Controller.Endereco;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EnderecoController}.
 */
@Generated
public class EnderecoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EnderecoController apply(RegisteredBean registeredBean,
      EnderecoController instance) {
    AutowiredFieldValueResolver.forRequiredField("enderecoService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
