package br.com.TrustHelp.Service.InteracaoChamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link InteracaoChamadoService}.
 */
@Generated
public class InteracaoChamadoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static InteracaoChamadoService apply(RegisteredBean registeredBean,
      InteracaoChamadoService instance) {
    AutowiredFieldValueResolver.forRequiredField("interacaoChamadoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
