/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package interfaces;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public interface FuncaoSucessor {
    public Set<Acao> acoes(Estado e);
    public double custo(Acao a, Estado e);
    public Set<Map.Entry<Acao,Estado>> sucessores(Estado e);  
}
