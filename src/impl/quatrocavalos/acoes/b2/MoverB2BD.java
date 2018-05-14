/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impl.quatrocavalos.acoes.b2;

import impl.quatrocavalos.EstadoQuatroCavalos;
import impl.quatrocavalos.acoes.AcaoQuatroCavalos;
import interfaces.Estado;

/**
 *
 * @author Ely Franklin
 */
public class MoverB2BD extends AcaoQuatroCavalos{
     public MoverB2BD() {
        super("Mover B2 +2+1");
    }

    @Override
    public EstadoQuatroCavalos resultado(Estado e) {
        EstadoQuatroCavalos origem = (EstadoQuatroCavalos) e;
        EstadoQuatroCavalos novo;
        
        int posL = origem.getCavaloB2()[0];
        int posC = origem.getCavaloB2()[1];
        int[] pos = new int[] {posL+2, posC+1};
        
        novo = new EstadoQuatroCavalos( origem.getCavaloB1(), pos, origem.getCavaloP1(), origem.getCavaloP2());
        
        return novo;
    }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        return e.estadoValido();
    }

}
