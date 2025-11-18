package org.springframework.web.servlet.config.annotation;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DelegatingWebMvcConfiguration}.
 */
@Generated
public class DelegatingWebMvcConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DelegatingWebMvcConfiguration apply(RegisteredBean registeredBean,
      DelegatingWebMvcConfiguration instance) {
    AutowiredMethodArgumentsResolver.forMethod("setConfigurers", List.class).resolve(registeredBean, args -> instance.setConfigurers(args.get(0)));
    return instance;
  }
}
