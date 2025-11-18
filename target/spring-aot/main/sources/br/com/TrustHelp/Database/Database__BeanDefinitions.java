package br.com.TrustHelp.Database;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link Database}.
 */
@Generated
public class Database__BeanDefinitions {
  /**
   * Get the bean definition for 'database'.
   */
  public static BeanDefinition getDatabaseBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Database.class);
    InstanceSupplier<Database> instanceSupplier = InstanceSupplier.using(Database::new);
    instanceSupplier = instanceSupplier.andThen(Database__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
