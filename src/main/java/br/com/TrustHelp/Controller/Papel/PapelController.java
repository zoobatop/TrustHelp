package br.com.TrustHelp.Controller.Papel;

import br.com.TrustHelp.Model.Papel.Papel;
import br.com.TrustHelp.Service.Papel.PapelService;
import br.com.TrustHelp.Controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/papeis")
public class PapelController extends BaseController {

    @Autowired
    private PapelService papelService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllPapeis() {
        try {
            List<Papel> papeis = papelService.findAll();
            if (papeis.isEmpty()) {
                return success(papeis, "Nenhum papel encontrado");
            }
            return success(papeis, "Papéis recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar papéis: " + e.getMessage(), "PAPEL_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getPapelById(@PathVariable Integer id) {
        try {
            Optional<Papel> papel = papelService.findById(id);
            if (papel.isPresent()) {
                return success(papel.get(), "Papel encontrado com sucesso");
            }
            return notFound("Papel", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar papel: " + e.getMessage(), "PAPEL_002");
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Map<String, Object>> getPapelByNome(@PathVariable String nome) {
        try {
            Optional<Papel> papel = papelService.findByNome(nome);
            if (papel.isPresent()) {
                return success(papel.get(), "Papel encontrado com sucesso");
            }
            return notFound("Papel com nome '" + nome + "' não encontrado");
        } catch (Exception e) {
            return internalError("Erro ao buscar papel por nome: " + e.getMessage(), "PAPEL_003");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Map<String, Object>> searchPapeis(@RequestParam String nome) {
        try {
            List<Papel> papeis = papelService.findByNomeContaining(nome);
            if (papeis.isEmpty()) {
                return success(papeis, "Nenhum papel encontrado com o termo: " + nome);
            }
            return success(papeis, "Papéis encontrados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar papéis: " + e.getMessage(), "PAPEL_004");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPapel(@RequestBody Papel papel) {
        try {
            // Validações
            if (papel.getPapNome() == null || papel.getPapNome().trim().isEmpty()) {
                return error("Nome do papel é obrigatório", "PAPEL_005");
            }

            // Verificar se já existe papel com mesmo nome
            if (papelService.existsByNome(papel.getPapNome())) {
                return conflict("Já existe um papel com o nome: " + papel.getPapNome());
            }

            Papel novoPapel = papelService.save(papel);
            return created(novoPapel, "Papel criado com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PAPEL_006");
        } catch (Exception e) {
            return internalError("Erro ao criar papel: " + e.getMessage(), "PAPEL_007");
        }
    }

    @PostMapping("/criar-se-nao-existir")
    public ResponseEntity<Map<String, Object>> createIfNotExists(
            @RequestParam String nome,
            @RequestParam(required = false) String descricao) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                return error("Nome do papel é obrigatório", "PAPEL_008");
            }

            Papel papel = papelService.createIfNotExists(nome, descricao);
            String message = papelService.existsByNome(nome) ?
                    "Papel já existente recuperado" : "Papel criado com sucesso";

            return success(papel, message);

        } catch (Exception e) {
            return internalError("Erro ao criar/recuperar papel: " + e.getMessage(), "PAPEL_009");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updatePapel(@PathVariable Integer id, @RequestBody Papel papelDetails) {
        try {
            // Validações
            if (papelDetails.getPapNome() != null && papelDetails.getPapNome().trim().isEmpty()) {
                return error("Nome do papel não pode ser vazio", "PAPEL_010");
            }

            // Verificar se o novo nome já existe em outro papel
            if (papelDetails.getPapNome() != null) {
                Optional<Papel> papelComMesmoNome = papelService.findByNome(papelDetails.getPapNome());
                if (papelComMesmoNome.isPresent() && !papelComMesmoNome.get().getId().equals(id)) {
                    return conflict("Já existe outro papel com o nome: " + papelDetails.getPapNome());
                }
            }

            Papel papelAtualizado = papelService.update(id, papelDetails);
            if (papelAtualizado != null) {
                return success(papelAtualizado, "Papel atualizado com sucesso");
            }
            return notFound("Papel", id);

        } catch (Exception e) {
            return internalError("Erro ao atualizar papel: " + e.getMessage(), "PAPEL_011");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePapel(@PathVariable Integer id) {
        try {
            boolean deletado = papelService.delete(id);
            if (deletado) {
                return success("Papel deletado com sucesso");
            }
            return notFound("Papel", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar papel: " + e.getMessage(), "PAPEL_012");
        }
    }

    @GetMapping("/verificar/{nome}")
    public ResponseEntity<Map<String, Object>> verificarExistencia(@PathVariable String nome) {
        try {
            boolean existe = papelService.existsByNome(nome);
            Map<String, Boolean> response = Map.of("existe", existe);
            return success(response, "Verificação realizada com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao verificar papel: " + e.getMessage(), "PAPEL_013");
        }
    }
}