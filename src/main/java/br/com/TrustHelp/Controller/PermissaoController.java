package br.com.TrustHelp.Controller;

import br.com.TrustHelp.Record.PermissaoDTO;
import br.com.TrustHelp.Record.PermissaoRequest;
import br.com.TrustHelp.Service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permissao")
public class PermissaoController extends BaseController {
    private final PermissaoService permissaoService;

    public PermissaoController(final PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarTodos() {
        return success(permissaoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoDTO> buscarPorId(@PathVariable int id) {
        return permissaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PermissaoDTO> criar(@RequestBody  PermissaoRequest request) {
        PermissaoDTO dto = permissaoService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable int id, @RequestBody PermissaoRequest request) {
        return permissaoService.atualizar(id, request)
                .map(permissao -> success(permissao, "Permissao atualizada"))
                .orElse(notFound(""));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable int id) {
        if (permissaoService.deletar(id)) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Permissão deletada com sucesso");
            response.put("timestamp", System.currentTimeMillis());
            return success(response, "Permissão deletado com sucesso");
        }
        return notFound("Permissão não encontrado com ID: " + id);
    }

    /*
     * Teste de Api api/permissao/ping
     */
    @GetMapping("/ping")
    public ResponseEntity<Map<String, Object>> ping() {
        Map<String, Object> response = Map.of(
                "status", HttpStatus.OK.value(),
                "message", HttpStatus.OK.getReasonPhrase()
        );
        return success(response, "Ping permissao route");
    }

}
