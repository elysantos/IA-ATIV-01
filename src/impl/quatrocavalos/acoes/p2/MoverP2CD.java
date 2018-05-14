/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impl.quatrocavalos.acoes.p2;

import impl.quatrocavalos.EstadoQuatroCavalos;
import impl.quatrocavalos.acoes.AcaoQuatroCavalos;
import interfaces.Estado;

/**
 *
 * @author Ely Franklin
 */
public class MoverP2CD extends AcaoQuatroCavalos{
    public MoverP2CD() {
        super("Mover P2 -2+1");
    }

    @Override
    public EstadoQuatroCavalos resultado(Estado e) {
        EstadoQuatroCavalos origem = (EstadoQuatroCavalos) e;
        EstadoQuatroCavalos novo;
        
        int posL = origem.getCavaloP2()[0];
        int posC = origem.getCavaloP2()[1];
        int[] pos = new int[] {posL-2, posC+1};
        
         novo = new EstadoQuatroCavalos( origem.getCavaloB1(), origem.getCavaloB2(), origem.getCavaloP1(), pos);
        
        return novo;
    }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        return e.estadoValido();
    }
}
