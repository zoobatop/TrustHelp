package br.com.TrustHelp.Controller.Organizacao;

import br.com.TrustHelp.Service.Organizacao.OrganizacaoService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OrganizacaoController}.
 */
@Generated
public class OrganizacaoController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'organizacaoController'.
   */
  private static BeanInstanceSupplier<OrganizacaoController> getOrganizacaoControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OrganizacaoController>forConstructor(OrganizacaoService.class)
            .withGenerator((registeredBean, args) -> new OrganizacaoController(args.get(0)));
  }

  /**
   * Get the bean definition for 'organizacaoController'.
   */
  public static BeanDefinition getOrganizacaoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrganizacaoController.class);
    beanDefinition.setInstanceSupplier(getOrganizacaoControllerInstanceSupplier());
    return beanDefinition;
  }
}
