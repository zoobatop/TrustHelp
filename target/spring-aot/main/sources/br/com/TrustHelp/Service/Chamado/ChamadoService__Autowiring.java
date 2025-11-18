package br.com.TrustHelp.Service.Chamado;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ChamadoService}.
 */
@Generated
public class ChamadoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ChamadoService apply(RegisteredBean registeredBean, ChamadoService instance) {
    AutowiredFieldValueResolver.forRequiredField("chamadoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
