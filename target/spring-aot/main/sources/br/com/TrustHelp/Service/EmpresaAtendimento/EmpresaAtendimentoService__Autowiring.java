package br.com.TrustHelp.Service.EmpresaAtendimento;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EmpresaAtendimentoService}.
 */
@Generated
public class EmpresaAtendimentoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EmpresaAtendimentoService apply(RegisteredBean registeredBean,
      EmpresaAtendimentoService instance) {
    AutowiredFieldValueResolver.forRequiredField("empresaAtendimentoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
