package br.com.TrustHelp.Service.Permissao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PermissaoService}.
 */
@Generated
public class PermissaoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PermissaoService apply(RegisteredBean registeredBean, PermissaoService instance) {
    AutowiredFieldValueResolver.forRequiredField("permissaoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
