package br.com.TrustHelp.Controller.User;

import br.com.TrustHelp.Controller.BaseController;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Model.User.UsuarioInfo;
import br.com.TrustHelp.Service.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioInfo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioInfo> findById(@PathVariable Integer id) {
        UsuarioInfo usuario = service.findById(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody Usuario usuario) {
        try {
            UsuarioInfo savedUsuario = service.save(usuario);
            return success(savedUsuario);
        } catch (IllegalArgumentException e) {
            return error(e.getMessage());
        } catch (Exception e) {
            return error("Erro interno ao salvar usuário: " + e.getMessage());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioInfo> findByEmail(@PathVariable String email) {
        UsuarioInfo usuario = service.findByEmail(email);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }
}