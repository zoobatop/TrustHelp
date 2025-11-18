package br.com.TrustHelp.Service.Papel;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PapelService}.
 */
@Generated
public class PapelService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PapelService apply(RegisteredBean registeredBean, PapelService instance) {
    AutowiredFieldValueResolver.forRequiredField("papelRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
