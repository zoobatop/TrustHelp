package br.com.TrustHelp.Service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class Router {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final List<String> registeredRoutes;

    public Router(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.registeredRoutes = new ArrayList<>();
    }

    public void registerController(Object controller) {
        // No Spring, os controllers são automaticamente registrados
        // Esta classe serve para gerenciar e monitorar as rotas
        scanControllerRoutes(controller);
    }

    private void scanControllerRoutes(Object controller) {
        Class<?> controllerClass = controller.getClass();
        Method[] methods = controllerClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(org.springframework.web.bind.annotation.GetMapping.class) ||
                    method.isAnnotationPresent(org.springframework.web.bind.annotation.PostMapping.class) ||
                    method.isAnnotationPresent(org.springframework.web.bind.annotation.PutMapping.class) ||
                    method.isAnnotationPresent(org.springframework.web.bind.annotation.PatchMapping.class) ||
                    method.isAnnotationPresent(org.springframework.web.bind.annotation.DeleteMapping.class) ||
                    method.isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class)) {

                String routeInfo = String.format("Controller: %s - Method: %s",
                        controllerClass.getSimpleName(), method.getName());
                registeredRoutes.add(routeInfo);
            }
        }
    }

    public List<String> getRegisteredRoutes() {
        return new ArrayList<>(registeredRoutes);
    }

    public void printRoutes() {
        System.out.println("=== REGISTERED ROUTES ===");
        registeredRoutes.forEach(route -> System.out.println("-" + route));
        System.out.println("=========================");
    }
}