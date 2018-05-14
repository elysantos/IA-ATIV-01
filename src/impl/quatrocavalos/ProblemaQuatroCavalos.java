/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impl.quatrocavalos;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.Problema;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ely Franklin
 */
public class ProblemaQuatroCavalos implements Problema{
    
    private final FuncaoSucessorQuatroCavalos fs;
    private final EstadoQuatroCavalos inicio;
    private TesteDeObjetivoQuatroCavalos testeObjetivo;
    
    public ProblemaQuatroCavalos(){
        this.fs = new FuncaoSucessorQuatroCavalos();
        this.inicio = new EstadoQuatroCavalos(new int[]{0,0}, new int[]{0,2}, new int[]{2,0}, new int[]{2,2});
        this.testeObjetivo = new TesteDeObjetivoQuatroCavalos();
    }
    
    public ProblemaQuatroCavalos(EstadoQuatroCavalos ini){
        this.fs = new FuncaoSucessorQuatroCavalos();
        this.testeObjetivo = new TesteDeObjetivoQuatroCavalos();
        if (ini.estadoValido()){
            this.inicio = ini;   
        }else{
            this.inicio = new EstadoQuatroCavalos(new int[]{0,0}, new int[]{0,2}, new int[]{2,0}, new int[]{2,2});
        }
    }
    
    public ProblemaQuatroCavalos(EstadoQuatroCavalos ini, boolean objetivoDefault){
        this.fs = new FuncaoSucessorQuatroCavalos();
        this.testeObjetivo = new TesteDeObjetivoQuatroCavalos();
        if (ini.estadoValido()){
            this.inicio = ini;   
        }else{
            this.inicio = new EstadoQuatroCavalos(new int[]{0,0}, new int[]{0,2}, new int[]{2,0}, new int[]{2,2});
        }
        
        if (objetivoDefault){//ir até o objetivo defalt
            this.testeObjetivo = new TesteDeObjetivoQuatroCavalos();
        }else{// ir até o inverso do estado inicial
            this.testeObjetivo = new TesteDeObjetivoQuatroCavalos(ini);
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
    public Set<Map.Entry<Acao, Estado>> sucessores(Estado e) {
        return this.fs.sucessores(e);
    }

    @Override
    public boolean testaObjetivo(Estado e) {
        return this.testeObjetivo.ehObjetivo(e);
    }

    @Override
    public double custo(Acao a, Estado ei) {
        return a.custo(ei);
    }

    @Override
    public Estado estadoInicial() {
        return this.inicio;
    }

}
