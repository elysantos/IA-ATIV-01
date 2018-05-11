/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package impl.misscanib;

import interfaces.Estado;
import interfaces.TesteDeObjetivo;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class TesteDeObjetivoMissCanib implements TesteDeObjetivo {

    private EstadoMissCanib objetivo;

    /**
     * Cria um teste de objetivo default. Neste caso, o objetivo é levar todos 
     * para a margem direita do rio. 
     * @param inicial
     */
    public TesteDeObjetivoMissCanib() {
        this.objetivo = new EstadoMissCanib (0,0,'D',3,3);
    }
    
    /**
     * Cria um teste de objetivo para um estado inicial dado. O objetivo será 
     * o inverso do estado inicial dado. Caso o estado inicial seja invalido o 
     * objetivo default será usado.
     * @param inicial um estado válido para o Missionários e Canibais.
     */
    public TesteDeObjetivoMissCanib(EstadoMissCanib inicial) {
        char bi = inicial.getB();
        char barco = '0';
        int me = 0, ce = 0, md = 0, cd = 0;
        
        // Caso o estado informado seja inválido, usa o estado default
        this.objetivo = new EstadoMissCanib(0,0,'D',3,3); 

        if (inicial.estadoValido()) {
            // inverte os valores de esquerda para direita
            md = inicial.getMe();
            cd = inicial.getCe();
            me = inicial.getMd();
            ce = inicial.getCd();
            if ('E' == bi) {
                barco = 'D';
            } else if ('D' == bi) {
                barco = 'E';

            }
            this.objetivo = new EstadoMissCanib(me, ce, barco, md, cd);
        }
    }

    /**
     * 
     *
     * @param e
     * @return
     */
    @Override
    public boolean ehObjetivo(Estado e) {
        return ((EstadoMissCanib) e).igual(this.objetivo);
    }

}
