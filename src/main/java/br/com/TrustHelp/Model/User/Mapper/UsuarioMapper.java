package br.com.TrustHelp.Model.User.Mapper;

import br.com.TrustHelp.Model.User.Output.UsuarioOutput;
import br.com.TrustHelp.Model.User.UsuarioInfo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    
    public UsuarioOutput toOutput(UsuarioInfo usuario) {
        if (usuario == null) return null;
        
        UsuarioOutput output = new UsuarioOutput();
        output.setId(usuario.getId());
        output.setNome(usuario.getNome());
        output.setEmail(usuario.getEmail());
        output.setAtivo(usuario.getAtivo());
        
        // Papel
        if (usuario.getIdPapel() != null) {
            output.setIdPapel(usuario.getIdPapel());
        }
        
        // Organização
        if (usuario.getIdOrganizacao() != null) {
            output.setIdOrganizacao(usuario.getIdOrganizacao());
        }
        
        
        return output;
    }
    
    public List<UsuarioOutput> toOutputList(List<UsuarioInfo> usuarios) {
        return usuarios.stream()
                .map(this::toOutput)
                .collect(Collectors.toList());
    }
}