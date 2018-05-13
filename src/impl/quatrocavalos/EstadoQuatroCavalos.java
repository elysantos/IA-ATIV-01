/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impl.quatrocavalos;

import interfaces.Estado;

/**
 *
 * @author Ely Franklin
 */
public class EstadoQuatroCavalos implements Estado{
    private int[][] tabuleiro = new int[3][3];
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean igual(Estado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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


    
}
