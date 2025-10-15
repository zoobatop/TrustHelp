package br.com.TrustHelp.Controller;

import br.com.TrustHelp.Record.UserDTO;
import br.com.TrustHelp.Record.UserRequest;
import br.com.TrustHelp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
@Validated
public class UserController {

    private final UserService userService;
    public UserController (UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> listarUsers() {
        return ResponseEntity.ok(userService.listarTodos());
    }
    @PostMapping
    public ResponseEntity<UserDTO> criarUser(@RequestBody @Validated UserRequest request) {
        UserDTO user = userService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}