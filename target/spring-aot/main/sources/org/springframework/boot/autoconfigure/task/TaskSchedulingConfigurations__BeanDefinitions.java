package org.springframework.boot.autoconfigure.task;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.task.SimpleAsyncTaskSchedulerBuilder;
import org.springframework.boot.task.ThreadPoolTaskSchedulerBuilder;

/**
 * Bean definitions for {@link TaskSchedulingConfigurations}.
 */
@Generated
public class TaskSchedulingConfigurations__BeanDefinitions {
  /**
   * Bean definitions for {@link TaskSchedulingConfigurations.ThreadPoolTaskSchedulerBuilderConfiguration}.
   */
  @Generated
  public static class ThreadPoolTaskSchedulerBuilderConfiguration {
    /**
     * Get the bean definition for 'threadPoolTaskSchedulerBuilderConfiguration'.
     */
    public static BeanDefinition getThreadPoolTaskSchedulerBuilderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskSchedulingConfigurations.ThreadPoolTaskSchedulerBuilderConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskSchedulingConfigurations.ThreadPoolTaskSchedulerBuilderConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'threadPoolTaskSchedulerBuilder'.
     */
    private static BeanInstanceSupplier<ThreadPoolTaskSchedulerBuilder> getThreadPoolTaskSchedulerBuilderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ThreadPoolTaskSchedulerBuilder>forFactoryMethod(TaskSchedulingConfigurations.ThreadPoolTaskSchedulerBuilderConfiguration.class, "threadPoolTaskSchedulerBuilder", TaskSchedulingProperties.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$ThreadPoolTaskSchedulerBuilderConfiguration", TaskSchedulingConfigurations.ThreadPoolTaskSchedulerBuilderConfiguration.class).threadPoolTaskSchedulerBuilder(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'threadPoolTaskSchedulerBuilder'.
     */
    public static BeanDefinition getThreadPoolTaskSchedulerBuilderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ThreadPoolTaskSchedulerBuilder.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$ThreadPoolTaskSchedulerBuilderConfiguration");
      beanDefinition.setInstanceSupplier(getThreadPoolTaskSchedulerBuilderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskSchedulingConfigurations.SimpleAsyncTaskSchedulerBuilderConfiguration}.
   */
  @Generated
  public static class SimpleAsyncTaskSchedulerBuilderConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration'.
     */
    private static BeanInstanceSupplier<TaskSchedulingConfigurations.SimpleAsyncTaskSchedulerBuilderConfiguration> getSimpleAsyncTaskSchedulerBuilderConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<TaskSchedulingConfigurations.SimpleAsyncTaskSchedulerBuilderConfiguration>forConstructor(TaskSchedulingProperties.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new TaskSchedulingConfigurations.SimpleAsyncTaskSchedulerBuilderConfiguration(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'simpleAsyncTaskSchedulerBuilderConfiguration'.
     */
    public static BeanDefinition getSimpleAsyncTaskSchedulerBuilderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskSchedulingConfigurations.SimpleAsyncTaskSchedulerBuilderConfiguration.class);
      beanDefinition.setInstanceSupplier(getSimpleAsyncTaskSchedulerBuilderConfigurationInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'simpleAsyncTaskSchedulerBuilder'.
     */
    private static BeanInstanceSupplier<SimpleAsyncTaskSchedulerBuilder> getSimpleAsyncTaskSchedulerBuilderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SimpleAsyncTaskSchedulerBuilder>forFactoryMethod(TaskSchedulingConfigurations.SimpleAsyncTaskSchedulerBuilderConfiguration.class, "simpleAsyncTaskSchedulerBuilder")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration", TaskSchedulingConfigurations.SimpleAsyncTaskSchedulerBuilderConfiguration.class).simpleAsyncTaskSchedulerBuilder());
    }

    /**
     * Get the bean definition for 'simpleAsyncTaskSchedulerBuilder'.
     */
    public static BeanDefinition getSimpleAsyncTaskSchedulerBuilderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleAsyncTaskSchedulerBuilder.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration");
      beanDefinition.setInstanceSupplier(getSimpleAsyncTaskSchedulerBuilderInstanceSupplier());
      return beanDefinition;
    }
  }
}
