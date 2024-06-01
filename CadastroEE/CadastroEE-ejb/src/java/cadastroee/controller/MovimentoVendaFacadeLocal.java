/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.MovimentoVenda;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Jefferson
 */
@Local
public interface MovimentoVendaFacadeLocal {

    void create(MovimentoVenda movimentoVenda);

    void edit(MovimentoVenda movimentoVenda);

    void remove(MovimentoVenda movimentoVenda);

    MovimentoVenda find(Object id);

    List<MovimentoVenda> findAll();

    List<MovimentoVenda> findRange(int[] range);

    int count();
    
}
