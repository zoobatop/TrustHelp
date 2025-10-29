package br.com.TrustHelp.Controller.EmpresaAtendimento;

import br.com.TrustHelp.Model.EmpresaAtendimento.EmpresaAtendimento;
import br.com.TrustHelp.Service.EmpresaAtendimento.EmpresaAtendimentoService;
import br.com.TrustHelp.Controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/empresas-atendimento")
public class EmpresaAtendimentoController extends BaseController {

    @Autowired
    private EmpresaAtendimentoService empresaAtendimentoService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEmpresas() {
        try {
            List<EmpresaAtendimento> empresas = empresaAtendimentoService.findAll();
            if (empresas.isEmpty()) {
                return success(empresas, "Nenhuma empresa de atendimento encontrada");
            }
            return success(empresas, "Empresas de atendimento recuperadas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar empresas: " + e.getMessage(), "EMPRESA_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEmpresaById(@PathVariable Integer id) {
        try {
            Optional<EmpresaAtendimento> empresa = empresaAtendimentoService.findById(id);
            if (empresa.isPresent()) {
                return success(empresa.get(), "Empresa encontrada com sucesso");
            }
            return notFound("Empresa", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar empresa: " + e.getMessage(), "EMPRESA_002");
        }
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Map<String, Object>> getEmpresaByCnpj(@PathVariable String cnpj) {
        try {
            Optional<EmpresaAtendimento> empresa = empresaAtendimentoService.findByCnpj(cnpj);
            if (empresa.isPresent()) {
                return success(empresa.get(), "Empresa encontrada com sucesso");
            }
            return notFound("Empresa com CNPJ '" + cnpj + "' não encontrada");
        } catch (Exception e) {
            return internalError("Erro ao buscar empresa por CNPJ: " + e.getMessage(), "EMPRESA_003");
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Map<String, Object>> getEmpresaByEmail(@PathVariable String email) {
        try {
            Optional<EmpresaAtendimento> empresa = empresaAtendimentoService.findByEmail(email);
            if (empresa.isPresent()) {
                return success(empresa.get(), "Empresa encontrada com sucesso");
            }
            return notFound("Empresa com email '" + email + "' não encontrada");
        } catch (Exception e) {
            return internalError("Erro ao buscar empresa por email: " + e.getMessage(), "EMPRESA_004");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Map<String, Object>> searchEmpresas(@RequestParam String termo) {
        try {
            List<EmpresaAtendimento> empresas = empresaAtendimentoService.search(termo);
            if (empresas.isEmpty()) {
                return success(empresas, "Nenhuma empresa encontrada com o termo: " + termo);
            }
            return success(empresas, "Empresas encontradas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar empresas: " + e.getMessage(), "EMPRESA_005");
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Map<String, Object>> getEmpresasByNome(@PathVariable String nome) {
        try {
            List<EmpresaAtendimento> empresas = empresaAtendimentoService.findByNomeContaining(nome);
            if (empresas.isEmpty()) {
                return success(empresas, "Nenhuma empresa encontrada com o nome: " + nome);
            }
            return success(empresas, "Empresas encontradas com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar empresas por nome: " + e.getMessage(), "EMPRESA_006");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createEmpresa(@RequestBody EmpresaAtendimento empresa) {
        try {
            // Validação de CNPJ único
            if (empresaAtendimentoService.existsByCnpj(empresa.getEmpCnpj())) {
                return conflict("Já existe uma empresa cadastrada com este CNPJ");
            }

            // Validação de email único se fornecido
            if (empresa.getEmpEmail() != null && !empresa.getEmpEmail().trim().isEmpty()) {
                if (empresaAtendimentoService.existsByEmail(empresa.getEmpEmail())) {
                    return conflict("Já existe uma empresa cadastrada com este email");
                }
            }

            EmpresaAtendimento novaEmpresa = empresaAtendimentoService.save(empresa);
            return created(novaEmpresa, "Empresa criada com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "EMPRESA_007");
        } catch (Exception e) {
            return internalError("Erro ao criar empresa: " + e.getMessage(), "EMPRESA_008");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEmpresa(@PathVariable Integer id, @RequestBody EmpresaAtendimento empresaDetails) {
        try {
            EmpresaAtendimento empresaAtualizada = empresaAtendimentoService.update(id, empresaDetails);
            if (empresaAtualizada != null) {
                return success(empresaAtualizada, "Empresa atualizada com sucesso");
            }
            return notFound("Empresa", id);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "EMPRESA_009");
        } catch (Exception e) {
            return internalError("Erro ao atualizar empresa: " + e.getMessage(), "EMPRESA_010");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmpresa(@PathVariable Integer id) {
        try {
            boolean deletado = empresaAtendimentoService.delete(id);
            if (deletado) {
                return success("Empresa deletada com sucesso");
            }
            return notFound("Empresa", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar empresa: " + e.getMessage(), "EMPRESA_011");
        }
    }

    @GetMapping("/verificar/cnpj/{cnpj}")
    public ResponseEntity<Map<String, Object>> verificarCnpjExistente(@PathVariable String cnpj) {
        try {
            boolean existe = empresaAtendimentoService.existsByCnpj(cnpj);
            Map<String, Boolean> response = Map.of("existe", existe);
            String message = existe ? "CNPJ já cadastrado" : "CNPJ disponível";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar CNPJ: " + e.getMessage(), "EMPRESA_012");
        }
    }

    @GetMapping("/verificar/email/{email}")
    public ResponseEntity<Map<String, Object>> verificarEmailExistente(@PathVariable String email) {
        try {
            boolean existe = empresaAtendimentoService.existsByEmail(email);
            Map<String, Boolean> response = Map.of("existe", existe);
            String message = existe ? "Email já cadastrado" : "Email disponível";
            return success(response, message);
        } catch (Exception e) {
            return internalError("Erro ao verificar email: " + e.getMessage(), "EMPRESA_013");
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalEmpresas() {
        try {
            long total = empresaAtendimentoService.count();
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de empresas recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar empresas: " + e.getMessage(), "EMPRESA_014");
        }
    }
}