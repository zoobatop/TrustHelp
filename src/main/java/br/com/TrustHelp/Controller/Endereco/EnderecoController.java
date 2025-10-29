package br.com.TrustHelp.Controller.Endereco;

import br.com.TrustHelp.Model.Endereco.Endereco;
import br.com.TrustHelp.Service.Endereco.EnderecoService;
import br.com.TrustHelp.Controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController extends BaseController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEnderecos() {
        try {
            List<Endereco> enderecos = enderecoService.findAll();
            if (enderecos.isEmpty()) {
                return success(enderecos, "Nenhum endereço encontrado");
            }
            return success(enderecos, "Endereços recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar endereços: " + e.getMessage(), "ENDERECO_001");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEnderecoById(@PathVariable Integer id) {
        try {
            Optional<Endereco> endereco = enderecoService.findById(id);
            if (endereco.isPresent()) {
                return success(endereco.get(), "Endereço encontrado com sucesso");
            }
            return notFound("Endereço", id);
        } catch (Exception e) {
            return internalError("Erro ao buscar endereço: " + e.getMessage(), "ENDERECO_002");
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Map<String, Object>> getEnderecosByUsuario(@PathVariable Integer idUsuario) {
        try {
            List<Endereco> enderecos = enderecoService.findByUsuario(idUsuario);
            if (enderecos.isEmpty()) {
                return success(enderecos, "Nenhum endereço encontrado para o usuário");
            }
            return success(enderecos, "Endereços do usuário recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar endereços do usuário: " + e.getMessage(), "ENDERECO_003");
        }
    }

    @GetMapping("/organizacao/{idOrganizacao}")
    public ResponseEntity<Map<String, Object>> getEnderecosByOrganizacao(@PathVariable Integer idOrganizacao) {
        try {
            List<Endereco> enderecos = enderecoService.findByOrganizacao(idOrganizacao);
            if (enderecos.isEmpty()) {
                return success(enderecos, "Nenhum endereço encontrado para a organização");
            }
            return success(enderecos, "Endereços da organização recuperados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar endereços da organização: " + e.getMessage(), "ENDERECO_004");
        }
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Map<String, Object>> getEnderecosByCep(@PathVariable String cep) {
        try {
            List<Endereco> enderecos = enderecoService.findByCep(cep);
            if (enderecos.isEmpty()) {
                return success(enderecos, "Nenhum endereço encontrado para o CEP: " + cep);
            }
            return success(enderecos, "Endereços encontrados para o CEP");
        } catch (Exception e) {
            return internalError("Erro ao buscar endereços por CEP: " + e.getMessage(), "ENDERECO_005");
        }
    }

    @GetMapping("/uf/{uf}")
    public ResponseEntity<Map<String, Object>> getEnderecosByUf(@PathVariable String uf) {
        try {
            List<Endereco> enderecos = enderecoService.findByUf(uf);
            if (enderecos.isEmpty()) {
                return success(enderecos, "Nenhum endereço encontrado para a UF: " + uf);
            }
            return success(enderecos, "Endereços encontrados para a UF");
        } catch (Exception e) {
            return internalError("Erro ao buscar endereços por UF: " + e.getMessage(), "ENDERECO_006");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Map<String, Object>> searchEnderecos(@RequestParam String termo) {
        try {
            List<Endereco> enderecos = enderecoService.search(termo);
            if (enderecos.isEmpty()) {
                return success(enderecos, "Nenhum endereço encontrado com o termo: " + termo);
            }
            return success(enderecos, "Endereços encontrados com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao buscar endereços: " + e.getMessage(), "ENDERECO_007");
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createEndereco(@RequestBody Endereco endereco) {
        try {
            Endereco novoEndereco = enderecoService.save(endereco);
            return created(novoEndereco, "Endereço criado com sucesso");

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "ENDERECO_008");
        } catch (Exception e) {
            return internalError("Erro ao criar endereço: " + e.getMessage(), "ENDERECO_009");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEndereco(@PathVariable Integer id, @RequestBody Endereco enderecoDetails) {
        try {
            Endereco enderecoAtualizado = enderecoService.update(id, enderecoDetails);
            if (enderecoAtualizado != null) {
                return success(enderecoAtualizado, "Endereço atualizado com sucesso");
            }
            return notFound("Endereço", id);

        } catch (IllegalArgumentException e) {
            return error(e.getMessage(), "ENDERECO_010");
        } catch (Exception e) {
            return internalError("Erro ao atualizar endereço: " + e.getMessage(), "ENDERECO_011");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteEndereco(@PathVariable Integer id) {
        try {
            boolean deletado = enderecoService.delete(id);
            if (deletado) {
                return success("Endereço deletado com sucesso");
            }
            return notFound("Endereço", id);
        } catch (Exception e) {
            return internalError("Erro ao deletar endereço: " + e.getMessage(), "ENDERECO_012");
        }
    }

    @GetMapping("/logradouro/{logradouro}")
    public ResponseEntity<Map<String, Object>> getEnderecosByLogradouro(@PathVariable String logradouro) {
        try {
            List<Endereco> enderecos = enderecoService.findByLogradouroContaining(logradouro);
            if (enderecos.isEmpty()) {
                return success(enderecos, "Nenhum endereço encontrado no logradouro: " + logradouro);
            }
            return success(enderecos, "Endereços encontrados no logradouro");
        } catch (Exception e) {
            return internalError("Erro ao buscar endereços por logradouro: " + e.getMessage(), "ENDERECO_014");
        }
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getTotalEnderecos() {
        try {
            long total = enderecoService.count();
            Map<String, Long> response = Map.of("total", total);
            return success(response, "Total de endereços recuperado com sucesso");
        } catch (Exception e) {
            return internalError("Erro ao contar endereços: " + e.getMessage(), "ENDERECO_015");
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<Map<String, Object>> validarEndereco(@RequestBody Endereco endereco) {
        try {
            enderecoService.validateEndereco(endereco);
            Map<String, Boolean> response = Map.of("valido", true);
            return success(response, "Endereço válido");
        } catch (IllegalArgumentException e) {
            Map<String, Boolean> response = Map.of("valido", false);
            return success(response, e.getMessage());
        } catch (Exception e) {
            return internalError("Erro ao validar endereço: " + e.getMessage(), "ENDERECO_016");
        }
    }
}