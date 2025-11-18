package br.com.TrustHelp.Service.Endereco;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EnderecoService}.
 */
@Generated
public class EnderecoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EnderecoService apply(RegisteredBean registeredBean, EnderecoService instance) {
    AutowiredFieldValueResolver.forRequiredField("enderecoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
