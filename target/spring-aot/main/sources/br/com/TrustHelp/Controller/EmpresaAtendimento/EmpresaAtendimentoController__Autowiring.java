package br.com.TrustHelp.Controller.EmpresaAtendimento;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EmpresaAtendimentoController}.
 */
@Generated
public class EmpresaAtendimentoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EmpresaAtendimentoController apply(RegisteredBean registeredBean,
      EmpresaAtendimentoController instance) {
    AutowiredFieldValueResolver.forRequiredField("empresaAtendimentoService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
