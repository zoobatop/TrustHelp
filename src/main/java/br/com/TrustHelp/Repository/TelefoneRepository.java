package br.com.TrustHelp.Repository;

import br.com.TrustHelp.Model.Telefone;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TelefoneRepository {
    private final Map<Integer, Telefone> telefones = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public List<Telefone> findAll() {
        return new ArrayList<>(telefones.values());
    }

    public Optional<Telefone> findById(int id) {
        return Optional.ofNullable(telefones.get(id));
    }

    public Telefone save(Telefone telefone) {
        if (telefone.getId() == 0) {
            telefone.setId(idGenerator.getAndIncrement());
        }
        telefones.put(telefone.getId(), telefone);
        return telefone;
    }

    public boolean existsById(int id) {
        return telefones.containsKey(id);
    }

    public void deleteById(int id) {
        telefones.remove(id);
    }
}
