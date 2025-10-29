package br.com.TrustHelp.Controller.InteracaoChamado;

import br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamado;
import br.com.TrustHelp.Model.InteracaoChamado.InteracaoChamadoInfo;
import br.com.TrustHelp.Service.InteracaoChamado.InteracaoChamadoService;
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
@RequestMapping("/interacoes-chamado")
public class InteracaoChamadoController extends BaseController {

    @Autowired
    private InteracaoChamadoService interacaoChamadoService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllInteracoes() {
        try {
            List<InteracaoChamado> interacoes = interacaoChamadoService.findAll();
            if (interacoes.isEmpty()) {
                return success(interacoes, "Nenhuma interação encontrada");
            }
            return success(interacoes, "Interações recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar interações: " + e.getMessage(), "INTERACAO_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getInteracaoById(@PathVariable Integer id) {
        try {
            Optional<InteracaoChamado> interacao = interacaoChamadoService.findById(id);
            if (interacao.isPresent()) {
                return success(interacao.get(), "Interação encontrada com sucesso");
            }
            return notFound("Interação", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar interação: " + e.getMessage(), "INTERACAO_002");
        }
    }

    @GetMapping("/chamado/{idChamado}")
    public ResponseEntity<Map<String, Object>> getInteracoesByChamado(@PathVariable Integer idChamado) {
        try {
            List<InteracaoChamado> interacoes = interacaoChamadoService.findByChamadoId(idChamado);
            if (interacoes.isEmpty()) {
                return success(interacoes, "Nenhuma interação encontrada para este chamado");
            }
            return success(interacoes, "Interações do chamado recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar interações do chamado: " + e.getMessage(), "INTERACAO_003");
        }
    }

    @GetMapping("/chamado/{idChamado}/info")
    public ResponseEntity<Map<String, Object>> getInteracoesInfoByChamado(@PathVariable Integer idChamado) {
        try {
            List<InteracaoChamadoInfo> interacoes = interacaoChamadoService.findInfoByChamadoId(idChamado);
            if (interacoes.isEmpty()) {
                return success(interacoes, "Nenhuma interação encontrada para este chamado");
            }
            return success(interacoes, "Interações do chamado (info) recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar interações do chamado: " + e.getMessage(), "INTERACAO_004");
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Map<String, Object>> getInteracoesByUsuario(@PathVariable Integer idUsuario) {
        try {
            List<InteracaoChamado> interacoes = interacaoChamadoService.findByUsuarioId(idUsuario);
            if (interacoes.isEmpty()) {
                return success(interacoes, "Nenhuma interação encontrada para este usuário");
            }
            return success(interacoes, "Interações do usuário recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar interações do usuário: " + e.getMessage(), "INTERACAO_005");
        }
    }

    @GetMapping("/chamado/{idChamado}/ultima")
    public ResponseEntity<Map<String, Object>> getUltimaInteracaoByChamado(@PathVariable Integer idChamado) {
        try {
            Optional<InteracaoChamado> ultimaInteracao = interacaoChamadoService.findUltimaInteracaoByChamado(idChamado);
            if (ultimaInteracao.isPresent()) {
                return success(ultimaInteracao.get(), "Última interação do chamado recuperada com sucesso");
            }
            return notFound("Nenhuma interação encontrada para o chamado", idChamado);
        } catch (Exception e) {
            return internalError("Erro ao buscar última interação: " + e.getMessage(), "INTERACAO_006");
        }
    }

    @GetMapping("/chamado/{idChamado}/total")
    public ResponseEntity<Map<String, Object>> getTotalInteracoesByChamado(@PathVariable Integer idChamado) {
        try {
            Long total = interacaoChamadoService.countInteracoesByChamado(idChamado);
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de interações do chamado recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar interações: " + e.getMessage(), "INTERACAO_007");
        }
    }

    @GetMapping("/anexos")
    public ResponseEntity<Map<String, Object>> getInteracoesComAnexo() {
        try {
            List<InteracaoChamado> interacoes = interacaoChamadoService.findInteracoesComAnexo();
            if (interacoes.isEmpty()) {
                return success(interacoes, "Nenhuma interação com anexo encontrada");
            }
            return success(interacoes, "Interações com anexo recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar interações com anexo: " + e.getMessage(), "INTERACAO_008");
        }
    }

    @GetMapping("/periodo")
    public ResponseEntity<Map<String, Object>> getInteracoesByPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant dataFim) {
        try {
            List<InteracaoChamado> interacoes = interacaoChamadoService.findByPeriodo(dataInicio, dataFim);
            if (interacoes.isEmpty()) {
                return success(interacoes, "Nenhuma interação encontrada no período especificado");
            }
            return success(interacoes, "Interações do período recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar interações por período: " + e.getMessage(), "INTERACAO_009");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createInteracao(@RequestBody InteracaoChamado interacao) {
        try {
            InteracaoChamado novaInteracao = interacaoChamadoService.save(interacao);
            return created(novaInteracao, "Interação criada com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "INTERACAO_010");
        } catch (Exception e) {
            return internalError("Erro ao criar interação: " + e.getMessage(), "INTERACAO_011");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Map<String, Object>> criarNovaInteracao(
            @RequestParam Integer idChamado,
            @RequestParam Integer idUsuario,
            @RequestParam String mensagem,
            @RequestParam(required = false) String urlAnexo) {
        try {
            InteracaoChamado novaInteracao = interacaoChamadoService.criarInteracao(idChamado, idUsuario, mensagem, urlAnexo);
            return created(novaInteracao, "Interação criada com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "INTERACAO_012");
        } catch (Exception e) {
            return internalError("Erro ao criar interação: " + e.getMessage(), "INTERACAO_013");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateInteracao(@PathVariable Integer id, @RequestBody InteracaoChamado interacaoDetails) {
        try {
            InteracaoChamado interacaoAtualizada = interacaoChamadoService.update(id, interacaoDetails);
            if (interacaoAtualizada != null) {
                return success(interacaoAtualizada, "Interação atualizada com sucesso");
            }
            return notFound("Interação", id);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "INTERACAO_014");
        } catch (Exception e) {
            return internalError("Erro ao atualizar interação: " + e.getMessage(), "INTERACAO_015");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteInteracao(@PathVariable Integer id) {
        try {
            boolean deletado = interacaoChamadoService.delete(id);
            if (deletado) {
                return success("Interação deletada com sucesso");
            }
            return notFound("Interação", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar interação: " + e.getMessage(), "INTERACAO_016");
        }
    }

    @GetMapping("/verificar/{idChamado}/{idUsuario}")
    public ResponseEntity<Map<String, Object>> verificarInteracaoUsuario(
            @PathVariable Integer idChamado,
            @PathVariable Integer idUsuario) {
        try {
            boolean temInteracao = interacaoChamadoService.usuarioTemInteracaoNoChamado(idChamado, idUsuario);
            Map<String, Boolean> response = Map.of("temInteracao", temInteracao);
            String message = temInteracao ? "Usuário possui interação no chamado" : "Usuário não possui interação no chamado";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar interação: " + e.getMessage(), "INTERACAO_017");
        }
    }

    @GetMapping("/recentes")
    public ResponseEntity<Map<String, Object>> getInteracoesRecentes(@RequestParam(defaultValue = "10") int limit) {
        try {
            List<InteracaoChamado> interacoes = interacaoChamadoService.findRecentInteractions(limit);
            if (interacoes.isEmpty()) {
                return success(interacoes, "Nenhuma interação recente encontrada");
            }
            return success(interacoes, "Interações recentes recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar interações recentes: " + e.getMessage(), "INTERACAO_018");
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalInteracoes() {
        try {
            long total = interacaoChamadoService.count();
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de interações recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar interações: " + e.getMessage(), "INTERACAO_019");
        }
    }
}