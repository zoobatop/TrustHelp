package br.com.TrustHelp.Service.ParametroConfiguracao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ParametroConfiguracaoService}.
 */
@Generated
public class ParametroConfiguracaoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ParametroConfiguracaoService apply(RegisteredBean registeredBean,
      ParametroConfiguracaoService instance) {
    AutowiredFieldValueResolver.forRequiredField("parametroConfiguracaoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
