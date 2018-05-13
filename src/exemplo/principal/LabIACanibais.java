/*
 *  Copyright(c) by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package exemplo.principal;

import busca.informada.BuscaAStar;
import busca.naoinformada.BuscaEmLargura;
import busca.naoinformada.BuscaEmProfundidade;
import impl.eigthpuzzle.MisplacedTilleHeuristicFunction;
import exemplo.impl.misscanib.HeuristicaNumeroDePessoas;
import exemplo.impl.misscanib.ProblemaMissCanib;
import interfaces.Acao;
import interfaces.Estado;
import interfaces.FuncaoHeuristica;
import interfaces.Problema;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class LabIACanibais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Problema p = new ProblemaMissCanib();
        BuscaEmProfundidade b1 = new BuscaEmProfundidade();
        BuscaEmLargura b2 = new BuscaEmLargura();
        FuncaoHeuristica h= new HeuristicaNumeroDePessoas();
        BuscaAStar b3 = new BuscaAStar(h);
        long t0 = System.currentTimeMillis();
        List<Acao> result1 = b1.buscar(p);
        if (result1.get(0).getClass().getSimpleName().equals("CutOff")) System.out.println("Cutoff reached.");
        System.out.println("");
        long t1 = System.currentTimeMillis();
        List<Acao> result2 = b2.buscar(p);
        long t2 = System.currentTimeMillis();
        List<Acao> result3 = b2.buscar_v2_0(p);
        long t3 = System.currentTimeMillis();
        List<Acao> result4 = b3.buscar(p);
        long t4 = System.currentTimeMillis();
        Estado e = p.estadoInicial();
//        //System.out.println(e);
//        //for (int i = 0; i < result1.size(); i++) {
//        //    System.out.println("[Passo " + i + "]" + result1.get(i));
//        //    Acao a = result1.get(i);
//        //    e = a.resultado(e);
//        //    System.out.println(e);
//        //}
//        System.out.println("Elapsed time \n"+
//                " t1 = "+(t1-t0)+" (ms). Nodos visitados : "+ b1.getMaxVisitSize()+"\n"+
//                " t2 = "+(t2-t1)+" (ms). Nodos visitados : "+ b2.getMaxVisitSize()+"\n"+
//                " t3 = "+(t3-t2)+" (ms). Nodos visitados : "+ b2.getMaxVisitSize()+"\n"+
//                " t4 = "+(t4-t3)+" (ms). Nodos visitados : "+ b3.getMaxVisitSize());
    }

}
