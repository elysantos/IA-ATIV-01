/*
 * Projeto: Exemplos de implementacao de busca em espaço de estados para 
 * disciplina Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package busca.naoinformada;

import estruturas.FIFOQueue;
import estruturas.Nodo;
import interfaces.Acao;
import interfaces.Busca;
import interfaces.Estado;
import interfaces.Problema;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class BuscaEmLargura implements Busca {

    private FIFOQueue<Nodo> fronteira;
    private final List<Estado> estadosVisitados;
    private final Set<Estado> setEstadosVisitados;

    public BuscaEmLargura() {
        this.fronteira = new FIFOQueue<>();
        this.estadosVisitados = new ArrayList<>();
        this.setEstadosVisitados = new HashSet<>(1011);
    }

    @Override
    public List<Acao> buscar(Problema p) {
        System.out.println("\nBusca em Largura...");
        int oldProf = 0;
        int newProf = 0;
        //List<Acao> solucao = null;
        Set<Acao> acoes = null;

        Nodo raiz = new Nodo(null, p.estadoInicial(), null, 0.0, 0);

        fronteira = new FIFOQueue<>();
        fronteira.add(raiz);

        while (!fronteira.isEmpty()) {

            Nodo aExpandir = fronteira.remove();
            newProf = aExpandir.getProfund();
            if (newProf != oldProf) {
                System.out.print("." + newProf + " ");
                oldProf = newProf;
            }
            this.getEstadosVisitados().add(aExpandir.getEstado());
            if (p.testaObjetivo(aExpandir.getEstado())) {
                System.out.println("Objetivo encontrado!");
                return this.solucao(aExpandir);
                //return solucao;
            }

            // TODO substituir por Set<Map.Entry<Acao,Estado>> sucessores(Estado)
            // e usar acoes deste set aqui e os estados no loop interno
            // talvez simplifique um dos loops
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
     * Buscar v.2.0 usa sucessores ao invés de uma chamada dupla para resultado.
     *
     * @param p
     * @return
     */
    public List<Acao> buscar_v2_0(Problema p) {
        System.out.println("\nBusca em Largura v.2.0");
        int oldProf = 0;
        int newProf = 0;
        //List<Acao> solucao = null;
        Set<Acao> acoes = null;
        Set<Map.Entry<Acao, Estado>> map_A_E = null;

        Nodo raiz = new Nodo(null, p.estadoInicial(), null, 0.0, 0);

        fronteira = new FIFOQueue<>();
        
        fronteira.add(raiz);

        while (!fronteira.isEmpty()) {

            Nodo aExpandir = fronteira.remove();
            newProf = aExpandir.getProfund();
            if (newProf != oldProf) {
                System.out.print("." + newProf + " ");
                oldProf = newProf;
            }
            this.getSetEstadosVisitados().add(aExpandir.getEstado());
            if (p.testaObjetivo(aExpandir.getEstado())) {
                System.out.println("Objetivo encontrado!");
                return this.solucao(aExpandir);
                //return solucao;
            }

            // TODO substituir por Set<Map.Entry<Acao,Estado>> sucessores(Estado)
            // e usar acoes deste set aqui e os estados no loop interno
            // talvez simplifique um dos loops
            Set<Map.Entry<Acao, Estado>> s = p.sucessores(aExpandir.getEstado());

            // for each pair (a,e) in sucessores (e)
            for (Map.Entry<Acao, Estado> entry : s) {
                Acao a = entry.getKey();
                Estado sucessor = entry.getValue();
                boolean sucessorRepetido = false;
                //TODO replace with contains in a hash
                if (this.setEstadosVisitados.contains(sucessor)) {
                    //System.out.println(sucessor +" = " + setEstadosVisitados.size());
                    sucessorRepetido=true;
                   // continue;
                }
               
                if (!sucessorRepetido) {

                    getSetEstadosVisitados().add(sucessor);
                    Nodo nodoFilho = new Nodo(aExpandir, sucessor, a, 1, 1);
                    fronteira.add(nodoFilho);

                    //System.out.println("[BEL] De " + aExpandir.getEstado() + " para " + sucessor + "com " + a);
                    //if (p.testaObjetivo(sucessor)) {
                        //System.out.println("Objetivo!");
                        //return this.solucao(aExpandir);
                        //return solucao;
                    //}

                }
            }
            /*
            for (Acao a : acoes) {
                // TODO get a pair (a,e) from sucessores (e)
                // sucessor = e from (a,e) and do not call p.resultdo(a,e)
                Estado sucessor = p.resultado(a, aExpandir.getEstado());

                
                boolean sucessorRepetido = false;
                //TODO replace with contains in a hash
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
             */
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
        return this.setEstadosVisitados;
    }
}
