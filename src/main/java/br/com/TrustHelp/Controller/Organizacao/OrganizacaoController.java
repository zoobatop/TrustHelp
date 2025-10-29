package br.com.TrustHelp.Controller.Organizacao;

import br.com.TrustHelp.Controller.BaseController;
import br.com.TrustHelp.Model.Organizacao.Organizacao;
import br.com.TrustHelp.Model.Organizacao.OrganizacaoInfo;
import br.com.TrustHelp.Service.Organizacao.OrganizacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/organizacao")
public class OrganizacaoController extends BaseController {

    private final OrganizacaoService organizacaoService;

    public OrganizacaoController(OrganizacaoService organizacaoService) {
        this.organizacaoService = organizacaoService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll() {
        try {
            List<OrganizacaoInfo> organizacoes = organizacaoService.findAll();
            return success(organizacoes);
        } catch (Exception e) {
            return error("Erro ao buscar organizações: " + e.getMessage());
        }
    }

    @GetMapping("/ativas")
    public ResponseEntity<Map<String, Object>> findActive() {
        try {
            List<OrganizacaoInfo> organizacoes = organizacaoService.findActive();
            return success(organizacoes);
        } catch (Exception e) {
            return error("Erro ao buscar organizações ativas: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Integer id) {
        try {
            OrganizacaoInfo organizacao = organizacaoService.findById(id);
            if (organizacao != null) {
                return success(organizacao);
            } else {
                return error("Organização não encontrada");
            }
        } catch (Exception e) {
            return error("Erro ao buscar organização: " + e.getMessage());
        }
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Map<String, Object>> findByCnpj(@PathVariable String cnpj) {
        try {
            OrganizacaoInfo organizacao = organizacaoService.findByCnpj(cnpj);
            if (organizacao != null) {
                return success(organizacao);
            } else {
                return error("Organização não encontrada");
            }
        } catch (Exception e) {
            return error("Erro ao buscar organização: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody Organizacao organizacao) {
        try {
            OrganizacaoInfo savedOrganizacao = organizacaoService.save(organizacao);
            return success(savedOrganizacao,"Organização criada com sucesso");
        } catch (IllegalArgumentException e) {
            return error(e.getMessage());
        } catch (Exception e) {
            return error("Erro interno ao salvar organização: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Integer id, @RequestBody Organizacao organizacao) {
        try {
            OrganizacaoInfo updatedOrganizacao = organizacaoService.update(id, organizacao);
            return success( updatedOrganizacao,"Organização atualizada com sucesso");
        } catch (IllegalArgumentException e) {
            return error(e.getMessage());
        } catch (Exception e) {
            return error("Erro interno ao atualizar organização: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/desativar")
    public ResponseEntity<Map<String, Object>> deactivate(@PathVariable Integer id) {
        try {
            OrganizacaoInfo deactivatedOrganizacao = organizacaoService.deactivate(id);
            return success(deactivatedOrganizacao,"Organização desativada com sucesso");
        } catch (IllegalArgumentException e) {
            return error(e.getMessage());
        } catch (Exception e) {
            return error("Erro interno ao desativar organização: " + e.getMessage());
        }
    }
}