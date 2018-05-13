/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.impl.eigthpuzzle.acoes;

import exemplo.impl.eigthpuzzle.EstadoEightPuzzle;
import interfaces.Acao;
import interfaces.Estado;

/**
 *
 * @author jcsilva
 */
public class GapParaCima implements Acao {
    @Override
    public Estado resultado(Estado e) {
        EstadoEightPuzzle e1 = ((EstadoEightPuzzle) e).moveGapPraCima();
        return e1;
    }

    @Override
    public double custo(Estado e) {
        return 1.0;
    }
    @Override
    public String toString(){
        return "Para cima";
    }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
