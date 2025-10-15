package br.com.TrustHelp.Controller;

import br.com.TrustHelp.Record.TelefoneDTO;
import br.com.TrustHelp.Record.TelefoneRequest;
import br.com.TrustHelp.Service.TelefoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/telefones")
@Validated
public class TelefoneController {
    private final TelefoneService telefoneService;

    public TelefoneController(final TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> listarTodos() {
        return ResponseEntity.ok(telefoneService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> buscarPorId(@PathVariable int id) {
        return telefoneService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TelefoneDTO> criar(@RequestBody @Validated TelefoneRequest request) {
        TelefoneDTO dto = telefoneService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> atualizar(@PathVariable int id, @RequestBody @Validated TelefoneRequest request) {
        return telefoneService.atualizar(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (telefoneService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
