/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package exemplo.impl.eigthpuzzle;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.Problema;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class ProblemaEightPuzzle implements Problema {

    private final FuncaoSucessorEightPuzzle fs;
    private final EstadoEightPuzzle inicio;
    private final TesteDeObjetivoEightPuzzle testObjetivo;

    /**
     * Construtor default. Assume o estado inicial <3,3,'E',0,0>.
     */
    public ProblemaEightPuzzle() {
        this.fs = new FuncaoSucessorEightPuzzle();
        this.inicio = new EstadoEightPuzzle(new int[]{5, 4, 0, 6, 1, 8, 7, 3, 2});
        this.testObjetivo = new TesteDeObjetivoEightPuzzle();
    }

    /**
     * Construtor de Problema com objetivo dado por meio de teste e não estado
     * final. O teste é inicializado a partir de um estado inicial válido. Caso
     * o estado seja inválido, o estado default '33E00' será utilizado.
     *
     * @param ini estado inicial
     */
    public ProblemaEightPuzzle(int[] ini) {
        this.fs = new FuncaoSucessorEightPuzzle();
        if (ini == null) {
            ini = new int[]{5, 4, 0, 6, 1, 8, 7, 3, 2}; // default
        }
        this.inicio = new EstadoEightPuzzle(ini);
        this.testObjetivo = new TesteDeObjetivoEightPuzzle();
    }

    @Override
    public Estado resultado(Acao a, Estado e) {
        return a.resultado(e);
    }

    @Override
    public Set<Acao> acoes(Estado e) {
        return this.fs.acoes(e);
    }

    @Override
    public boolean testaObjetivo(Estado e) {
        return this.testObjetivo.ehObjetivo(e);
    }

    @Override
    public double custo(Acao a, Estado e) {
        return a.custo(e);
    }

    @Override
    public Estado estadoInicial() {
        return this.inicio;
    }

    @Override
    public Set<Map.Entry<Acao, Estado>> sucessores(Estado e) {
        return this.fs.sucessores(e);
    }

}
