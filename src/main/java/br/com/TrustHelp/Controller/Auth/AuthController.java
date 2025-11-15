package br.com.TrustHelp.Controller.Auth;

import br.com.TrustHelp.Controller.BaseController;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Model.User.UsuarioInfo;
import br.com.TrustHelp.Service.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController extends BaseController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint de cadastro
    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, Object>> cadastro(@RequestBody Usuario usuario) {
        try {
            UsuarioInfo savedUsuario = userService.save(usuario);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Usuário cadastrado com sucesso!");
            response.put("usuario", savedUsuario);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return error(e.getMessage());
        } catch (Exception e) {
            return error("Erro interno ao cadastrar usuário: " + e.getMessage());
        }
    }

    // Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        try {
            UsuarioInfo usuario = userService.findByEmail(request.getEmail());

            if (usuario == null) {
                return error("Usuário não encontrado");
            }

            // Aqui você deve verificar a senha (implementar lógica de hash/bcrypt)
            // Por enquanto, exemplo simplificado:
            if (!verificarSenha(request.getSenha(), usuario)) {
                return error("Senha incorreta");
            }

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Login realizado com sucesso!");
            response.put("usuario", usuario);
            response.put("token", gerarToken(usuario)); // Implementar JWT se necessário

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return error("Erro interno ao realizar login: " + e.getMessage());
        }
    }

    // Métodos auxiliares (implementar conforme sua lógica)
    private boolean verificarSenha(String senhaInformada, UsuarioInfo usuario) {
        // Implementar verificação com BCrypt ou similar
        return true; // placeholder
    }

    private String gerarToken(UsuarioInfo usuario) {
        // Implementar geração de JWT se necessário
        return "token_exemplo"; // placeholder
    }
}

// Classe auxiliar para o request de login
class LoginRequest {
    private String email;
    private String senha;

    // Getters e Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
