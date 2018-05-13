/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.impl.misscanib;

import interfaces.FuncaoHeuristica;

/**
 * Esta heuristica indica quantas pessoas faltam atravessar. 
 * @author jcsilva
 */
public class HeuristicaNumeroDePessoas implements FuncaoHeuristica {

    @Override
    public double h(Object state) {
        EstadoMissCanib e = (EstadoMissCanib) state;
        return (e.getCe()+e.getMe());//
    }
    
}
