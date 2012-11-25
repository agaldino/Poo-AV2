/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Local;
import model.Projeto;

/**
 *
 * @author andre
 */
@Local
public interface ProjetoFacadeLocal {

    void create(Projeto projeto);

    void edit(Projeto projeto);

    void remove(Projeto projeto);

    Projeto find(Object id);

    List<Projeto> findAll();

    List<Projeto> findRange(int[] range);

    int count();
    
}
