/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impl.quatrocavalos;

import interfaces.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ely Franklin
 */
public class EstadoQuatroCavalos implements Estado{
    private final int dimensao = 3;
    private int[] cavaloB1 = new int[2];
    private int[] cavaloB2 = new int[2];
    private int[] cavaloP1 = new int[2];
    private int[] cavaloP2 = new int[2];

    public EstadoQuatroCavalos(int[] posB1, int[] posB2, int[] posP1, int[] posP2){
        this.cavaloB1 = posB1;
        this.cavaloB2 = posB2;
        this.cavaloP1 = posP1;
        this.cavaloP2 = posP2;
    }
    @Override
    public boolean estadoValido() {
        if(posicaoIgual(this.cavaloB1, this.cavaloB2)){
            return false;
        }
        if(posicaoIgual(this.cavaloB1, this.cavaloP1)){
            return false;
        }
        if(posicaoIgual(this.cavaloB1, this.cavaloP2)){
            return false;
        }
        if(posicaoIgual(this.cavaloB2, this.cavaloP1)){
            return false;
        }
        if(posicaoIgual(this.cavaloB2, this.cavaloP2)){
            return false;
        }
        if(posicaoIgual(this.cavaloP1, this.cavaloP2)){
            return false;
        }
        return validaPosicao(this.getCavaloB1()) &&
         validaPosicao(this.getCavaloB2()) &&
         validaPosicao(this.getCavaloP1()) &&
         validaPosicao(this.getCavaloP2());
    }

    @Override
    public boolean igual(Estado e) {
        if (this == e) {
            return true;
        }
        if ((e == null) || (this.getClass() != e.getClass())) {
            return false;
        }
        EstadoQuatroCavalos estado = (EstadoQuatroCavalos) e;
        
        if(this.getCavaloB1() != estado.getCavaloB1()){
            return false;
        }
        if(this.getCavaloB2() != estado.getCavaloB2()){
            return false;
        }
        if(this.getCavaloP1() != estado.getCavaloP1()){
            return false;
        }
        return this.getCavaloP2() == estado.getCavaloP2();
    }

    public int[] getCavaloB1() {
        return cavaloB1;
    }

    public int[] getCavaloB2() {
        return cavaloB2;
    }

    public int[] getCavaloP1() {
        return cavaloP1;
    }

    public int[] getCavaloP2() {
        return cavaloP2;
    }
    
    /**
     *
     * @param posicao posicao de um cavalo para verificar validade
     * @return 
     */
    private boolean validaPosicao(int[] posicao){
        
        if(posicao[0] >= this.dimensao || posicao[0]<0){
            return false;
        }
        return !(posicao[1] >= this.dimensao || posicao[1]<0);
    }
    
    private boolean posicaoIgual(int[] a, int[] b){
        return a[0] == b[0] && a[1]==b[1];
    }
    
    @Override
    public String toString(){
        String str = "+----+----+----+\n";
        for(int i = 0; i < this.dimensao; i++){
            for(int j = 0; j < this.dimensao; j++){
                str += "| ";
                str += this.achaCorrespondente(i, j) + " ";
            }
            str += "|\n+----+----+----+\n";
        }
        return str;
    }
    private String achaCorrespondente(int x, int y){
        if(this.cavaloB1[0] == x && this.cavaloB1[1]==y){
            return "B1";
        }
        if(this.cavaloB2[0] == x && this.cavaloB2[1]==y){
            return "B2";
        }
        if(this.cavaloP1[0] == x && this.cavaloP1[1]==y){
            return "P1";
        }
        if(this.cavaloP2[0] == x && this.cavaloP2[1]==y){
            return "P2";
        }
        return "  ";
    }
    
    public List<EstadoQuatroCavalos> movimentaB1(){
        List<EstadoQuatroCavalos>  estados = new ArrayList<EstadoQuatroCavalos>();
        EstadoQuatroCavalos e;
        int posL = this.cavaloB1[0];
        int posC = this.cavaloB1[1];
        int[] pos = new int[] {posL+1, posC+2};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
       
        pos = new int[] {posL+2, posC+1};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-2, posC-1};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC-2};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL+2, posC-1};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL+1, posC-2};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL-2, posC+1};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC+2};
        e = new EstadoQuatroCavalos(pos, this.cavaloB2, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        return estados;
    }
    public List<EstadoQuatroCavalos> movimentaB2(){
        List<EstadoQuatroCavalos>  estados = new ArrayList<EstadoQuatroCavalos>();
        EstadoQuatroCavalos e;
        int posL = this.cavaloB2[0];
        int posC = this.cavaloB2[1];
        int[] pos = new int[] {posL+1, posC+2};
        e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
       
        pos = new int[] {posL+2, posC+1};
        e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-2, posC-1};
        e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC-2};
        e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL+2, posC-1};
       e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL+1, posC-2};
        e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL-2, posC+1};
        e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC+2};
        e = new EstadoQuatroCavalos(this.cavaloB1,pos, this.cavaloP1, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        return estados;
    }
    public List<EstadoQuatroCavalos> movimentaP1(){
        List<EstadoQuatroCavalos>  estados = new ArrayList<EstadoQuatroCavalos>();
        EstadoQuatroCavalos e;
        int posL = this.cavaloP1[0];
        int posC = this.cavaloP1[1];
        int[] pos = new int[] {posL+1, posC+2};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2,pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
       
        pos = new int[] {posL+2, posC+1};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2,pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-2, posC-1};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2, pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC-2};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2, pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL+2, posC-1};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2, pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL+1, posC-2};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2, pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL-2, posC+1};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2, pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC+2};
        e = new EstadoQuatroCavalos( this.cavaloB1, this.cavaloB2, pos, this.cavaloP2);
        if(e.estadoValido()){
            estados.add(e);
        }
        return estados;
    }
    public List<EstadoQuatroCavalos> movimentaP2(){
        List<EstadoQuatroCavalos>  estados = new ArrayList<EstadoQuatroCavalos>();
        EstadoQuatroCavalos e;
        int posL = this.cavaloP2[0];
        int posC = this.cavaloP2[1];
        int[] pos = new int[] {posL+1, posC+2};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
       
        pos = new int[] {posL+2, posC+1};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-2, posC-1};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC-2};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL+2, posC-1};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL+1, posC-2};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
        pos = new int[] {posL-2, posC+1};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
        
        pos = new int[] {posL-1, posC+2};
        e = new EstadoQuatroCavalos(this.cavaloB1, this.cavaloB2, this.cavaloP1, pos);
        if(e.estadoValido()){
            estados.add(e);
        }
        return estados;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 1 * hash + this.cavaloB1[0];
        hash = 3 * hash + this.cavaloB1[1];
        hash = 7 * hash + this.cavaloB2[0];
        hash = 11 * hash + this.cavaloB2[1];
        hash = 13 * hash + this.cavaloP1[0];
        hash = 17 * hash + this.cavaloP1[1];
        hash = 19 * hash + this.cavaloP2[0];
        hash = 23 * hash + this.cavaloP2[1];
        return hash;
    }
}
