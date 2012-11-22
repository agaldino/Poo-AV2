/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Fonte;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author andre
 */
@Embeddable
public class AlocacaoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CODPROJETO")
    private int codprojeto;
    @Basic(optional = false)
    @Column(name = "CODFUNCIONARIO")
    private int codfuncionario;

    public AlocacaoPK() {
    }

    public AlocacaoPK(int codprojeto, int codfuncionario) {
        this.codprojeto = codprojeto;
        this.codfuncionario = codfuncionario;
    }

    public int getCodprojeto() {
        return codprojeto;
    }

    public void setCodprojeto(int codprojeto) {
        this.codprojeto = codprojeto;
    }

    public int getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(int codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codprojeto;
        hash += (int) codfuncionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlocacaoPK)) {
            return false;
        }
        AlocacaoPK other = (AlocacaoPK) object;
        if (this.codprojeto != other.codprojeto) {
            return false;
        }
        if (this.codfuncionario != other.codfuncionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Codigo_Fonte.AlocacaoPK[ codprojeto=" + codprojeto + ", codfuncionario=" + codfuncionario + " ]";
    }
    
}
