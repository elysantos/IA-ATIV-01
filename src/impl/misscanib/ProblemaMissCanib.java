/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package impl.misscanib;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.Problema;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class ProblemaMissCanib implements Problema {

    private final FuncaoSucessorMissCanib fs;
    private final EstadoMissCanib inicio;
    private final TesteDeObjetivoMissCanib testObjetivo;

    /**
     * Construtor default. Assume o estado inicial <3,3,'E',0,0>.
     */
    public ProblemaMissCanib() {
        this.fs = new FuncaoSucessorMissCanib();
        this.inicio = new EstadoMissCanib(3, 3, 'E', 0, 0);
        this.testObjetivo = new TesteDeObjetivoMissCanib(this.inicio);
    }

    /**
     * Construtor de Problema com objetivo dado por meio de teste e não estado
     * final. O teste é inicializado a partir de um estado inicial válido. Caso 
     * o estado seja inválido, o estado default '33E00' será utilizado.
     *
     * @param ini estado inicial
     */
    public ProblemaMissCanib(EstadoMissCanib ini) {
        this.fs = new FuncaoSucessorMissCanib();
        this.testObjetivo = new TesteDeObjetivoMissCanib(ini);
        if (ini.estadoValido()){
         this.inicio=ini;   
        }else{
            this.inicio=new EstadoMissCanib(3,3,'E',0,0);
        }
    }
   /**
     * Construtor de Problema com objetivo dado por meio de teste e não estado
     * final. O teste é informado por parâmetro. Caso 
     * o estado seja inválido, o estado default '33E00' será utilizado.
     *
     * @param ini estado inicial
     * @param t um teste de objetivo 
     */
    public ProblemaMissCanib(EstadoMissCanib ini, boolean objetivoDefault) {
        this.fs = new FuncaoSucessorMissCanib();
        
        if (ini.estadoValido()){
         this.inicio=ini;   
        }else{
            this.inicio=new EstadoMissCanib(3,3,'E',0,0);
        }
        
        if (objetivoDefault){//ir até o objetivo defalt
            this.testObjetivo = new TesteDeObjetivoMissCanib();
        }else{// ir até o inverso do estado inicial
            this.testObjetivo = new TesteDeObjetivoMissCanib(ini);
        }
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
