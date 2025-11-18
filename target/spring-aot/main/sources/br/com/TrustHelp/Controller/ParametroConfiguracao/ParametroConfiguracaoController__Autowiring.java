package br.com.TrustHelp.Controller.ParametroConfiguracao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ParametroConfiguracaoController}.
 */
@Generated
public class ParametroConfiguracaoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ParametroConfiguracaoController apply(RegisteredBean registeredBean,
      ParametroConfiguracaoController instance) {
    AutowiredFieldValueResolver.forRequiredField("parametroConfiguracaoService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
