/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package interfaces;

import impl.quatrocavalos.EstadoQuatroCavalos;
import java.util.ArrayList;

/**
 * Representa uma operação que pode lever de um estado a outro
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public interface Acao {
    public EstadoQuatroCavalos resultado(Estado e);
    public double custo(Estado e);
    public boolean preCondicoesSatisfeitas(Estado e);
}
