package br.com.TrustHelp.Record;

import br.com.TrustHelp.Model.User;

public record UserDTO(
        Long id,
        String nome,
        String email,
        String papelId) {}
