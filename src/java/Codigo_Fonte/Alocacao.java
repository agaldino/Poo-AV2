/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Fonte;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "ALOCACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alocacao.findAll", query = "SELECT a FROM Alocacao a"),
    @NamedQuery(name = "Alocacao.findByCodprojeto", query = "SELECT a FROM Alocacao a WHERE a.alocacaoPK.codprojeto = :codprojeto"),
    @NamedQuery(name = "Alocacao.findByCodfuncionario", query = "SELECT a FROM Alocacao a WHERE a.alocacaoPK.codfuncionario = :codfuncionario"),
    @NamedQuery(name = "Alocacao.findByDataalocacao", query = "SELECT a FROM Alocacao a WHERE a.dataalocacao = :dataalocacao")})
public class Alocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlocacaoPK alocacaoPK;
    @Column(name = "DATAALOCACAO")
    @Temporal(TemporalType.DATE)
    private Date dataalocacao;
    @JoinColumn(name = "CODPROJETO", referencedColumnName = "CODPROJETO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projeto projeto;
    @JoinColumn(name = "CODFUNCIONARIO", referencedColumnName = "CODFUNCIONARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public Alocacao() {
    }

    public Alocacao(AlocacaoPK alocacaoPK) {
        this.alocacaoPK = alocacaoPK;
    }

    public Alocacao(int codprojeto, int codfuncionario) {
        this.alocacaoPK = new AlocacaoPK(codprojeto, codfuncionario);
    }

    public AlocacaoPK getAlocacaoPK() {
        return alocacaoPK;
    }

    public void setAlocacaoPK(AlocacaoPK alocacaoPK) {
        this.alocacaoPK = alocacaoPK;
    }

    public Date getDataalocacao() {
        return dataalocacao;
    }

    public void setDataalocacao(Date dataalocacao) {
        this.dataalocacao = dataalocacao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alocacaoPK != null ? alocacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alocacao)) {
            return false;
        }
        Alocacao other = (Alocacao) object;
        if ((this.alocacaoPK == null && other.alocacaoPK != null) || (this.alocacaoPK != null && !this.alocacaoPK.equals(other.alocacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Codigo_Fonte.Alocacao[ alocacaoPK=" + alocacaoPK + " ]";
    }
    
}
