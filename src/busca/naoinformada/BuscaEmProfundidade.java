/*
 * Projeto: Exemplos de implementacao de busca em espaço de estados para 
 * disciplina Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package busca.naoinformada;

import estruturas.LIFOQueue;
import estruturas.Nodo;
import interfaces.Acao;
import interfaces.Busca;
import interfaces.Estado;
import interfaces.Problema;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class BuscaEmProfundidade implements Busca {

    private final LIFOQueue<Nodo> fronteira;
    private final List<Estado> estadosVisitados;
    private final Set<Estado> setEstadosVisitados;

    
    public BuscaEmProfundidade() {
        this.fronteira = new LIFOQueue<>();
        this.estadosVisitados = new ArrayList();
        this.setEstadosVisitados = new HashSet();
    }

    @Override
    public List<Acao> buscar(Problema p) {
        System.out.println("\nBusca em profundidade ...");
        //List<Acao> solucao = null;
        int oldProf=0,newProf=0;
        Set<Acao> acoes = null;

        Nodo raiz = new Nodo(null, p.estadoInicial(), null, 0.0, 0);

        fronteira.add(raiz);

        while (!fronteira.isEmpty()) {
            
            Nodo aExpandir = fronteira.remove();
            newProf = aExpandir.getProfund();
            if (newProf != oldProf) {
                System.out.print("_" + newProf+" ");
                oldProf = newProf;
            }
            this.getEstadosVisitados().add(aExpandir.getEstado());
            if (p.testaObjetivo(aExpandir.getEstado())) {
                System.out.println("Objetivo encontrado!");
                return this.solucao(aExpandir);
                //return solucao;
            }

            acoes = p.acoes(aExpandir.getEstado());
            if (acoes == null) {
                return null;
            }
  
            for (Acao a : acoes) {

                Estado sucessor = p.resultado(a, aExpandir.getEstado());

                boolean sucessorRepetido = false;
                for (Estado e : getEstadosVisitados()) {
                    if (e.igual(sucessor)) {
                        sucessorRepetido = true;
                        //System.out.println("   [BEL] De " + aExpandir.getEstado() + " para " + sucessor + "com " + a + "REPETIDO");
                        break;
                    };
                }
                if (!sucessorRepetido) {

                    getEstadosVisitados().add(sucessor);
                    Nodo nodoFilho = new Nodo(aExpandir, sucessor, a, 1, 1);
                    fronteira.add(nodoFilho);
                    
                    //System.out.println("[BEL] De " + aExpandir.getEstado() + " para " + sucessor + "com " + a);
                    if (p.testaObjetivo(sucessor)) {
                        //System.out.println("Objetivo!");
                        //return this.solucao(aExpandir);
                        //return solucao;
                    }

                }
            }
        }

        return null;
    }

    /**
     * Busca em profundidade limitada
     * @param p
     * @param limite
     * @return
     */
    public List<Acao> buscarComLimite(Problema p, int limite) {
        System.out.println("\nBusca com profundidade limitada....");
        //List<Acao> solucao = null;
        int oldProf=0,newProf=0;
        Set<Acao> acoes = null;

        Nodo raiz = new Nodo(null, p.estadoInicial(), null, 0.0, 0);

        fronteira.add(raiz);

        while (!fronteira.isEmpty()) {
            
            Nodo aExpandir = fronteira.remove();
            newProf = aExpandir.getProfund();
            
            if (aExpandir.getProfund()>limite) return null;
            
            if (newProf != oldProf) {
                System.out.print("/" + newProf+" ");
                oldProf = newProf;
            }
            this.getEstadosVisitados().add(aExpandir.getEstado());
            if (p.testaObjetivo(aExpandir.getEstado())) {
                System.out.println("\nObjetivo encontrado!");
                return this.solucao(aExpandir);
                //return solucao;
            }

            acoes = p.acoes(aExpandir.getEstado());
            if (acoes == null) {
                return null;
            }
  
            for (Acao a : acoes) {

                Estado sucessor = p.resultado(a, aExpandir.getEstado());

                boolean sucessorRepetido = false;
                for (Estado e : getEstadosVisitados()) {
                    if (e.igual(sucessor)) {
                        sucessorRepetido = true;
                        //System.out.println("   [BEL] De " + aExpandir.getEstado() + " para " + sucessor + "com " + a + "REPETIDO");
                        break;
                    };
                }
                if (!sucessorRepetido) {

                    getEstadosVisitados().add(sucessor);
                    Nodo nodoFilho = new Nodo(aExpandir, sucessor, a, 1, 1);
                    fronteira.add(nodoFilho);
                    
                    //System.out.println("[BEL] De " + aExpandir.getEstado() + " para " + sucessor + "com " + a);
                    if (p.testaObjetivo(sucessor)) {
                        //System.out.println("Objetivo!");
                        //return this.solucao(aExpandir);
                        //return solucao;
                    }

                }
            }
        }

        return null;
    }


    private List<Acao> solucao(Nodo n) {
        List<Acao> s = null;

        if (n != null) {
            s = new ArrayList();
        }

        while (n != null) {
            if (n.getAcao() != null) {
                s.add(0, n.getAcao());
            }
            n = n.getPai();
        }

        return s;
    }

    @Override
    public List<Estado> getEstadosVisitados() {
        return estadosVisitados;
    }

    @Override
    public Set<Estado> getSetEstadosVisitados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
