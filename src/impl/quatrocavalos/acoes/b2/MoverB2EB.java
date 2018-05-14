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
public class MoverB2EB extends AcaoQuatroCavalos {
 public MoverB2EB() {
        super("Mover B2 +1-2");
    }

    @Override
    public EstadoQuatroCavalos resultado(Estado e) {
        EstadoQuatroCavalos origem = (EstadoQuatroCavalos) e;
        EstadoQuatroCavalos novo;
        
        int posL = origem.getCavaloB2()[0];
        int posC = origem.getCavaloB2()[1];
        int[] pos = new int[] {posL+1, posC-2};
        
         novo = new EstadoQuatroCavalos( origem.getCavaloB1(), pos, origem.getCavaloP1(), origem.getCavaloP2());
        
        return novo;
    }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        return e.estadoValido();
    }
}
