package br.com.TrustHelp.Controller.Telefone;

import br.com.TrustHelp.Model.Telefone.Telefone;
import br.com.TrustHelp.Model.Telefone.TelefoneInfo;
import br.com.TrustHelp.Service.Telefone.TelefoneService;
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
@RequestMapping("/telefones")
public class TelefoneController extends BaseController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllTelefones() {
        try {
            List<Telefone> telefones = telefoneService.findAll();
            if (telefones.isEmpty()) {
                return success(telefones, "Nenhum telefone encontrado");
            }
            return success(telefones, "Telefones recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefones: " + e.getMessage(), "TEL_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getTelefoneById(@PathVariable Integer id) {
        try {
            Optional<Telefone> telefone = telefoneService.findById(id);
            if (telefone.isPresent()) {
                return success(telefone.get(), "Telefone encontrado com sucesso");
            }
            return notFound("Telefone", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar telefone: " + e.getMessage(), "TEL_002");
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Map<String, Object>> getTelefonesByUsuario(@PathVariable Integer idUsuario) {
        try {
            List<Telefone> telefones = telefoneService.findByUsuarioId(idUsuario);
            if (telefones.isEmpty()) {
                return success(telefones, "Nenhum telefone encontrado para este usuário");
            }
            return success(telefones, "Telefones do usuário recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefones do usuário: " + e.getMessage(), "TEL_003");
        }
    }

    @GetMapping("/usuario/{idUsuario}/info")
    public ResponseEntity<Map<String, Object>> getTelefonesInfoByUsuario(@PathVariable Integer idUsuario) {
        try {
            List<TelefoneInfo> telefonesInfo = telefoneService.findInfoByUsuarioId(idUsuario);
            if (telefonesInfo.isEmpty()) {
                return success(telefonesInfo, "Nenhum telefone encontrado para este usuário");
            }
            return success(telefonesInfo, "Informações dos telefones recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar informações dos telefones: " + e.getMessage(), "TEL_004");
        }
    }

    @GetMapping("/usuario/{idUsuario}/ativos")
    public ResponseEntity<Map<String, Object>> getTelefonesAtivosByUsuario(@PathVariable Integer idUsuario) {
        try {
            List<Telefone> telefones = telefoneService.findAtivosByUsuarioId(idUsuario);
            if (telefones.isEmpty()) {
                return success(telefones, "Nenhum telefone ativo encontrado para este usuário");
            }
            return success(telefones, "Telefones ativos do usuário recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefones ativos: " + e.getMessage(), "TEL_005");
        }
    }

    @GetMapping("/usuario/{idUsuario}/principal")
    public ResponseEntity<Map<String, Object>> getTelefonePrincipalByUsuario(@PathVariable Integer idUsuario) {
        try {
            Optional<Telefone> telefonePrincipal = telefoneService.findTelefonePrincipalByUsuario(idUsuario);
            if (telefonePrincipal.isPresent()) {
                return success(telefonePrincipal.get(), "Telefone principal encontrado com sucesso");
            }
            return notFound("Telefone principal não encontrado para o usuário", idUsuario);
        } catch (Exception e) {
            return internalError("Erro ao buscar telefone principal: " + e.getMessage(), "TEL_006");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Map<String, Object>> getTelefoneByDddNumero(
            @RequestParam String ddd,
            @RequestParam String numero) {
        try {
            Optional<Telefone> telefone = telefoneService.findByDddNumero(ddd, numero);
            if (telefone.isPresent()) {
                return success(telefone.get(), "Telefone encontrado com sucesso");
            }
            return notFound("Telefone não encontrado");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefone: " + e.getMessage(), "TEL_007");
        }
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Map<String, Object>> getTelefonesByTipo(@PathVariable String tipo) {
        try {
            List<Telefone> telefones = telefoneService.findByTipo(tipo);
            if (telefones.isEmpty()) {
                return success(telefones, "Nenhum telefone encontrado do tipo: " + tipo);
            }
            return success(telefones, "Telefones do tipo recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefones por tipo: " + e.getMessage(), "TEL_008");
        }
    }

    @GetMapping("/ddd/{ddd}")
    public ResponseEntity<Map<String, Object>> getTelefonesByDdd(@PathVariable String ddd) {
        try {
            List<Telefone> telefones = telefoneService.findByDdd(ddd);
            if (telefones.isEmpty()) {
                return success(telefones, "Nenhum telefone encontrado com DDD: " + ddd);
            }
            return success(telefones, "Telefones do DDD recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefones por DDD: " + e.getMessage(), "TEL_009");
        }
    }

    @GetMapping("/ativos")
    public ResponseEntity<Map<String, Object>> getTelefonesAtivos() {
        try {
            List<Telefone> telefones = telefoneService.findAtivos();
            if (telefones.isEmpty()) {
                return success(telefones, "Nenhum telefone ativo encontrado");
            }
            return success(telefones, "Telefones ativos recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefones ativos: " + e.getMessage(), "TEL_010");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createTelefone(@RequestBody Telefone telefone) {
        try {
            Telefone novoTelefone = telefoneService.save(telefone);
            return created(novoTelefone, "Telefone criado com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "TEL_011");
        } catch (Exception e) {
            return internalError("Erro ao criar telefone: " + e.getMessage(), "TEL_012");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<Map<String, Object>> createTelefone(
            @RequestParam Integer idUsuario,
            @RequestParam String ddd,
            @RequestParam String numero,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) Boolean principal) {
        try {
            Telefone novoTelefone = telefoneService.create(idUsuario, ddd, numero, tipo, principal);
            return created(novoTelefone, "Telefone criado com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "TEL_013");
        } catch (Exception e) {
            return internalError("Erro ao criar telefone: " + e.getMessage(), "TEL_014");
        }
    }

    @PostMapping("/principal")
    public ResponseEntity<Map<String, Object>> criarTelefonePrincipal(
            @RequestParam Integer idUsuario,
            @RequestParam String ddd,
            @RequestParam String numero,
            @RequestParam(required = false) String tipo) {
        try {
            Telefone telefonePrincipal = telefoneService.criarTelefonePrincipal(idUsuario, ddd, numero, tipo);
            return created(telefonePrincipal, "Telefone principal criado com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "TEL_015");
        } catch (Exception e) {
            return internalError("Erro ao criar telefone principal: " + e.getMessage(), "TEL_016");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateTelefone(@PathVariable Integer id, @RequestBody Telefone telefoneDetails) {
        try {
            Telefone telefoneAtualizado = telefoneService.update(id, telefoneDetails);
            if (telefoneAtualizado != null) {
                return success(telefoneAtualizado, "Telefone atualizado com sucesso");
            }
            return notFound("Telefone", id);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "TEL_017");
        } catch (Exception e) {
            return internalError("Erro ao atualizar telefone: " + e.getMessage(), "TEL_018");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteTelefone(@PathVariable Integer id) {
        try {
            boolean deletado = telefoneService.delete(id);
            if (deletado) {
                return success("Telefone deletado com sucesso");
            }
            return notFound("Telefone", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar telefone: " + e.getMessage(), "TEL_019");
        }
    }

    @DeleteMapping("/usuario/{idUsuario}")
    public ResponseEntity<Map<String, Object>> deleteTelefonesByUsuario(@PathVariable Integer idUsuario) {
        try {
            boolean deletado = telefoneService.deleteByUsuario(idUsuario);
            if (deletado) {
                return success("Todos os telefones do usuário foram deletados com sucesso");
            }
            return notFound("Nenhum telefone encontrado para o usuário", idUsuario);
        } catch (Exception e) {
            return internalError("Erro ao deletar telefones do usuário: " + e.getMessage(), "TEL_020");
        }
    }

    @PatchMapping("/{id}/principal")
    public ResponseEntity<Map<String, Object>> definirComoPrincipal(@PathVariable Integer id) {
        try {
            Telefone telefonePrincipal = telefoneService.definirComoPrincipal(id);
            if (telefonePrincipal != null) {
                return success(telefonePrincipal, "Telefone definido como principal com sucesso");
            }
            return notFound("Telefone", id);
        } catch (Exception e) {
            return internalError("Erro ao definir telefone como principal: " + e.getMessage(), "TEL_021");
        }
    }

    @PatchMapping("/{id}/toggle-ativo")
    public ResponseEntity<Map<String, Object>> toggleAtivo(@PathVariable Integer id) {
        try {
            Telefone telefoneAtualizado = telefoneService.toggleAtivo(id);
            if (telefoneAtualizado != null) {
                String status = telefoneAtualizado.getTelAtivo() ? "ativado" : "desativado";
                return success(telefoneAtualizado, "Telefone " + status + " com sucesso");
            }
            return notFound("Telefone", id);
        } catch (Exception e) {
            return internalError("Erro ao alterar status do telefone: " + e.getMessage(), "TEL_022");
        }
    }

    @PatchMapping("/usuario/{idUsuario}/desativar-todos")
    public ResponseEntity<Map<String, Object>> desativarTodosTelefonesUsuario(@PathVariable Integer idUsuario) {
        try {
            telefoneService.desativarTodosTelefonesUsuario(idUsuario);
            return success("Todos os telefones do usuário foram desativados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao desativar telefones do usuário: " + e.getMessage(), "TEL_023");
        }
    }

    @GetMapping("/verificar")
    public ResponseEntity<Map<String, Object>> verificarTelefoneExistente(
            @RequestParam String ddd,
            @RequestParam String numero) {
        try {
            boolean existe = telefoneService.existsByDddNumero(ddd, numero);
            Map<String, Boolean> response = Map.of("existe", existe);
            String message = existe ? "Telefone já cadastrado" : "Telefone disponível";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar telefone: " + e.getMessage(), "TEL_024");
        }
    }

    @GetMapping("/usuario/{idUsuario}/verificar-principal")
    public ResponseEntity<Map<String, Object>> verificarTelefonePrincipal(@PathVariable Integer idUsuario) {
        try {
            boolean temPrincipal = telefoneService.usuarioTemTelefonePrincipal(idUsuario);
            Map<String, Boolean> response = Map.of("temPrincipal", temPrincipal);
            String message = temPrincipal ? "Usuário possui telefone principal" : "Usuário não possui telefone principal";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar telefone principal: " + e.getMessage(), "TEL_025");
        }
    }

    @GetMapping("/formatar/{id}")
    public ResponseEntity<Map<String, Object>> formatarTelefone(@PathVariable Integer id) {
        try {
            Optional<Telefone> telefone = telefoneService.findById(id);
            if (telefone.isPresent()) {
                String telefoneFormatado = telefoneService.formatarTelefone(telefone.get());
                Map<String, String> response = Map.of("telefoneFormatado", telefoneFormatado);
                return success(response, "Telefone formatado com sucesso");
            }
            return notFound("Telefone", id);
        } catch (Exception e) {
            return internalError("Erro ao formatar telefone: " + e.getMessage(), "TEL_026");
        }
    }

    @GetMapping("/recentes")
    public ResponseEntity<Map<String, Object>> getTelefonesRecentes(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant data) {
        try {
            List<Telefone> telefones = telefoneService.findTelefonesRecentes(data);
            if (telefones.isEmpty()) {
                return success(telefones, "Nenhum telefone encontrado após " + data);
            }
            return success(telefones, "Telefones recentes recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar telefones recentes: " + e.getMessage(), "TEL_027");
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalTelefones() {
        try {
            long total = telefoneService.count();
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de telefones recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar telefones: " + e.getMessage(), "TEL_028");
        }
    }

    @GetMapping("/usuario/{idUsuario}/total")
    public ResponseEntity<Map<String, Object>> getTotalTelefonesByUsuario(@PathVariable Integer idUsuario) {
        try {
            long total = telefoneService.countByUsuario(idUsuario);
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de telefones do usuário recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar telefones do usuário: " + e.getMessage(), "TEL_029");
        }
    }
}