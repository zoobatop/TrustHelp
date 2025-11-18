package br.com.TrustHelp.Service.PapelPermissao;

import br.com.TrustHelp.Repository.PapelPermissaoRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PapelPermissaoService}.
 */
@Generated
public class PapelPermissaoService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'papelPermissaoService'.
   */
  private static BeanInstanceSupplier<PapelPermissaoService> getPapelPermissaoServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PapelPermissaoService>forConstructor(PapelPermissaoRepository.class)
            .withGenerator((registeredBean, args) -> new PapelPermissaoService(args.get(0)));
  }

  /**
   * Get the bean definition for 'papelPermissaoService'.
   */
  public static BeanDefinition getPapelPermissaoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PapelPermissaoService.class);
    beanDefinition.setInstanceSupplier(getPapelPermissaoServiceInstanceSupplier());
    return beanDefinition;
  }
}
