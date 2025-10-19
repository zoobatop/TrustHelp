package br.com.TrustHelp;

import br.com.TrustHelp.Database.Database;
import br.com.TrustHelp.Service.Router;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.Map;

@Getter
@Service
public class Server {

    private final Database database;
    private final Router router;
    private final ApplicationContext applicationContext;

    @Autowired
    public Server(Database database, Router router, ApplicationContext applicationContext) {
        this.database = database;
        this.router = router;
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void initializeServices() {
        System.out.println("Inicializando serviços do servidor...");

        checkHealth();

        System.out.println("Servidor inicializado com sucesso!");
    }

    public void registerAllControllers() {
        Map<String, Object> controllers = applicationContext.getBeansWithAnnotation(
                org.springframework.web.bind.annotation.RestController.class);

        controllers.values().forEach(controller -> {
            if (!controller.getClass().getSimpleName().equals("HealthController")) {
                router.registerController(controller);
            }
        });

        System.out.println(controllers.size() + " controllers registrados");
    }

    private void checkHealth() {
        if (database.isConnected()) {
            System.out.println("Database conectado com sucesso!");
        } else {
            System.out.println("Falha na conexão com o database!");
        }
    }

    public boolean isHealthy() {
        try {
            return database.isConnected();
        } catch (Exception e) {
            return false;
        }
    }
}