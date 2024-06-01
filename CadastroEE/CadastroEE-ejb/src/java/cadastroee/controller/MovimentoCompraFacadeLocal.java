/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.MovimentoCompra;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Jefferson
 */
@Local
public interface MovimentoCompraFacadeLocal {

    void create(MovimentoCompra movimentoCompra);

    void edit(MovimentoCompra movimentoCompra);

    void remove(MovimentoCompra movimentoCompra);

    MovimentoCompra find(Object id);

    List<MovimentoCompra> findAll();

    List<MovimentoCompra> findRange(int[] range);

    int count();
    
}
