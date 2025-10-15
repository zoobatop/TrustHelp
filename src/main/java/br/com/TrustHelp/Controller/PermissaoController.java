package br.com.TrustHelp.Controller;

import br.com.TrustHelp.Record.PermissaoDTO;
import br.com.TrustHelp.Record.PermissaoRequest;
import br.com.TrustHelp.Service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissoes")
@Validated
public class PermissaoController {
    private final PermissaoService permissaoService;

    public PermissaoController(final PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @GetMapping
    public ResponseEntity<List<PermissaoDTO>> listarTodos() {
        return ResponseEntity.ok(permissaoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoDTO> buscarPorId(@PathVariable int id) {
        return permissaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PermissaoDTO> criar(@RequestBody @Validated PermissaoRequest request) {
        PermissaoDTO dto = permissaoService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissaoDTO> atualizar(@PathVariable int id, @RequestBody @Validated PermissaoRequest request) {
        return permissaoService.atualizar(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (permissaoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
