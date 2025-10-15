package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Permissao;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PermissaoRepository {
    private final Map<Integer, Permissao> permissoes = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public List<Permissao> findAll() {
        return new ArrayList<>(permissoes.values());
    }

    public Optional<Permissao> findById(int id) {
        return Optional.ofNullable(permissoes.get(id));
    }

    public Permissao save(Permissao permissao) {
        if (permissao.getId() == 0) {
            permissao.setId(idGenerator.getAndIncrement());
        }
        permissoes.put(permissao.getId(), permissao);
        return permissao;
    }

    public boolean existsById(int id) {
        return permissoes.containsKey(id);
    }

    public void deleteById(int id) {
        permissoes.remove(id);
    }
}
