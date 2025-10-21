package br.com.TrustHelp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    public UserController() {}

    /*
    * Teste de Api Users
    */
    @GetMapping("/ping")
    public ResponseEntity<Map<String, Object>> ping() {
        Map<String, Object> response = Map.of(
                "status", HttpStatus.OK.value(),
                "message", HttpStatus.OK.getReasonPhrase()
        );
        return success(response,"Ping user route");
    }

}