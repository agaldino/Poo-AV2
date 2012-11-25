/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodfuncionario", query = "SELECT f FROM Funcionario f WHERE f.codfuncionario = :codfuncionario"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByDatanasc", query = "SELECT f FROM Funcionario f WHERE f.datanasc = :datanasc"),
    @NamedQuery(name = "Funcionario.findByEspecialidade", query = "SELECT f FROM Funcionario f WHERE f.especialidade = :especialidade"),
    @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo"),
    @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario"),
    @NamedQuery(name = "Funcionario.findBySexo", query = "SELECT f FROM Funcionario f WHERE f.sexo = :sexo"),
    @NamedQuery(name = "Funcionario.findByBAtivo", query = "SELECT f FROM Funcionario f WHERE f.bAtivo = :bAtivo")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODFUNCIONARIO")
    private Integer codfuncionario;
    @Size(max = 500)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATANASC")
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    @Size(max = 500)
    @Column(name = "ESPECIALIDADE")
    private String especialidade;
    @Size(max = 255)
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "SALARIO")
    private Integer salario;
    @Column(name = "SEXO")
    private Character sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "B_ATIVO")
    private Serializable bAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private Collection<Alocacao> alocacaoCollection;

    public Funcionario() {
    }

    public Funcionario(Integer codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public Funcionario(Integer codfuncionario, Serializable bAtivo) {
        this.codfuncionario = codfuncionario;
        this.bAtivo = bAtivo;
    }

    public Integer getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(Integer codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Serializable getBAtivo() {
        return bAtivo;
    }

    public void setBAtivo(Serializable bAtivo) {
        this.bAtivo = bAtivo;
    }

    @XmlTransient
    public Collection<Alocacao> getAlocacaoCollection() {
        return alocacaoCollection;
    }

    public void setAlocacaoCollection(Collection<Alocacao> alocacaoCollection) {
        this.alocacaoCollection = alocacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfuncionario != null ? codfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codfuncionario == null && other.codfuncionario != null) || (this.codfuncionario != null && !this.codfuncionario.equals(other.codfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcionario[ codfuncionario=" + codfuncionario + " ]";
    }
    
}
