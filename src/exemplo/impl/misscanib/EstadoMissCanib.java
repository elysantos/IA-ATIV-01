/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */


package exemplo.impl.misscanib;

import interfaces.Acao;
import interfaces.Estado;
import java.util.Set;

/**
 * Representa uma configuração do mundo em um dado momento. Aqui se representa 
 * as duas margens do rio, mas uma implementação mais concisa necessita apenas
 * do numero de missionarios e canibais em cada margem e da posição do barco. 
 * Para maior clareza do código, vamos usar a represetação mais explícita e o 
 * aluno pode modificar para uma representaçao mais concisa. 
 * 
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public class EstadoMissCanib implements Estado{
    private int md=0; // quantidade de missionarios na margem direita
    private int me=0; // quantidade de missionarios na margem esquerda
    private int cd=0; // quantidade de missionarios na margem direita
    private int ce=0; // quantidade de missionarios na margem esquerda
    private char b='E';  // localização do barco (E esquerda, D direita)

    public EstadoMissCanib(int me, int ce, char b, int md, int cd){
        this.me = me;
        this.md = md;
        this.ce = ce;
        this.cd = cd;
        this.b = b;
    }

    
    /**
     * Testa se o estado atual é um estado válido no espaço de estados do problema
     * @return true se o estado é válido ou false caso contrário
     */
    @Override
    public boolean estadoValido() {
        // a soma total de missionarios ou canibais eh 3 e o barco está em uma 
        // localização correta
        boolean positivos = (this.md>=0 && this.me>=0 && this.ce>=0 && this.cd>=0);
        boolean total3 = ((this.md+this.me==3)&& (this.cd+this.ce==3)
                );
        boolean barcoCorreto = ((this.b=='D')||(this.b=='E'));
        // missionarios são mais numerosos que canibais em ambos os lados
        boolean semCanibalismo = 
                ((this.md==0) || (this.md>=this.cd )) && 
                ((this.me==0) || (this.me >=this.ce));
                
        return positivos && total3 && barcoCorreto && semCanibalismo;
    }

    @Override
    public boolean igual(Estado e) {
        
        return (
                (((EstadoMissCanib)e).getMd()==this.md) &&
                (((EstadoMissCanib)e).getMe()==this.me) &&
                (((EstadoMissCanib)e).getCe()==this.ce) &&
                (((EstadoMissCanib)e).getCd()==this.cd) &&
                (((EstadoMissCanib)e).getB()==this.b));
    }

    public int getMd() {
        return md;
    }

    public int getMe() {
        return me;
    }

    public int getCd() {
        return cd;
    }

    public int getCe() {
        return ce;
    }

    public char getB() {
        return b;
    }
    @Override
    public String toString(){
        return String.valueOf(this.me)+
                String.valueOf(this.ce)+
                this.b+
                String.valueOf(this.md)+
                String.valueOf(this.cd);
 
    }

    @Override
    public boolean equals(Object e) {
        return this.igual((EstadoMissCanib)e);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.md;
        hash = 97 * hash + this.me;
        hash = 97 * hash + this.cd;
        hash = 97 * hash + this.ce;
        hash = 97 * hash + this.b;
        return hash;
    }


}