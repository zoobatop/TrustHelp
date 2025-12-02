package br.com.TrustHelp.Controller.Auth;

import br.com.TrustHelp.Controller.BaseController;
import br.com.TrustHelp.Model.Auth.LoginRequest;
import br.com.TrustHelp.Model.Auth.LoginResponse;
import br.com.TrustHelp.Model.Auth.RegisterRequest;
import br.com.TrustHelp.Model.Auth.RegisterResponse;
import br.com.TrustHelp.Service.Auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Validação básica
            if (loginRequest.getEmail() == null || loginRequest.getEmail().trim().isEmpty()) {
                return error("Email é obrigatório");
            }
            
            if (loginRequest.getSenha() == null || loginRequest.getSenha().trim().isEmpty()) {
                return error("Senha é obrigatória");
            }
            
            LoginResponse response = authService.login(loginRequest);
            
            if (response.getToken() == null) {
                return unauthorized(response.getMensagem());
            }
            
            return success(response, response.getMensagem());
            
        } catch (Exception e) {
            return internalError("Erro no login: " + e.getMessage(), "AUTH_001");
        }
    }

       @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequest registerRequest) {
        try {
            // Validação básica
            if (registerRequest.getNome() == null || registerRequest.getNome().trim().isEmpty()) {
                return error("Nome é obrigatório");
            }
            
            if (registerRequest.getEmail() == null || registerRequest.getEmail().trim().isEmpty()) {
                return error("Email é obrigatório");
            }
            
            if (registerRequest.getSenha() == null || registerRequest.getSenha().trim().isEmpty()) {
                return error("Senha é obrigatória");
            }
            
            if (registerRequest.getConfirmarSenha() == null || registerRequest.getConfirmarSenha().trim().isEmpty()) {
                return error("Confirmação de senha é obrigatória");
            }
            
            if (!registerRequest.getSenha().equals(registerRequest.getConfirmarSenha())) {
                return error("As senhas não coincidem");
            }
            
            if (registerRequest.getSenha().length() < 6) {
                return error("A senha deve ter pelo menos 6 caracteres");
            }
            
            // Processa o registro
            RegisterResponse response = authService.register(registerRequest);
            
            if (!response.isSucesso()) {
                return error(response.getMensagem());
            }
            
            return success(response, response.getMensagem());
            
        } catch (Exception e) {
            return internalError("Erro no registro: " + e.getMessage(), "AUTH_003");
        }
    }
    
    // Endpoint para verificar disponibilidade de email
    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Object>> checkEmail(@RequestParam String email) {
        try {
            if (email == null || email.trim().isEmpty()) {
                return error("Email é obrigatório");
            }
            
            // Verifica se email já está em uso
            boolean emailExists = authService.checkEmailExists(email.trim().toLowerCase());
            
            Map<String, Object> result = Map.of(
                "disponivel", !emailExists,
                "mensagem", emailExists ? "Email já cadastrado" : "Email disponível"
            );
            
            return success(result, emailExists ? "Email já em uso" : "Email disponível");
            
        } catch (Exception e) {
            return internalError("Erro ao verificar email: " + e.getMessage(), "AUTH_004");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(@RequestHeader(value = "Authorization", required = false) String token) {
        try {
            // Em uma implementação real, você invalidaria o token aqui
            return success(null, "Logout realizado com sucesso");
        } catch (Exception e) {
            return internalError("Erro no logout: " + e.getMessage(), "AUTH_002");
        }
    }
    
    @GetMapping("/check")
    public ResponseEntity<Map<String, Object>> checkToken(@RequestHeader(value = "Authorization", required = false) String token) {
        try {
            if (token == null || !token.startsWith("Bearer ")) {
                return unauthorized("Token inválido ou não fornecido");
            }
            
            // Aqui você validaria o token
            // Por enquanto, apenas retorna sucesso se o token existir
            return success(null, "Token válido");
            
        } catch (Exception e) {
            return unauthorized("Token inválido: " + e.getMessage());
        }
    }
}