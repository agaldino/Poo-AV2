/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Local;
import model.Alocacao;

/**
 *
 * @author andre
 */
@Local
public interface AlocacaoFacadeLocal {

    void create(Alocacao alocacao);

    void edit(Alocacao alocacao);

    void remove(Alocacao alocacao);

    Alocacao find(Object id);

    List<Alocacao> findAll();

    List<Alocacao> findRange(int[] range);

    int count();
    
}
