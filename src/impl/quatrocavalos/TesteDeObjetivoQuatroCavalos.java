package impl.quatrocavalos;

import interfaces.Estado;
import interfaces.TesteDeObjetivo;

/**
 *
 * @author Ely Franklin
 */
public class TesteDeObjetivoQuatroCavalos implements TesteDeObjetivo{
    private EstadoQuatroCavalos objetivo;

    public TesteDeObjetivoQuatroCavalos() {
        this.objetivo = new EstadoQuatroCavalos(new int[]{2,2}, new int[]{2,0}, new int[]{0,2}, new int[]{0,0});
    }
    
    public TesteDeObjetivoQuatroCavalos(EstadoQuatroCavalos inicial){
        
        int[] posB1, posB2, posP1, posP2;
        
        this.objetivo = new EstadoQuatroCavalos(new int[]{2,2}, new int[]{2,0}, new int[]{0,2}, new int[]{0,0});
        
        if(inicial.estadoValido()){
            posB1 = inicial.getCavaloB1();
            posB2 = inicial.getCavaloB2();
            posP1 = inicial.getCavaloP1();
            posP2 = inicial.getCavaloP2();
            
            this.objetivo = new EstadoQuatroCavalos(posB1, posB2, posP1, posP2);
        }
    }

    @Override
    public boolean ehObjetivo(Estado e) {
        return ((EstadoQuatroCavalos) e).igual(this.objetivo);
    }
}
