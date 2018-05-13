/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package impl.eigthpuzzle;

import impl.eigthpuzzle.acoes.GapParaBaixo;
import impl.eigthpuzzle.acoes.GapParaCima;
import impl.eigthpuzzle.acoes.GapParaDireita;
import impl.eigthpuzzle.acoes.GapParaEsquerda;
import interfaces.Acao;
import interfaces.Estado;
import java.util.HashSet;
import java.util.Set;
import interfaces.FuncaoSucessor;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class FuncaoSucessorEightPuzzle implements FuncaoSucessor {

    private final List<Acao> acoes;

    public FuncaoSucessorEightPuzzle() {
        this.acoes = new ArrayList<>();
        this.acoes.add(new GapParaCima());
        this.acoes.add(new GapParaBaixo());
        this.acoes.add(new GapParaDireita());
        this.acoes.add(new GapParaEsquerda());
    }

    @Override
    public Set<Acao> acoes(Estado e) {
        Set<Acao> acoesValidas = new HashSet();
        for(Acao a: this.acoes){
           
            if (a.resultado(e).estadoValido()) //TODO if a.preCondicoesSatisfeitas()
                acoesValidas.add(a);
        }
        
        return acoesValidas;
    }

    @Override
    public double custo(Acao a, Estado e) {
        return a.custo(e);
    }

    @Override
    public Set<Map.Entry<Acao, Estado>> sucessores(Estado e) {
        Set<Map.Entry<Acao, Estado>> set = new HashSet<>();
        Map.Entry<Acao, Estado> tupla = null;

        for (Acao a : this.acoes) {
            Estado result = a.resultado(e);
            if (result.estadoValido()) { //TODO if a.preCondicoesSatisfeitas()
                tupla = new AbstractMap.SimpleEntry(a, result);
                set.add(tupla);
            }
        }

        return set;
    }

   
}
