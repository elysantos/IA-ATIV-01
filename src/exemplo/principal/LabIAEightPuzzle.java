/*
 *  Copyright(c) by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package exemplo.principal;

import busca.informada.BuscaAStar;
import busca.naoinformada.BuscaEmLargura;
import busca.naoinformada.BuscaEmProfundidade;
import estruturas.Nodo;
import exemplo.impl.eigthpuzzle.EstadoEightPuzzle;

import exemplo.impl.eigthpuzzle.acoes.GapParaBaixo;
import exemplo.impl.eigthpuzzle.acoes.GapParaCima;
import exemplo.impl.eigthpuzzle.acoes.GapParaDireita;
import exemplo.impl.eigthpuzzle.acoes.GapParaEsquerda;
import interfaces.Acao;
import interfaces.FuncaoHeuristica;
import interfaces.Problema;
import java.util.List;
import estruturas.AIMAPriorityQueue;
import exemplo.impl.eigthpuzzle.ProblemaEightPuzzle;
import impl.eigthpuzzle.ManhattanHeuristicFunction;
import impl.eigthpuzzle.MisplacedTilleHeuristicFunction;
import impl.eigthpuzzle.TesteDeObjetivoEightPuzzle;
import interfaces.Busca;
import interfaces.Estado;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class LabIAEightPuzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Acao cim = new GapParaCima();
        Acao bai = new GapParaBaixo();
        Acao dir = new GapParaDireita();
        Acao esq = new GapParaEsquerda();
        TesteDeObjetivoEightPuzzle t = new TesteDeObjetivoEightPuzzle();
        FuncaoHeuristica fh = new MisplacedTilleHeuristicFunction();

        EstadoEightPuzzle e = new EstadoEightPuzzle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        EstadoEightPuzzle e2 = e;
        System.out.println("objetivo e?" + t.ehObjetivo(e));

        System.out.println("main$\n" + e + " obj?" + t.ehObjetivo(e)+"/h="+fh.h(e));
        e = (EstadoEightPuzzle) dir.resultado(dir.resultado(dir.resultado(e)));
        System.out.println("main$\n" + e + " obj?" + t.ehObjetivo(e)+"/h="+fh.h(e));
        e = (EstadoEightPuzzle) bai.resultado(bai.resultado(bai.resultado(e)));
        System.out.println("main$\n" + e + " obj?" + t.ehObjetivo(e)+"/h="+fh.h(e));
        e = (EstadoEightPuzzle) esq.resultado(esq.resultado(esq.resultado(e)));
        System.out.println("main$\n" + e + " obj?" + t.ehObjetivo(e)+"/h="+fh.h(e));
        e = (EstadoEightPuzzle) cim.resultado(cim.resultado(cim.resultado(e)));
        System.out.println("main$\n" + e + " obj?" + t.ehObjetivo(e)+"/h="+fh.h(e));
         
        Problema p = new ProblemaEightPuzzle(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        BuscaEmLargura bel1 = new BuscaEmLargura();
        BuscaEmLargura bel2 = new BuscaEmLargura();
        
        BuscaEmProfundidade bep = new BuscaEmProfundidade();

        FuncaoHeuristica h; 
        h = new ManhattanHeuristicFunction();
        //h = new MisplacedTilleHeuristicFunction();
        BuscaAStar bas = new BuscaAStar(h);
        
        long t0 = System.currentTimeMillis();
        List<Acao> result1 = bel1.buscar_v2_0(p);
        long t1 = System.currentTimeMillis();
        List<Acao> result2 = bep.buscarComLimite(p,25);
        long t2 = System.currentTimeMillis();
        List<Acao> result3 = bas.buscar(p);
        //List<Acao> result = busca.buscar(p);
        long t3 = System.currentTimeMillis();

        e = (EstadoEightPuzzle) p.estadoInicial();
        System.out.println("[inicio]\n" + p.estadoInicial());
        for (int i = 0; i < result2.size(); i++) {
            System.out.println("[Passo " + i + "]" + result2.get(i));
            Acao a = result2.get(i);
            e = (EstadoEightPuzzle) a.resultado(e);
            System.out.println(e);
        }
//        System.out.println("Elapsed time \n"+
//                " t1 = "+(t1-t0)+" (ms). Nodos visitados : "+bel1.getMaxVisitSize()+" Max front: "+bel1.getMaxFrontSize()+"\n"+
//                " t2 = "+(t2-t1)+" (ms). Nodos visitados : "+bep.getMaxVisitSize()+" Max front: "+bep.getMaxFrontSize()+"\n"+
//                " t3 = "+(t3-t2)+" (ms). Nodos visitados : "+ bas.getMaxVisitSize()+" Max front: "+bas.getMaxFrontSize());

        
    }

}
