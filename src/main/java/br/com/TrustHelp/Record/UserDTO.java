package br.com.TrustHelp.Record;

public record UserDTO(
        Long id,
        String nome,
        String email,
        String papelId) {}
