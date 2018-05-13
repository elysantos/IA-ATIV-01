
import impl.quatrocavalos.EstadoQuatroCavalos;
import java.util.ArrayList;
import java.util.Iterator;

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
        EstadoQuatroCavalos e;
        ArrayList<EstadoQuatroCavalos> lista = (ArrayList<EstadoQuatroCavalos>) estado.movimentaB1();
        ArrayList<EstadoQuatroCavalos> lista2;
        Iterator<EstadoQuatroCavalos> it = lista.iterator();
        Iterator<EstadoQuatroCavalos> it2;
        while(it.hasNext()){
            e = it.next();
            System.out.println(e.toString());
            lista2 = (ArrayList<EstadoQuatroCavalos>) e.movimentaP2();
            it2 = lista2.iterator();
            while(it2.hasNext()){
                System.out.println(it2.next().toString());
            }
            System.out.println("-------------");
            System.out.println("-------------");
        }
    }
}
