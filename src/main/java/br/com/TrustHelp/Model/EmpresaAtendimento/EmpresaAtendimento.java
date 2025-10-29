package br.com.TrustHelp.Model.EmpresaAtendimento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa_atendimento", uniqueConstraints = {
        @UniqueConstraint(name = "empresa_atendimento_emp_cnpj_key", columnNames = {"emp_cnpj"}),
        @UniqueConstraint(name = "empresa_atendimento_emp_email_key", columnNames = {"emp_email"})
})
public class EmpresaAtendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa_atendimento", nullable = false)
    private Integer id;

    @Column(name = "emp_nome", nullable = false, length = 150)
    private String empNome;

    @Column(name = "emp_cnpj", nullable = false, length = 14)
    private String empCnpj;

    @Column(name = "emp_email", length = 100)
    private String empEmail;

    @Column(name = "emp_telefone", length = 15)
    private String empTelefone;

}