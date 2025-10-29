package br.com.TrustHelp.Controller.PapelPermissao;

import br.com.TrustHelp.Model.PapelPermissao.PapelPermissaoInfo;
import br.com.TrustHelp.Model.PapelPermissao.PapelPermissao;
import br.com.TrustHelp.Service.PapelPermissao.PapelPermissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/papel-permissoes")
@RequiredArgsConstructor
public class PapelPermissaoController {

    private final PapelPermissaoService service;

    @GetMapping
    public ResponseEntity<List<PapelPermissaoInfo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/papel/{idPapel}")
    public ResponseEntity<List<PapelPermissaoInfo>> listarPorPapel(@PathVariable Integer idPapel) {
        return ResponseEntity.ok(service.listarPorPapel(idPapel));
    }

    @GetMapping("/{idPapel}/{idPermissao}")
    public ResponseEntity<PapelPermissaoInfo> buscarPorId(
            @PathVariable Integer idPapel,
            @PathVariable Integer idPermissao
    ) {
        return service.buscarPorId(idPapel, idPermissao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PapelPermissao> salvar(@RequestBody PapelPermissao papelPermissao) {
        return ResponseEntity.ok(service.salvar(papelPermissao));
    }

    @DeleteMapping("/{idPapel}/{idPermissao}")
    public ResponseEntity<Void> deletar(
            @PathVariable Integer idPapel,
            @PathVariable Integer idPermissao
    ) {
        service.deletar(idPapel, idPermissao);
        return ResponseEntity.noContent().build();
    }
}
