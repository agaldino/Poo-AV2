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
@Table(name = "PROJETO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projeto.findAll", query = "SELECT p FROM Projeto p"),
    @NamedQuery(name = "Projeto.findByCodprojeto", query = "SELECT p FROM Projeto p WHERE p.codprojeto = :codprojeto"),
    @NamedQuery(name = "Projeto.findByNomeprojeto", query = "SELECT p FROM Projeto p WHERE p.nomeprojeto = :nomeprojeto"),
    @NamedQuery(name = "Projeto.findByFinanciado", query = "SELECT p FROM Projeto p WHERE p.financiado = :financiado"),
    @NamedQuery(name = "Projeto.findByDtinicio", query = "SELECT p FROM Projeto p WHERE p.dtinicio = :dtinicio"),
    @NamedQuery(name = "Projeto.findByDtencerramento", query = "SELECT p FROM Projeto p WHERE p.dtencerramento = :dtencerramento"),
    @NamedQuery(name = "Projeto.findByInvestimento", query = "SELECT p FROM Projeto p WHERE p.investimento = :investimento"),
    @NamedQuery(name = "Projeto.findByResponsavel", query = "SELECT p FROM Projeto p WHERE p.responsavel = :responsavel")})
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODPROJETO")
    private Integer codprojeto;
    @Size(max = 500)
    @Column(name = "NOMEPROJETO")
    private String nomeprojeto;
    @Size(max = 500)
    @Column(name = "FINANCIADO")
    private String financiado;
    @Column(name = "DTINICIO")
    @Temporal(TemporalType.DATE)
    private Date dtinicio;
    @Column(name = "DTENCERRAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtencerramento;
    @Column(name = "INVESTIMENTO")
    private Integer investimento;
    @Size(max = 255)
    @Column(name = "RESPONSAVEL")
    private String responsavel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto")
    private Collection<Alocacao> alocacaoCollection;

    public Projeto() {
    }

    public Projeto(Integer codprojeto) {
        this.codprojeto = codprojeto;
    }

    public Integer getCodprojeto() {
        return codprojeto;
    }

    public void setCodprojeto(Integer codprojeto) {
        this.codprojeto = codprojeto;
    }

    public String getNomeprojeto() {
        return nomeprojeto;
    }

    public void setNomeprojeto(String nomeprojeto) {
        this.nomeprojeto = nomeprojeto;
    }

    public String getFinanciado() {
        return financiado;
    }

    public void setFinanciado(String financiado) {
        this.financiado = financiado;
    }

    public Date getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(Date dtinicio) {
        this.dtinicio = dtinicio;
    }

    public Date getDtencerramento() {
        return dtencerramento;
    }

    public void setDtencerramento(Date dtencerramento) {
        this.dtencerramento = dtencerramento;
    }

    public Integer getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Integer investimento) {
        this.investimento = investimento;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
        hash += (codprojeto != null ? codprojeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projeto)) {
            return false;
        }
        Projeto other = (Projeto) object;
        if ((this.codprojeto == null && other.codprojeto != null) || (this.codprojeto != null && !this.codprojeto.equals(other.codprojeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Projeto[ codprojeto=" + codprojeto + " ]";
    }
    
}
