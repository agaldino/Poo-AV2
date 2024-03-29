/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Local;
import model.Funcionario;

/**
 *
 * @author andre
 */
@Local
public interface FuncionarioFacadeLocal {

    void create(Funcionario funcionario);

    void edit(Funcionario funcionario);

    void remove(Funcionario funcionario);

    Funcionario find(Object id);

    List<Funcionario> findAll();

    List<Funcionario> findRange(int[] range);

    int count();
    
}
