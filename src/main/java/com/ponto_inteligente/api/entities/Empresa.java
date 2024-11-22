package com.ponto_inteligente.api.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 3906043664935666213l;

    private long Id;
    private String razaoSocial;
    private String cnpj;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private List<Funcionarios> funcionarios;

    public Empresa() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return Id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setId(long id) {
        Id = id;
    }

    @Column(name = "razao_social", nullable = false)
    public void getRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Column(name = "cnpj", nullable = false)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Column(name = "data_criacao", nullable = false)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Column(name = "data_atualizacao", nullable = false)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @OneToMany(mappedBy = "empresa")
    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionarios> funcionarios) {

        this.funcionarios = funcionarios;
    }

    @PreUpdate
    public void PreUpdate() {
        dataAtualizacao = new Date ();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date ();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id +", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao +", dataAtualizacao=" + dataAtualizacao +"]";
    }
}