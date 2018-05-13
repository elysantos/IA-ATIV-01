
import impl.quatrocavalos.EstadoQuatroCavalos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ely Franklin
 */
public class Main {
    public static void main(String[] args) {
        int[] pB1 = {0,0};
        int[] pB2 = {0,2};
        int[] pP1 = {2,0};
        int[] pP2 = {2,2};
        EstadoQuatroCavalos estado = new EstadoQuatroCavalos(pB1, pB2, pP1, pP2);
        System.out.println(estado.toString());
    }
}
