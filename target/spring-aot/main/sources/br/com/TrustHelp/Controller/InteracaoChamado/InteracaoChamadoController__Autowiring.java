package br.com.TrustHelp.Controller.InteracaoChamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link InteracaoChamadoController}.
 */
@Generated
public class InteracaoChamadoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static InteracaoChamadoController apply(RegisteredBean registeredBean,
      InteracaoChamadoController instance) {
    AutowiredFieldValueResolver.forRequiredField("interacaoChamadoService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
