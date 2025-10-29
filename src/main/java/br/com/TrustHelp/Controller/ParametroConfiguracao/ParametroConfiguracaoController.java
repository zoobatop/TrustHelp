package br.com.TrustHelp.Controller.ParametroConfiguracao;

import br.com.TrustHelp.Model.ParametroConfiguracao.ParametroConfiguracao;
import br.com.TrustHelp.Service.ParametroConfiguracao.ParametroConfiguracaoService;
import br.com.TrustHelp.Controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/parametros-configuracao")
public class ParametroConfiguracaoController extends BaseController {

    @Autowired
    private ParametroConfiguracaoService parametroConfiguracaoService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllParametros() {
        try {
            List<ParametroConfiguracao> parametros = parametroConfiguracaoService.findAll();
            if (parametros.isEmpty()) {
                return success(parametros, "Nenhum parâmetro de configuração encontrado");
            }
            return success(parametros, "Parâmetros de configuração recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetros: " + e.getMessage(), "PARAM_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getParametroById(@PathVariable Integer id) {
        try {
            Optional<ParametroConfiguracao> parametro = parametroConfiguracaoService.findById(id);
            if (parametro.isPresent()) {
                return success(parametro.get(), "Parâmetro encontrado com sucesso");
            }
            return notFound("Parâmetro", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetro: " + e.getMessage(), "PARAM_002");
        }
    }

    @GetMapping("/chave/{chave}")
    public ResponseEntity<Map<String, Object>> getParametroByChave(@PathVariable String chave) {
        try {
            Optional<ParametroConfiguracao> parametro = parametroConfiguracaoService.findByChave(chave);
            if (parametro.isPresent()) {
                return success(parametro.get(), "Parâmetro encontrado com sucesso");
            }
            return notFound("Parâmetro com chave '" + chave + "' não encontrado");
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetro por chave: " + e.getMessage(), "PARAM_003");
        }
    }

    @GetMapping("/chave/{chave}/valor")
    public ResponseEntity<Map<String, Object>> getValorByChave(@PathVariable String chave) {
        try {
            Optional<String> valor = parametroConfiguracaoService.findValorByChave(chave);
            if (valor.isPresent()) {
                Map<String, String> response = Map.of("valor", valor.get());
                return success(response, "Valor do parâmetro recuperado com sucesso");
            }
            return notFound("Parâmetro com chave '" + chave + "' não encontrado");
        } catch (Exception e) {
            return internalError("Erro ao buscar valor do parâmetro: " + e.getMessage(), "PARAM_004");
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<Map<String, Object>> getParametrosByCategoria(@PathVariable String categoria) {
        try {
            List<ParametroConfiguracao> parametros = parametroConfiguracaoService.findByCategoria(categoria);
            if (parametros.isEmpty()) {
                return success(parametros, "Nenhum parâmetro encontrado para a categoria: " + categoria);
            }
            return success(parametros, "Parâmetros da categoria recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetros por categoria: " + e.getMessage(), "PARAM_005");
        }
    }

    @GetMapping("/ativos")
    public ResponseEntity<Map<String, Object>> getParametrosAtivos() {
        try {
            List<ParametroConfiguracao> parametros = parametroConfiguracaoService.findAtivos();
            if (parametros.isEmpty()) {
                return success(parametros, "Nenhum parâmetro ativo encontrado");
            }
            return success(parametros, "Parâmetros ativos recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetros ativos: " + e.getMessage(), "PARAM_006");
        }
    }

    @GetMapping("/inativos")
    public ResponseEntity<Map<String, Object>> getParametrosInativos() {
        try {
            List<ParametroConfiguracao> parametros = parametroConfiguracaoService.findInativos();
            if (parametros.isEmpty()) {
                return success(parametros, "Nenhum parâmetro inativo encontrado");
            }
            return success(parametros, "Parâmetros inativos recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetros inativos: " + e.getMessage(), "PARAM_007");
        }
    }

    @GetMapping("/categorias")
    public ResponseEntity<Map<String, Object>> getCategorias() {
        try {
            List<String> categorias = parametroConfiguracaoService.findDistinctCategorias();
            if (categorias.isEmpty()) {
                return success(categorias, "Nenhuma categoria encontrada");
            }
            return success(categorias, "Categorias recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar categorias: " + e.getMessage(), "PARAM_008");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Map<String, Object>> searchParametros(@RequestParam String termo) {
        try {
            List<ParametroConfiguracao> parametros = parametroConfiguracaoService.search(termo);
            if (parametros.isEmpty()) {
                return success(parametros, "Nenhum parâmetro encontrado com o termo: " + termo);
            }
            return success(parametros, "Parâmetros encontrados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetros: " + e.getMessage(), "PARAM_009");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createParametro(@RequestBody ParametroConfiguracao parametro) {
        try {
            ParametroConfiguracao novoParametro = parametroConfiguracaoService.save(parametro);
            return created(novoParametro, "Parâmetro criado com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PARAM_010");
        } catch (Exception e) {
            return internalError("Erro ao criar parâmetro: " + e.getMessage(), "PARAM_011");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Map<String, Object>> createParametro(
            @RequestParam String chave,
            @RequestParam String valor,
            @RequestParam String categoria,
            @RequestParam(required = false) String descricao) {
        try {
            ParametroConfiguracao novoParametro = parametroConfiguracaoService.create(chave, valor, categoria, descricao);
            return created(novoParametro, "Parâmetro criado com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PARAM_012");
        } catch (Exception e) {
            return internalError("Erro ao criar parâmetro: " + e.getMessage(), "PARAM_013");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateParametro(@PathVariable Integer id, @RequestBody ParametroConfiguracao parametroDetails) {
        try {
            ParametroConfiguracao parametroAtualizado = parametroConfiguracaoService.update(id, parametroDetails);
            if (parametroAtualizado != null) {
                return success(parametroAtualizado, "Parâmetro atualizado com sucesso");
            }
            return notFound("Parâmetro", id);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "PARAM_014");
        } catch (Exception e) {
            return internalError("Erro ao atualizar parâmetro: " + e.getMessage(), "PARAM_015");
        }
    }

    @PatchMapping("/chave/{chave}")
    public ResponseEntity<Map<String, Object>> updateValorByChave(
            @PathVariable String chave,
            @RequestParam String novoValor) {
        try {
            ParametroConfiguracao parametroAtualizado = parametroConfiguracaoService.updateByChave(chave, novoValor);
            if (parametroAtualizado != null) {
                return success(parametroAtualizado, "Valor do parâmetro atualizado com sucesso");
            }
            return notFound("Parâmetro com chave '" + chave + "' não encontrado");

        } catch (Exception e) {
            return internalError("Erro ao atualizar valor do parâmetro: " + e.getMessage(), "PARAM_016");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteParametro(@PathVariable Integer id) {
        try {
            boolean deletado = parametroConfiguracaoService.delete(id);
            if (deletado) {
                return success("Parâmetro deletado com sucesso");
            }
            return notFound("Parâmetro", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar parâmetro: " + e.getMessage(), "PARAM_017");
        }
    }

    @DeleteMapping("/chave/{chave}")
    public ResponseEntity<Map<String, Object>> deleteParametroByChave(@PathVariable String chave) {
        try {
            boolean deletado = parametroConfiguracaoService.deleteByChave(chave);
            if (deletado) {
                return success("Parâmetro deletado com sucesso");
            }
            return notFound("Parâmetro com chave '" + chave + "' não encontrado");
        } catch (Exception e) {
            return internalError("Erro ao deletar parâmetro: " + e.getMessage(), "PARAM_018");
        }
    }

    @PatchMapping("/{id}/toggle-ativo")
    public ResponseEntity<Map<String, Object>> toggleAtivo(@PathVariable Integer id) {
        try {
            ParametroConfiguracao parametroAtualizado = parametroConfiguracaoService.toggleAtivo(id);
            if (parametroAtualizado != null) {
                String status = parametroAtualizado.getParAtivo() ? "ativado" : "desativado";
                return success(parametroAtualizado, "Parâmetro " + status + " com sucesso");
            }
            return notFound("Parâmetro", id);
        } catch (Exception e) {
            return internalError("Erro ao alterar status do parâmetro: " + e.getMessage(), "PARAM_019");
        }
    }

    @PatchMapping("/chave/{chave}/toggle-ativo")
    public ResponseEntity<Map<String, Object>> toggleAtivoByChave(@PathVariable String chave) {
        try {
            ParametroConfiguracao parametroAtualizado = parametroConfiguracaoService.toggleAtivoByChave(chave);
            if (parametroAtualizado != null) {
                String status = parametroAtualizado.getParAtivo() ? "ativado" : "desativado";
                return success(parametroAtualizado, "Parâmetro " + status + " com sucesso");
            }
            return notFound("Parâmetro com chave '" + chave + "' não encontrado");
        } catch (Exception e) {
            return internalError("Erro ao alterar status do parâmetro: " + e.getMessage(), "PARAM_020");
        }
    }

    @GetMapping("/verificar/chave/{chave}")
    public ResponseEntity<Map<String, Object>> verificarChaveExistente(@PathVariable String chave) {
        try {
            boolean existe = parametroConfiguracaoService.existsByChave(chave);
            Map<String, Boolean> response = Map.of("existe", existe);
            String message = existe ? "Chave já existe" : "Chave disponível";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar chave: " + e.getMessage(), "PARAM_021");
        }
    }

    @GetMapping("/valor-inteiro/{chave}")
    public ResponseEntity<Map<String, Object>> getValorAsInteger(
            @PathVariable String chave,
            @RequestParam(defaultValue = "0") Integer valorPadrao) {
        try {
            Integer valor = parametroConfiguracaoService.getValorAsInteger(chave, valorPadrao);
            Map<String, Integer> response = Map.of("valor", valor);
            return success(response, "Valor inteiro recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao recuperar valor inteiro: " + e.getMessage(), "PARAM_022");
        }
    }

    @GetMapping("/valor-booleano/{chave}")
    public ResponseEntity<Map<String, Object>> getValorAsBoolean(
            @PathVariable String chave,
            @RequestParam(defaultValue = "false") Boolean valorPadrao) {
        try {
            Boolean valor = parametroConfiguracaoService.getValorAsBoolean(chave, valorPadrao);
            Map<String, Boolean> response = Map.of("valor", valor);
            return success(response, "Valor booleano recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao recuperar valor booleano: " + e.getMessage(), "PARAM_023");
        }
    }

    @GetMapping("/atualizados-apos")
    public ResponseEntity<Map<String, Object>> getParametrosAtualizadosApos(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant data) {
        try {
            List<ParametroConfiguracao> parametros = parametroConfiguracaoService.findAtualizadosApos(data);
            if (parametros.isEmpty()) {
                return success(parametros, "Nenhum parâmetro atualizado após " + data);
            }
            return success(parametros, "Parâmetros atualizados recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar parâmetros atualizados: " + e.getMessage(), "PARAM_024");
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalParametros() {
        try {
            long total = parametroConfiguracaoService.count();
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de parâmetros recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar parâmetros: " + e.getMessage(), "PARAM_025");
        }
    }

    @PostMapping("/importar")
    public ResponseEntity<Map<String, Object>> importarConfiguracoes(@RequestBody List<ParametroConfiguracao> configuracoes) {
        try {
            parametroConfiguracaoService.importarConfiguracoes(configuracoes);
            return success(configuracoes.size() + " configurações importadas/atualizadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao importar configurações: " + e.getMessage(), "PARAM_026");
        }
    }
}