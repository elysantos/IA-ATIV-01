/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package exemplo.impl.misscanib;

import exemplo.impl.misscanib.acoes.*;
//import impl.misscanib.acoes.Mover1M1C;
//import impl.misscanib.acoes.Mover2C;
//import impl.misscanib.acoes.Mover2M;
//import impl.misscanib.acoes.MoverC;
//import impl.misscanib.acoes.MoverM;;
import interfaces.Acao;
import interfaces.Estado;
import java.util.HashSet;
import java.util.Set;
import interfaces.FuncaoSucessor;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class FuncaoSucessorMissCanib implements FuncaoSucessor {

    private final List<AcaoMissCanib> acoes;

    public FuncaoSucessorMissCanib() {
        this.acoes = new ArrayList<>();
        this.acoes.add(new MoverM());
        this.acoes.add(new Mover2M());
        this.acoes.add(new MoverC());
        this.acoes.add(new Mover2C());
        this.acoes.add(new Mover1M1C());
    }

    @Override
    public Set<Acao> acoes(Estado e) {
        Set<Acao> acoesValidas = new HashSet();
        for (Acao a : this.acoes) {

            if (a.resultado(e).estadoValido()) //TODO if a.preCondicoesSatisfeitas()
            {
                acoesValidas.add(a);
            }
        }

        return acoesValidas;
    }

    @Override
    public double custo(Acao a, Estado e) {
        return a.custo(e);
    }
    /**
     * Produz um conjunto de  tuplas (acao,estado), com estados validos apenas. 
     * @param e um estado
     * @return um conjunto de pares (acao, estado)
     */
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
