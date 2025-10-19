package br.com.TrustHelp.Controller;

import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    protected ResponseEntity<Map<String, Object>> success(Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", data);
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }

    protected ResponseEntity<Map<String, Object>> success(Object data, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", data);
        response.put("message", message);
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }

    protected ResponseEntity<Map<String, Object>> error(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("error", message);
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.badRequest().body(response);
    }

    protected ResponseEntity<Map<String, Object>> notFound(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("error", message);
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.notFound().build();
    }
}