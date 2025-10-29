package br.com.TrustHelp.Controller.Permissao;

import br.com.TrustHelp.Model.Permissao.Permissao;
import br.com.TrustHelp.Service.Permissao.PermissaoService;
import br.com.TrustHelp.Controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController extends BaseController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllPermissoes() {
        try {
            List<Permissao> permissoes = permissaoService.findAll();
            if (permissoes.isEmpty()) {
                return success(permissoes, "Nenhuma permissão encontrada");
            }
            return success(permissoes, "Permissões recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissões: " + e.getMessage(), "PERM_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getPermissaoById(@PathVariable Integer id) {
        try {
            Optional<Permissao> permissao = permissaoService.findById(id);
            if (permissao.isPresent()) {
                return success(permissao.get(), "Permissão encontrada com sucesso");
            }
            return notFound("Permissão", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar permissão: " + e.getMessage(), "PERM_002");
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Map<String, Object>> getPermissaoByNome(@PathVariable String nome) {
        try {
            Optional<Permissao> permissao = permissaoService.findByNome(nome);
            if (permissao.isPresent()) {
                return success(permissao.get(), "Permissão encontrada com sucesso");
            }
            return notFound("Permissão com nome '" + nome + "' não encontrada");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissão por nome: " + e.getMessage(), "PERM_003");
        }
    }

    @GetMapping("/buscar/nome")
    public ResponseEntity<Map<String, Object>> getPermissoesByNome(@RequestParam String nome) {
        try {
            List<Permissao> permissoes = permissaoService.findByNomeContaining(nome);
            if (permissoes.isEmpty()) {
                return success(permissoes, "Nenhuma permissão encontrada com o nome: " + nome);
            }
            return success(permissoes, "Permissões encontradas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissões por nome: " + e.getMessage(), "PERM_004");
        }
    }

    @GetMapping("/buscar/descricao")
    public ResponseEntity<Map<String, Object>> getPermissoesByDescricao(@RequestParam String descricao) {
        try {
            List<Permissao> permissoes = permissaoService.findByDescricaoContaining(descricao);
            if (permissoes.isEmpty()) {
                return success(permissoes, "Nenhuma permissão encontrada com a descrição: " + descricao);
            }
            return success(permissoes, "Permissões encontradas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissões por descrição: " + e.getMessage(), "PERM_005");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Map<String, Object>> searchPermissoes(@RequestParam String termo) {
        try {
            List<Permissao> permissoes = permissaoService.search(termo);
            if (permissoes.isEmpty()) {
                return success(permissoes, "Nenhuma permissão encontrada com o termo: " + termo);
            }
            return success(permissoes, "Permissões encontradas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissões: " + e.getMessage(), "PERM_006");
        }
    }

    @GetMapping("/ids")
    public ResponseEntity<Map<String, Object>> getPermissoesByIds(@RequestParam List<Integer> ids) {
        try {
            List<Permissao> permissoes = permissaoService.findByIds(ids);
            if (permissoes.isEmpty()) {
                return success(permissoes, "Nenhuma permissão encontrada para os IDs fornecidos");
            }
            return success(permissoes, "Permissões encontradas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissões por IDs: " + e.getMessage(), "PERM_007");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPermissao(@RequestBody Permissao permissao) {
        try {
            Permissao novaPermissao = permissaoService.save(permissao);
            return created(novaPermissao, "Permissão criada com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PERM_008");
        } catch (Exception e) {
            return internalError("Erro ao criar permissão: " + e.getMessage(), "PERM_009");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Map<String, Object>> createPermissao(
            @RequestParam String nome,
            @RequestParam(required = false) String descricao) {
        try {
            Permissao novaPermissao = permissaoService.create(nome, descricao);
            return created(novaPermissao, "Permissão criada com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PERM_010");
        } catch (Exception e) {
            return internalError("Erro ao criar permissão: " + e.getMessage(), "PERM_011");
        }
    }

    @PostMapping("/multiplas")
    public ResponseEntity<Map<String, Object>> createMultiplePermissoes(@RequestBody List<Permissao> permissoes) {
        try {
            List<Permissao> permissoesCriadas = permissaoService.createMultiple(permissoes);
            return created(permissoesCriadas, permissoes.size() + " permissões criadas com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PERM_012");
        } catch (Exception e) {
            return internalError("Erro ao criar múltiplas permissões: " + e.getMessage(), "PERM_013");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updatePermissao(@PathVariable Integer id, @RequestBody Permissao permissaoDetails) {
        try {
            Permissao permissaoAtualizada = permissaoService.update(id, permissaoDetails);
            if (permissaoAtualizada != null) {
                return success(permissaoAtualizada, "Permissão atualizada com sucesso");
            }
            return notFound("Permissão", id);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PERM_014");
        } catch (Exception e) {
            return internalError("Erro ao atualizar permissão: " + e.getMessage(), "PERM_015");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePermissao(@PathVariable Integer id) {
        try {
            boolean deletado = permissaoService.delete(id);
            if (deletado) {
                return success("Permissão deletada com sucesso");
            }
            return notFound("Permissão", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar permissão: " + e.getMessage(), "PERM_016");
        }
    }

    @GetMapping("/verificar/nome/{nome}")
    public ResponseEntity<Map<String, Object>> verificarNomeExistente(@PathVariable String nome) {
        try {
            boolean existe = permissaoService.existsByNome(nome);
            Map<String, Boolean> response = Map.of("existe", existe);
            String message = existe ? "Nome já existe" : "Nome disponível";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar nome: " + e.getMessage(), "PERM_017");
        }
    }

    @GetMapping("/verificar/{id}")
    public ResponseEntity<Map<String, Object>> verificarPermissaoExistente(@PathVariable Integer id) {
        try {
            boolean existe = permissaoService.hasPermissao(id);
            Map<String, Boolean> response = Map.of("existe", existe);
            String message = existe ? "Permissão existe" : "Permissão não existe";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar permissão: " + e.getMessage(), "PERM_018");
        }
    }

    @GetMapping("/sistema")
    public ResponseEntity<Map<String, Object>> getPermissoesSistema() {
        try {
            List<Permissao> permissoes = permissaoService.findPermissoesSistema();
            if (permissoes.isEmpty()) {
                return success(permissoes, "Nenhuma permissão de sistema encontrada");
            }
            return success(permissoes, "Permissões de sistema recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissões de sistema: " + e.getMessage(), "PERM_019");
        }
    }

    @GetMapping("/padrao")
    public ResponseEntity<Map<String, Object>> criarPermissoesPadrao() {
        try {
            List<Permissao> permissoes = permissaoService.findPermissoesSistema();
            return success(permissoes, "Permissões padrão do sistema verificadas/criadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao criar permissões padrão: " + e.getMessage(), "PERM_020");
        }
    }

    @GetMapping("/pattern/{pattern}")
    public ResponseEntity<Map<String, Object>> getPermissoesByPattern(@PathVariable String pattern) {
        try {
            List<Permissao> permissoes = permissaoService.findPermissoesByPattern(pattern);
            if (permissoes.isEmpty()) {
                return success(permissoes, "Nenhuma permissão encontrada com o padrão: " + pattern);
            }
            return success(permissoes, "Permissões encontradas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar permissões por padrão: " + e.getMessage(), "PERM_021");
        }
    }

    @GetMapping("/nomes")
    public ResponseEntity<Map<String, Object>> getNomesPermissoesByIds(@RequestParam List<Integer> ids) {
        try {
            List<String> nomes = permissaoService.findNomesByIds(ids);
            if (nomes.isEmpty()) {
                return success(nomes, "Nenhum nome de permissão encontrado para os IDs fornecidos");
            }
            return success(nomes, "Nomes das permissões recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar nomes das permissões: " + e.getMessage(), "PERM_022");
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalPermissoes() {
        try {
            long total = permissaoService.count();
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de permissões recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar permissões: " + e.getMessage(), "PERM_023");
        }
    }

    @GetMapping("/validar/{id}")
    public ResponseEntity<Map<String, Object>> validarPermissao(@PathVariable Integer id) {
        try {
            boolean valida = permissaoService.hasPermissao(id);
            Map<String, Boolean> response = Map.of("valida", valida);
            String message = valida ? "Permissão válida" : "Permissão inválida";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao validar permissão: " + e.getMessage(), "PERM_024");
        }
    }
}