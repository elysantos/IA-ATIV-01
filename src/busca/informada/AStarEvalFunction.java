/*
 * Projeto: Exemplos de implementacao de busca em espaço de estados para 
 * disciplina Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015-2017 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package busca.informada;

import estruturas.Nodo;
import interfaces.EvaluationFunction;
import interfaces.FuncaoHeuristica;

/**
 *
 * @author jcsilva
 */
public class AStarEvalFunction implements EvaluationFunction{
    
	private FuncaoHeuristica h = null;

	public AStarEvalFunction(FuncaoHeuristica h) {
		this.h = h;
	}

	/**
	 * Returns <em>g(n)</em> the cost to reach the node, plus <em>h(n)</em> the
	 * heuristic cost to get from the specified node to the goal.
	 * 
	 * @param n
	 *            a node
	 * @return g(n) + h(n)
	 */
        @Override
	public double f(Nodo n) {
		// f(n) = g(n) + h(n)
		return n.getCusto() + h.h(n.getEstado());
	}
    
}
