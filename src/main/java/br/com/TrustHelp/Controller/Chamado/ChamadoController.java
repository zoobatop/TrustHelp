package br.com.TrustHelp.Controller.Chamado;

import br.com.TrustHelp.Model.Chamado.Chamado;
import br.com.TrustHelp.Service.Chamado.ChamadoService;
import br.com.TrustHelp.Controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController extends BaseController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllChamados() {
        try {
            List<Chamado> chamados = chamadoService.findAll();
            if (chamados.isEmpty()) {
                return success(chamados, "Nenhum chamado encontrado");
            }
            return success(chamados, "Chamados recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar chamados: " + e.getMessage(), "CHAMADO_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getChamadoById(@PathVariable Integer id) {
        try {
            Optional<Chamado> chamado = chamadoService.findById(id);
            if (chamado.isPresent()) {
                return success(chamado.get(), "Chamado encontrado com sucesso");
            }
            return notFound("Chamado", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar chamado: " + e.getMessage(), "CHAMADO_002");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createChamado(@RequestBody Chamado chamado) {
        try {
            // Validações básicas
            if (chamado.getChaTitulo() == null || chamado.getChaTitulo().trim().isEmpty()) {
                return error("Título do chamado é obrigatório", "CHAMADO_003");
            }
            if (chamado.getChaDescricao() == null || chamado.getChaDescricao().trim().isEmpty()) {
                return error("Descrição do chamado é obrigatória", "CHAMADO_004");
            }
            if (chamado.getIdOrganizacao() == null) {
                return error("Organização é obrigatória", "CHAMADO_005");
            }
            if (chamado.getIdUsuarioAbertura() == null) {
                return error("Usuário de abertura é obrigatório", "CHAMADO_006");
            }

            Chamado novoChamado = chamadoService.save(chamado);
            return created(novoChamado, "Chamado criado com sucesso");

        } catch (Exception e) {
            return internalError("Erro ao criar chamado: " + e.getMessage(), "CHAMADO_007");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateChamado(@PathVariable Integer id, @RequestBody Chamado chamadoDetails) {
        try {
            // Validações básicas
            if (chamadoDetails.getChaTitulo() != null && chamadoDetails.getChaTitulo().trim().isEmpty()) {
                return error("Título do chamado não pode ser vazio", "CHAMADO_008");
            }

            Chamado chamadoAtualizado = chamadoService.update(id, chamadoDetails);
            if (chamadoAtualizado != null) {
                return success(chamadoAtualizado, "Chamado atualizado com sucesso");
            }
            return notFound("Chamado", id);

        } catch (Exception e) {
            return internalError("Erro ao atualizar chamado: " + e.getMessage(), "CHAMADO_009");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteChamado(@PathVariable Integer id) {
        try {
            boolean deletado = chamadoService.delete(id);
            if (deletado) {
                return success("Chamado deletado com sucesso");
            }
            return notFound("Chamado", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar chamado: " + e.getMessage(), "CHAMADO_010");
        }
    }

    @PatchMapping("/{id}/atribuir")
    public ResponseEntity<Map<String, Object>> atribuirUsuario(@PathVariable Integer id, @RequestParam Integer idUsuario) {
        try {
            if (idUsuario == null) {
                return error("ID do usuário é obrigatório", "CHAMADO_011");
            }

            Chamado chamadoAtualizado = chamadoService.atribuirUsuario(id, idUsuario);
            if (chamadoAtualizado != null) {
                return success(chamadoAtualizado, "Usuário atribuído ao chamado com sucesso");
            }
            return notFound("Chamado", id);

        } catch (Exception e) {
            return internalError("Erro ao atribuir usuário: " + e.getMessage(), "CHAMADO_012");
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> atualizarStatus(
            @PathVariable Integer id,
            @RequestParam String status) {
        try {
            if (status == null || status.trim().isEmpty()) {
                return error("Status é obrigatório", "CHAMADO_013");
            }

            // Validação de status permitidos
            List<String> statusPermitidos = List.of("aberto", "em_andamento", "pendente", "resolvido", "fechado", "cancelado");
            if (!statusPermitidos.contains(status.toLowerCase())) {
                return unprocessableEntity("Status inválido. Valores permitidos: " + statusPermitidos);
            }

            Chamado chamadoAtualizado = chamadoService.atualizarStatus(id, status);
            if (chamadoAtualizado != null) {
                return success(chamadoAtualizado, "Status do chamado atualizado com sucesso");
            }
            return notFound("Chamado", id);

        } catch (Exception e) {
            return internalError("Erro ao atualizar status: " + e.getMessage(), "CHAMADO_014");
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Map<String, Object>> getChamadosPorStatus(@PathVariable String status) {
        try {
            List<Chamado> chamados = chamadoService.findByStatus(status);
            if (chamados.isEmpty()) {
                return success(chamados, "Nenhum chamado encontrado com o status " + status);
            }
            return success(chamados, "Chamados filtrados por status recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar chamados por status: " + e.getMessage(), "CHAMADO_015");
        }
    }

    @GetMapping("/organizacao/{idOrganizacao}")
    public ResponseEntity<Map<String, Object>> getChamadosPorOrganizacao(@PathVariable Integer idOrganizacao) {
        try {
            List<Chamado> chamados = chamadoService.findByOrganizacao(idOrganizacao);
            if (chamados.isEmpty()) {
                return success(chamados, "Nenhum chamado encontrado para a organização " + idOrganizacao);
            }
            return success(chamados, "Chamados da organização recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar chamados por organização: " + e.getMessage(), "CHAMADO_016");
        }
    }
}