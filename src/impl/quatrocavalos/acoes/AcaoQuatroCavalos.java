package impl.quatrocavalos.acoes;

import impl.quatrocavalos.EstadoQuatroCavalos;
import interfaces.Acao;
import interfaces.Estado;
import java.util.ArrayList;

/**
 *
 * @author Ely Franklin
 */
public abstract class AcaoQuatroCavalos implements Acao{
    private String id = "NoOp";
    
    public AcaoQuatroCavalos(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return id;
    }

    @Override
    public abstract ArrayList<EstadoQuatroCavalos> resultado(Estado e);
    
    @Override
    public double custo(Estado e) {
        return 1.0;
    }

    public boolean equals(AcaoQuatroCavalos a){
        return this.id.equalsIgnoreCase(a.getId());
    }
}
