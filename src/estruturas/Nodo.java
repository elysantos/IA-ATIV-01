/*
 * Projeto: Exemplos de implementacao de busca em espaço de estados para 
 * disciplina Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package estruturas;

import interfaces.EvaluationFunction;
import interfaces.Acao;
import interfaces.Estado;
import java.util.Comparator;

/**
 * Classe com informações utilizada pelos algoritmos de busca.
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class Nodo {

    private final Nodo pai; // o antecessor deste nodo
    private final Estado estado; // o estado deste nodo
    private final Acao acao; // acao usada para gerar o estado deste nodo
    private final double custo; // custo do pai até este nodo com a acao
    private final int profund; // profundidade do nodo na estrutura se for arvore 

    public Nodo(Nodo pai, Estado estado, Acao acao, double custo, int profund) {
        this.pai = pai;
        this.estado = estado;
        this.acao = acao;
        if (pai != null) {
            this.custo = pai.getCusto() + custo;
        } else {
            this.custo = custo;
        }
        if (pai != null) {
            this.profund = pai.getProfund() + profund;
        } else {
            this.profund=profund;
        }
    }

    public Nodo getPai() {
        return pai;
    }

    public Estado getEstado() {
        return estado;
    }

    public Acao getAcao() {
        return acao;
    }

    public double getCusto() {
        return custo;
    }

    public int getProfund() {
        return profund;
    }

    /**
     * This method allow us to use Nodo in a priority queue, as needed by A*
     * algo.
     *
     * @param ef an evaluation function, p.ex. f(n) = g(n) + h(n) no A
     *
     * @return a node comparator object that can be used in a priority queue
     */
    public static Comparator<Nodo> createComparator(final EvaluationFunction ef) {
        return new Comparator<Nodo>() {
            @Override
            public int compare(Nodo n1, Nodo n2) {
                Double f1 = ef.f(n1);
                Double f2 = ef.f(n2);
                return f1.compareTo(f2);
            }
        };
    }

}
