package org.springframework.boot.autoconfigure.http.client;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HttpClientProperties}.
 */
@Generated
public class HttpClientProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'httpClientProperties'.
   */
  public static BeanDefinition getHttpClientPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HttpClientProperties.class);
    beanDefinition.setInstanceSupplier(HttpClientProperties::new);
    return beanDefinition;
  }
}
