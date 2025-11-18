package br.com.TrustHelp.Controller.Permissao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PermissaoController}.
 */
@Generated
public class PermissaoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PermissaoController apply(RegisteredBean registeredBean,
      PermissaoController instance) {
    AutowiredFieldValueResolver.forRequiredField("permissaoService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
