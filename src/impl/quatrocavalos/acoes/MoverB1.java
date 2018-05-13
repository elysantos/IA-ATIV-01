package impl.quatrocavalos.acoes;

import impl.quatrocavalos.EstadoQuatroCavalos;
import interfaces.Estado;
import java.util.ArrayList;

/**
 *
 * @author Ely Franklin
 */
public class MoverB1 extends AcaoQuatroCavalos{

    public MoverB1(){
         super("Mover B1");
    }
    
    @Override
    public ArrayList<EstadoQuatroCavalos> resultado(Estado e) {
        ArrayList<EstadoQuatroCavalos>  estados = new ArrayList<EstadoQuatroCavalos>();
        EstadoQuatroCavalos origem = (EstadoQuatroCavalos) e;
        EstadoQuatroCavalos novo;
        int posL = origem.getCavaloB1()[0];
        int posC = origem.getCavaloB1()[1];
        
        int[] pos = new int[] {posL+1, posC+2};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }
       
        pos = new int[] {posL+2, posC+1};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }

        pos = new int[] {posL-2, posC-1};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }

        pos = new int[] {posL-1, posC-2};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }

        pos = new int[] {posL+2, posC-1};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }

        pos = new int[] {posL+1, posC-2};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }

        pos = new int[] {posL-2, posC+1};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }

        pos = new int[] {posL-1, posC+2};
        novo = new EstadoQuatroCavalos(pos, origem.getCavaloB2(), origem.getCavaloP1(), origem.getCavaloP2());
        if(novo.estadoValido()){
            estados.add(novo);
        }

        return estados;
    }

    @Override
    public boolean preCondicoesSatisfeitas(Estado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
