/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impl.quatrocavalos.acoes.b1;

import impl.quatrocavalos.EstadoQuatroCavalos;
import impl.quatrocavalos.acoes.AcaoQuatroCavalos;
import interfaces.Estado;

/**
 *
 * @author Ely Franklin
 */
public class MoverB1DC extends AcaoQuatroCavalos{
 public MoverB1DC() {
        super("Mover B1 -1+2");
    }

    @Override
    public EstadoQuatroCavalos resultado(Estado e) {
        EstadoQuatroCavalos origem = (EstadoQuatroCavalos) e;
        EstadoQuatroCavalos novo;
        
        int posL = origem.getCavaloB1()[0];
        int posC = origem.getCavaloB1()[1];
        int[] pos = new int[] {posL-1, posC+2};
        
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        
        return novo;
    }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        return e.estadoValido();
    }
}
