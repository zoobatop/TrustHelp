package br.com.TrustHelp.Controller.Health;

import br.com.TrustHelp.Controller.BaseController;
import br.com.TrustHelp.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController extends BaseController {

    private final Server server;

    @Autowired
    public HealthController(@Lazy Server server) {
        this.server = server;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> healthCheck() {
        boolean isOkay = server.isHealthy();
        boolean databaseConnected = server.getDatabase().isConnected();

        Map<String, Object> healthStatus = Map.of(
                "status", isOkay ? "UP" : "DOWN",
                "database", databaseConnected ? "CONNECTED" : "DISCONNECTED",
                "timestamp", System.currentTimeMillis()
        );

        return success(healthStatus, "Health check completed");
    }

    @GetMapping("/routes")
    public ResponseEntity<Map<String, Object>> getRoutes() {
        return success(server.getRouter().getRegisteredRoutes(), "Registered routes");
    }
}