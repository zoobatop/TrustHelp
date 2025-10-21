package br.com.TrustHelp.Controller;

import br.com.TrustHelp.Record.TelefoneDTO;
import br.com.TrustHelp.Record.TelefoneRequest;
import br.com.TrustHelp.Service.TelefoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/telefone")
public class TelefoneController extends BaseController {
    private final TelefoneService telefoneService;

    public TelefoneController(final TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarTodos() {
        List<TelefoneDTO> telefones = telefoneService.listarTodos();
        return success(telefones, "Telefones listados com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscarPorId(@PathVariable int id) {
        return telefoneService.buscarPorId(id)
                .map(telefone -> success(telefone, "Telefone encontrado"))
                .orElse(notFound("Telefone não encontrado com ID: " + id));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criar(@RequestBody TelefoneRequest request) {
        TelefoneDTO dto = telefoneService.criar(request);
        Map<String, Object> response = new HashMap<>();
        response.put("telefone", dto);
        response.put("message", "Telefone criado com sucesso");

        return success(response, "Telefone criado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable int id, @RequestBody TelefoneRequest request) {
        return telefoneService.atualizar(id, request)
                .map(telefone -> success(telefone, "Telefone atualizado com sucesso"))
                .orElse(notFound("Telefone não encontrado com ID: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable int id) {
        if (telefoneService.deletar(id)) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Telefone deletado com sucesso");
            response.put("timestamp", System.currentTimeMillis());
            return success(response, "Telefone deletado com sucesso");
        }
        return notFound("Telefone não encontrado com ID: " + id);
    }

    /*
     * Teste de Api api/telefone/ping
     */
    @GetMapping("/ping")
    public ResponseEntity<Map<String, Object>> ping() {
        Map<String, Object> response = Map.of(
                "status", HttpStatus.OK.value(),
                "message", HttpStatus.OK.getReasonPhrase()
        );
        return success(response, "Ping telefone route");
    }
}