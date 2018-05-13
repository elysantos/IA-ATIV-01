/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package impl.eigthpuzzle;

import interfaces.Estado;
import interfaces.TesteDeObjetivo;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class TesteDeObjetivoEightPuzzle implements TesteDeObjetivo {

    private final EstadoEightPuzzle objetivo;

    /**
     * Cria um teste de objetivo default. Neste caso, o objetivo é levar todos 
     * para a margem direita do rio. 
     */
    public TesteDeObjetivoEightPuzzle() {
        this.objetivo = new EstadoEightPuzzle (new int[]{0,1,2,3,4,5,6,7,8});
    }
    
    @Override
    public boolean ehObjetivo(Estado e) {
        return ((EstadoEightPuzzle) e).igual(this.objetivo);
    }

}
