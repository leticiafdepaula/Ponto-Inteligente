package com.ponto_inteligente.api.entities;

import com.ponto_inteligente.api.enums.PerfilEnum;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table( name = "funcionarios")
public class Funcionarios implements Serializable {
    private static final long serialVersionUID = -57546207015712518L;
    private long Id;
    private String name;
    private String email;
    private String senha;
    private String cpf;
    private PerfilEnum perfil;
    private BigDecimal valorHora;
    private float qtdHorasTrabalhoDia;
    private float qtdHorasAlmoco;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private Empresa empresa;
    private List<Lancamento>lancamentos;

    public Funcionarios() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "senha", nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Column(name = "cpf", nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    @Column(name = "valor_Hora", nullable = true)
    public BigDecimal getValorHora() {
        return valorHora;
    }

    @Transient
    public Optional<BigDecimal> getValorHora0pt() {
        return Optional.ofNullable (valorHora);
    }
    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }
    @Column(name = "qtd_Horas_Trabalho_Dia", nullable = true)
    public float getqtdHorasTrabalhoDia() {
        return qtdHorasTrabalhoDia;
    }

    @Transient
    public Optional<Float> getqtdHorasTrabalhoDia0pt() {
        return Optional.ofNullable (qtdHorasTrabalhoDia);
    }
    public void setQtdHorasTrabalhoDia(float qtdHorasTrabalhoDia) {
        this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
    }
    @Column(name = "gtd_Horas_Almoco", nullable = true)
    public float getGtdHorasAlmoco() {
        return qtdHorasAlmoco;
    }

    @Transient
    public Optional<Float> getGtdHorasAlmoco0pt() {
        return Optional.ofNullable (qtdHorasAlmoco);
    }
    public void setGtdHorasAlmoco(float gtdHorasAlmoco) {
        this.qtdHorasAlmoco = gtdHorasAlmoco;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false)
    public PerfilEnum getPerfil() {
        return perfil;
    }

   public void setPerfil(PerfilEnum perfil) {
      this.perfil = perfil;
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

    @ManyToOne(fetch = FetchType.EAGER)
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + name + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
                + ", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco="
                + qtdHorasAlmoco + ", perfil=" + perfil + ", dataCriacao="
                + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", empresa=" + empresa + "]";
    }

}
