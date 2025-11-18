package br.com.TrustHelp.Service.Organizacao;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link OrganizacaoService}.
 */
@Generated
public class OrganizacaoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static OrganizacaoService apply(RegisteredBean registeredBean,
      OrganizacaoService instance) {
    AutowiredFieldValueResolver.forRequiredField("organizacaoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
