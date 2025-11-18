package org.springframework.data.web.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SpringDataJacksonConfiguration}.
 */
@Generated
public class SpringDataJacksonConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SpringDataJacksonConfiguration apply(RegisteredBean registeredBean,
      SpringDataJacksonConfiguration instance) {
    instance.settings = AutowiredFieldValueResolver.forField("settings").resolve(registeredBean);
    return instance;
  }
}
