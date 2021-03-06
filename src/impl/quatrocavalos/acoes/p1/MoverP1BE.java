package impl.quatrocavalos.acoes.p1;

import impl.quatrocavalos.EstadoQuatroCavalos;
import impl.quatrocavalos.acoes.AcaoQuatroCavalos;
import interfaces.Estado;

/**
 *
 * @author Ely Franklin
 */
public class MoverP1BE extends AcaoQuatroCavalos {

    public MoverP1BE() {
        super("Mover P1 +2-1");
    }

    @Override
    public EstadoQuatroCavalos resultado(Estado e) {
        EstadoQuatroCavalos origem = (EstadoQuatroCavalos) e;
        EstadoQuatroCavalos novo;
        
        int posL = origem.getCavaloP1()[0];
        int posC = origem.getCavaloP1()[1];
        int[] pos = new int[] {posL+2, posC-1};
        
        novo = new EstadoQuatroCavalos(origem.getCavaloB1(), origem.getCavaloB2(), pos, origem.getCavaloP2());
        
        return novo;
    }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        return e.estadoValido();
    }

}
