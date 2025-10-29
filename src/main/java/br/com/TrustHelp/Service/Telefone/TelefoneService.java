package br.com.TrustHelp.Service.Telefone;

import br.com.TrustHelp.Model.Telefone.Telefone;
import br.com.TrustHelp.Model.Telefone.TelefoneInfo;
import br.com.TrustHelp.Model.User.Usuario;
import br.com.TrustHelp.Repository.TelefoneRepository;
import br.com.TrustHelp.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Telefone> findAll() {
        return telefoneRepository.findAll();
    }

    public Optional<Telefone> findById(Integer id) {
        return telefoneRepository.findById(id);
    }

    public List<Telefone> findByUsuarioId(Integer idUsuario) {
        return telefoneRepository.findByIdUsuario_IdOrderByTelPrincipalDesc(idUsuario);
    }

    public List<TelefoneInfo> findInfoByUsuarioId(Integer idUsuario) {
        return telefoneRepository.findInfoByUsuarioId(idUsuario);
    }

    public List<Telefone> findAtivosByUsuarioId(Integer idUsuario) {
        return telefoneRepository.findByIdUsuario_IdAndTelAtivoTrueOrderByTelPrincipalDesc(idUsuario);
    }

    public Optional<Telefone> findTelefonePrincipalByUsuario(Integer idUsuario) {
        return telefoneRepository.findByIdUsuario_IdAndTelPrincipalTrue(idUsuario);
    }

    public Optional<Telefone> findByDddNumero(String ddd, String numero) {
        return telefoneRepository.findByTelDddAndTelNumero(ddd, numero);
    }

    public List<Telefone> findByTipo(String tipo) {
        return telefoneRepository.findByTelTipo(tipo);
    }

    public List<Telefone> findByDdd(String ddd) {
        return telefoneRepository.findByTelDdd(ddd);
    }

    public List<Telefone> findAtivos() {
        return telefoneRepository.findByTelAtivoTrue();
    }

    public List<Telefone> findInativos() {
        return telefoneRepository.findByTelAtivoFalse();
    }

    @Transactional
    public Telefone save(Telefone telefone) {
        validateTelefone(telefone);

        // Setar timestamp
        if (telefone.getCreatedAt() == null) {
            telefone.setCreatedAt(Instant.now());
        }

        // Garantir valores padrão
        if (telefone.getTelTipo() == null) {
            telefone.setTelTipo("CELULAR");
        }
        if (telefone.getTelPrincipal() == null) {
            telefone.setTelPrincipal(false);
        }
        if (telefone.getTelAtivo() == null) {
            telefone.setTelAtivo(true);
        }

        // Se é principal, remover principal de outros telefones do usuário
        if (telefone.getTelPrincipal()) {
            telefoneRepository.removerTelefonePrincipal(telefone.getIdUsuario().getId());
        }

        return telefoneRepository.save(telefone);
    }

    @Transactional
    public Telefone update(Integer id, Telefone telefoneDetails) {
        Optional<Telefone> optionalTelefone = telefoneRepository.findById(id);

        if (optionalTelefone.isPresent()) {
            Telefone telefone = optionalTelefone.get();

            // Atualizar campos permitidos
            if (telefoneDetails.getTelDdd() != null) {
                telefone.setTelDdd(telefoneDetails.getTelDdd());
            }
            if (telefoneDetails.getTelNumero() != null) {
                telefone.setTelNumero(telefoneDetails.getTelNumero());
            }
            if (telefoneDetails.getTelTipo() != null) {
                telefone.setTelTipo(telefoneDetails.getTelTipo());
            }
            if (telefoneDetails.getTelAtivo() != null) {
                telefone.setTelAtivo(telefoneDetails.getTelAtivo());
            }

            // Atualizar principal (com lógica especial)
            if (telefoneDetails.getTelPrincipal() != null &&
                    telefoneDetails.getTelPrincipal() &&
                    !telefone.getTelPrincipal()) {
                telefoneRepository.removerTelefonePrincipal(telefone.getIdUsuario().getId());
                telefone.setTelPrincipal(true);
            } else if (telefoneDetails.getTelPrincipal() != null &&
                    !telefoneDetails.getTelPrincipal() &&
                    telefone.getTelPrincipal()) {
                telefone.setTelPrincipal(false);
            }

            // Validar telefone atualizado
            validateTelefone(telefone);

            return telefoneRepository.save(telefone);
        }

        return null;
    }

    @Transactional
    public Telefone create(Integer idUsuario, String ddd, String numero, String tipo, Boolean principal) {
        // Verificar se usuário existe
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        // Verificar se telefone já existe
        if (telefoneRepository.existsByTelDddAndTelNumero(ddd, numero)) {
            throw new IllegalArgumentException("Telefone já cadastrado no sistema");
        }

        Telefone telefone = new Telefone();
        telefone.setIdUsuario(usuario);
        telefone.setTelDdd(ddd);
        telefone.setTelNumero(numero);
        telefone.setTelTipo(tipo != null ? tipo : "CELULAR");
        telefone.setTelPrincipal(Boolean.TRUE.equals(principal));
        telefone.setTelAtivo(true);
        telefone.setCreatedAt(Instant.now());

        return save(telefone);
    }

    public boolean delete(Integer id) {
        if (telefoneRepository.existsById(id)) {
            telefoneRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteByUsuario(Integer idUsuario) {
        List<Telefone> telefones = telefoneRepository.findByIdUsuario_IdOrderByTelPrincipalDesc(idUsuario);
        if (!telefones.isEmpty()) {
            telefoneRepository.deleteAll(telefones);
            return true;
        }
        return false;
    }

    @Transactional
    public Telefone definirComoPrincipal(Integer idTelefone) {
        Optional<Telefone> optionalTelefone = telefoneRepository.findById(idTelefone);

        if (optionalTelefone.isPresent()) {
            Telefone telefone = optionalTelefone.get();

            // Remover principal de outros telefones do usuário
            telefoneRepository.removerTelefonePrincipal(telefone.getIdUsuario().getId());

            // Definir este como principal
            telefone.setTelPrincipal(true);

            return telefoneRepository.save(telefone);
        }

        return null;
    }

    @Transactional
    public Telefone toggleAtivo(Integer id) {
        Optional<Telefone> optionalTelefone = telefoneRepository.findById(id);

        if (optionalTelefone.isPresent()) {
            Telefone telefone = optionalTelefone.get();
            telefone.setTelAtivo(!telefone.getTelAtivo());

            // Se estiver desativando o telefone principal, remover a flag
            if (!telefone.getTelAtivo() && telefone.getTelPrincipal()) {
                telefone.setTelPrincipal(false);
            }

            return telefoneRepository.save(telefone);
        }

        return null;
    }

    @Transactional
    public void desativarTodosTelefonesUsuario(Integer idUsuario) {
        telefoneRepository.desativarTodosTelefonesUsuario(idUsuario);
    }

    public boolean existsByDddNumero(String ddd, String numero) {
        return telefoneRepository.existsByTelDddAndTelNumero(ddd, numero);
    }

    public boolean usuarioTemTelefonePrincipal(Integer idUsuario) {
        return telefoneRepository.existsByIdUsuario_IdAndTelPrincipalTrue(idUsuario);
    }

    public List<Telefone> findByNumeroContaining(String numero) {
        return telefoneRepository.findByTelNumeroContaining(numero);
    }

    public List<Telefone> findByTipoEDdd(String tipo, String ddd) {
        return telefoneRepository.findByTelTipoAndTelDdd(tipo, ddd);
    }

    private void validateTelefone(Telefone telefone) {
        if (telefone.getIdUsuario() == null) {
            throw new IllegalArgumentException("Usuário é obrigatório");
        }

        if (telefone.getTelDdd() == null || telefone.getTelDdd().trim().isEmpty()) {
            throw new IllegalArgumentException("DDD é obrigatório");
        }

        if (telefone.getTelNumero() == null || telefone.getTelNumero().trim().isEmpty()) {
            throw new IllegalArgumentException("Número é obrigatório");
        }

        // Validar DDD (2-3 dígitos)
        if (!telefone.getTelDdd().matches("^\\d{2,3}$")) {
            throw new IllegalArgumentException("DDD deve conter 2 ou 3 dígitos");
        }

        // Validar número (8-11 dígitos)
        String numeroLimpo = telefone.getTelNumero().replaceAll("\\D", "");
        if (numeroLimpo.length() < 8 || numeroLimpo.length() > 11) {
            throw new IllegalArgumentException("Número deve conter entre 8 e 11 dígitos");
        }

        // Validar tipo
        if (telefone.getTelTipo() != null) {
            List<String> tiposValidos = List.of("CELULAR", "RESIDENCIAL", "COMERCIAL", "WHATSAPP");
            if (!tiposValidos.contains(telefone.getTelTipo().toUpperCase())) {
                throw new IllegalArgumentException("Tipo de telefone inválido. Valores permitidos: " + tiposValidos);
            }
        }

        // Validar unicidade (DDD + número)
        if (telefone.getId() == null) {
            if (telefoneRepository.existsByTelDddAndTelNumero(telefone.getTelDdd(), telefone.getTelNumero())) {
                throw new IllegalArgumentException("Telefone já cadastrado no sistema");
            }
        } else {
            if (telefoneRepository.existsByTelDddAndTelNumeroAndIdNot(telefone.getTelDdd(), telefone.getTelNumero(), telefone.getId())) {
                throw new IllegalArgumentException("Telefone já cadastrado no sistema");
            }
        }
    }

    public String formatarTelefone(Telefone telefone) {
        String numero = telefone.getTelNumero();
        String ddd = telefone.getTelDdd();

        if (numero.length() == 9) {
            return String.format("(%s) %s-%s", ddd, numero.substring(0, 5), numero.substring(5));
        } else if (numero.length() == 8) {
            return String.format("(%s) %s-%s", ddd, numero.substring(0, 4), numero.substring(4));
        }
        return String.format("(%s) %s", ddd, numero);
    }

    public long count() {
        return telefoneRepository.count();
    }

    public long countByUsuario(Integer idUsuario) {
        return telefoneRepository.countByIdUsuario(idUsuario);
    }

    public List<Telefone> findTelefonesRecentes(Instant data) {
        return telefoneRepository.findByCreatedAtAfter(data);
    }

    @Transactional
    public Telefone criarTelefonePrincipal(Integer idUsuario, String ddd, String numero, String tipo) {
        // Verificar se usuário já tem telefone principal
        if (usuarioTemTelefonePrincipal(idUsuario)) {
            throw new IllegalArgumentException("Usuário já possui um telefone principal");
        }

        return create(idUsuario, ddd, numero, tipo, true);
    }
}