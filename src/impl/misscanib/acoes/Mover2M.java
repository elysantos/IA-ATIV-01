/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package impl.misscanib.acoes;

import impl.misscanib.EstadoMissCanib;
import interfaces.Acao;
import interfaces.Estado;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class Mover2M extends AcaoMissCanib{
    
    public Mover2M(){
        super("Mover 2 missionarios");
    }

    @Override
    public Estado resultado(Estado e) {
        char barco = ((EstadoMissCanib) e).getB();
        int md = ((EstadoMissCanib) e).getMd(),
            me = ((EstadoMissCanib) e).getMe(),
            cd = ((EstadoMissCanib) e).getCd(),
            ce = ((EstadoMissCanib) e).getCe();

        if (barco == 'E') {
            // esquerda para direita
            barco = 'D';
            me-=2;
            md+=2;
        }else{
            // direita para esquerda
            barco = 'E';
            md-=2;
            me+=2;         
        }
        Estado novoEstado = new EstadoMissCanib(me, ce, barco, md, cd);

        return novoEstado;
  }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

