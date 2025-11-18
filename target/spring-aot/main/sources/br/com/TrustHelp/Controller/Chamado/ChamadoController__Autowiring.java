package br.com.TrustHelp.Controller.Chamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ChamadoController}.
 */
@Generated
public class ChamadoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ChamadoController apply(RegisteredBean registeredBean, ChamadoController instance) {
    AutowiredFieldValueResolver.forRequiredField("chamadoService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
