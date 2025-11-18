package br.com.TrustHelp.Controller.PapelPermissao;

import br.com.TrustHelp.Service.PapelPermissao.PapelPermissaoService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PapelPermissaoController}.
 */
@Generated
public class PapelPermissaoController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'papelPermissaoController'.
   */
  private static BeanInstanceSupplier<PapelPermissaoController> getPapelPermissaoControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PapelPermissaoController>forConstructor(PapelPermissaoService.class)
            .withGenerator((registeredBean, args) -> new PapelPermissaoController(args.get(0)));
  }

  /**
   * Get the bean definition for 'papelPermissaoController'.
   */
  public static BeanDefinition getPapelPermissaoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PapelPermissaoController.class);
    beanDefinition.setInstanceSupplier(getPapelPermissaoControllerInstanceSupplier());
    return beanDefinition;
  }
}
