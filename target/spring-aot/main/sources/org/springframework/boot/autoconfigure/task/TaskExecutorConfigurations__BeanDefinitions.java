package org.springframework.boot.autoconfigure.task;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.task.SimpleAsyncTaskExecutorBuilder;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Bean definitions for {@link TaskExecutorConfigurations}.
 */
@Generated
public class TaskExecutorConfigurations__BeanDefinitions {
  /**
   * Bean definitions for {@link TaskExecutorConfigurations.TaskExecutorConfiguration}.
   */
  @Generated
  public static class TaskExecutorConfiguration {
    /**
     * Get the bean definition for 'taskExecutorConfiguration'.
     */
    public static BeanDefinition getTaskExecutorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.TaskExecutorConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskExecutorConfigurations.TaskExecutorConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'applicationTaskExecutor'.
     */
    private static BeanInstanceSupplier<ThreadPoolTaskExecutor> getApplicationTaskExecutorInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ThreadPoolTaskExecutor>forFactoryMethod(TaskExecutorConfigurations.TaskExecutorConfiguration.class, "applicationTaskExecutor", ThreadPoolTaskExecutorBuilder.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$TaskExecutorConfiguration", TaskExecutorConfigurations.TaskExecutorConfiguration.class).applicationTaskExecutor(args.get(0)));
    }

    /**
     * Get the bean definition for 'applicationTaskExecutor'.
     */
    public static BeanDefinition getApplicationTaskExecutorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ThreadPoolTaskExecutor.class);
      beanDefinition.setLazyInit(true);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$TaskExecutorConfiguration");
      beanDefinition.setInstanceSupplier(getApplicationTaskExecutorInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskExecutorConfigurations.BootstrapExecutorConfiguration}.
   */
  @Generated
  public static class BootstrapExecutorConfiguration {
    /**
     * Get the bean definition for 'bootstrapExecutorConfiguration'.
     */
    public static BeanDefinition getBootstrapExecutorConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.BootstrapExecutorConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskExecutorConfigurations.BootstrapExecutorConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean definition for 'bootstrapExecutorAliasPostProcessor'.
     */
    public static BeanDefinition getBootstrapExecutorAliasPostProcessorBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.BootstrapExecutorConfiguration.class);
      beanDefinition.setTargetType(BeanFactoryPostProcessor.class);
      beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<BeanFactoryPostProcessor>forFactoryMethod(TaskExecutorConfigurations.BootstrapExecutorConfiguration.class, "bootstrapExecutorAliasPostProcessor").withGenerator((registeredBean) -> TaskExecutorConfigurations.BootstrapExecutorConfiguration.bootstrapExecutorAliasPostProcessor()));
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration}.
   */
  @Generated
  public static class ThreadPoolTaskExecutorBuilderConfiguration {
    /**
     * Get the bean definition for 'threadPoolTaskExecutorBuilderConfiguration'.
     */
    public static BeanDefinition getThreadPoolTaskExecutorBuilderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'threadPoolTaskExecutorBuilder'.
     */
    private static BeanInstanceSupplier<ThreadPoolTaskExecutorBuilder> getThreadPoolTaskExecutorBuilderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ThreadPoolTaskExecutorBuilder>forFactoryMethod(TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration.class, "threadPoolTaskExecutorBuilder", TaskExecutionProperties.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$ThreadPoolTaskExecutorBuilderConfiguration", TaskExecutorConfigurations.ThreadPoolTaskExecutorBuilderConfiguration.class).threadPoolTaskExecutorBuilder(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'threadPoolTaskExecutorBuilder'.
     */
    public static BeanDefinition getThreadPoolTaskExecutorBuilderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ThreadPoolTaskExecutorBuilder.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$ThreadPoolTaskExecutorBuilderConfiguration");
      beanDefinition.setInstanceSupplier(getThreadPoolTaskExecutorBuilderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration}.
   */
  @Generated
  public static class SimpleAsyncTaskExecutorBuilderConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration'.
     */
    private static BeanInstanceSupplier<TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration> getSimpleAsyncTaskExecutorBuilderConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration>forConstructor(TaskExecutionProperties.class, ObjectProvider.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'simpleAsyncTaskExecutorBuilderConfiguration'.
     */
    public static BeanDefinition getSimpleAsyncTaskExecutorBuilderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration.class);
      beanDefinition.setInstanceSupplier(getSimpleAsyncTaskExecutorBuilderConfigurationInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'simpleAsyncTaskExecutorBuilder'.
     */
    private static BeanInstanceSupplier<SimpleAsyncTaskExecutorBuilder> getSimpleAsyncTaskExecutorBuilderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SimpleAsyncTaskExecutorBuilder>forFactoryMethod(TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration.class, "simpleAsyncTaskExecutorBuilder")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration", TaskExecutorConfigurations.SimpleAsyncTaskExecutorBuilderConfiguration.class).simpleAsyncTaskExecutorBuilder());
    }

    /**
     * Get the bean definition for 'simpleAsyncTaskExecutorBuilder'.
     */
    public static BeanDefinition getSimpleAsyncTaskExecutorBuilderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleAsyncTaskExecutorBuilder.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration");
      beanDefinition.setInstanceSupplier(getSimpleAsyncTaskExecutorBuilderInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link TaskExecutorConfigurations.AsyncConfigurerConfiguration}.
   */
  @Generated
  public static class AsyncConfigurerConfiguration {
    /**
     * Get the bean definition for 'asyncConfigurerConfiguration'.
     */
    public static BeanDefinition getAsyncConfigurerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskExecutorConfigurations.AsyncConfigurerConfiguration.class);
      beanDefinition.setInstanceSupplier(TaskExecutorConfigurations.AsyncConfigurerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'applicationTaskExecutorAsyncConfigurer'.
     */
    private static BeanInstanceSupplier<AsyncConfigurer> getApplicationTaskExecutorAsyncConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<AsyncConfigurer>forFactoryMethod(TaskExecutorConfigurations.AsyncConfigurerConfiguration.class, "applicationTaskExecutorAsyncConfigurer", BeanFactory.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$AsyncConfigurerConfiguration", TaskExecutorConfigurations.AsyncConfigurerConfiguration.class).applicationTaskExecutorAsyncConfigurer(args.get(0)));
    }

    /**
     * Get the bean definition for 'applicationTaskExecutorAsyncConfigurer'.
     */
    public static BeanDefinition getApplicationTaskExecutorAsyncConfigurerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(AsyncConfigurer.class);
      beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$AsyncConfigurerConfiguration");
      beanDefinition.setInstanceSupplier(getApplicationTaskExecutorAsyncConfigurerInstanceSupplier());
      return beanDefinition;
    }
  }
}
