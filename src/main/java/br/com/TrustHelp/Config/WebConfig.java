package br.com.TrustHelp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;
    
    private static final String GLOBAL_PREFIX = "";

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        System.out.println("=== CONFIGURANDO PATH MATCH ===");
        
        // Log de todos os controllers encontrados
        String[] controllerNames = applicationContext.getBeanNamesForAnnotation(
            org.springframework.web.bind.annotation.RestController.class);
        
        System.out.println("Controllers encontrados (" + controllerNames.length + "):");
        for (String name : controllerNames) {
            Object bean = applicationContext.getBean(name);
            System.out.println("  - " + name + " (" + bean.getClass().getName() + ")");
        }
        
        configurer.addPathPrefix(GLOBAL_PREFIX,
                clazz -> {
                    boolean isController = clazz.isAnnotationPresent(org.springframework.web.bind.annotation.RestController.class)
                            || clazz.isAnnotationPresent(org.springframework.stereotype.Controller.class);
                    
                    if (isController) {
                        System.out.println("Adicionando prefixo /api para: " + clazz.getName());
                    }
                    return isController;
                });
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("*");
    }
}