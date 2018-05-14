
package impl.quatrocavalos;

import impl.quatrocavalos.acoes.AcaoQuatroCavalos;
import impl.quatrocavalos.acoes.b1.*;
import impl.quatrocavalos.acoes.b2.*;
import impl.quatrocavalos.acoes.p1.*;
import impl.quatrocavalos.acoes.p2.*;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.FuncaoSucessor;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ely Franklin
 */
public class FuncaoSucessorQuatroCavalos implements FuncaoSucessor {

    private final List<AcaoQuatroCavalos> acoes;
    
    public FuncaoSucessorQuatroCavalos(){
        this.acoes = new ArrayList<>();
        
        this.acoes.add(new MoverB1BD());
        this.acoes.add(new MoverB1BE());
        this.acoes.add(new MoverB1CD());
        this.acoes.add(new MoverB1CE());
        this.acoes.add(new MoverB1DB());
        this.acoes.add(new MoverB1DC());
        this.acoes.add(new MoverB1EB());
        this.acoes.add(new MoverB1EC());
       
        this.acoes.add(new MoverB2BD());
        this.acoes.add(new MoverB2BE());
        this.acoes.add(new MoverB2CD());
        this.acoes.add(new MoverB2CE());
        this.acoes.add(new MoverB2DB());
        this.acoes.add(new MoverB2DC());
        this.acoes.add(new MoverB2EB());
        this.acoes.add(new MoverB2EC());
        
        this.acoes.add(new MoverP1BD());
        this.acoes.add(new MoverP1BE());
        this.acoes.add(new MoverP1CD());
        this.acoes.add(new MoverP1CE());
        this.acoes.add(new MoverP1DB());
        this.acoes.add(new MoverP1DC());
        this.acoes.add(new MoverP1EB());
        this.acoes.add(new MoverP1EC());
       
        this.acoes.add(new MoverP2BD());
        this.acoes.add(new MoverP2BE());
        this.acoes.add(new MoverP2CD());
        this.acoes.add(new MoverP2CE());
        this.acoes.add(new MoverP2DB());
        this.acoes.add(new MoverP2DC());
        this.acoes.add(new MoverP2EB());
        this.acoes.add(new MoverP2EC());
        
    }
    
    @Override
    public Set<Acao> acoes(Estado e) {
        Set<Acao> acoesValidas = new  HashSet<>();
        for(Acao a: this.acoes){
            if (a.resultado(e).estadoValido()) //TODO if a.preCondicoesSatisfeitas()
            {
                acoesValidas.add(a);
            }
        }
        return acoesValidas;
    }

    @Override
    public double custo(Acao a, Estado e) {
        return a.custo(e);
    }

    @Override
    public Set<Map.Entry<Acao, Estado>> sucessores(Estado e) {
        Set<Map.Entry<Acao, Estado>> set = new HashSet<>();
        Map.Entry<Acao, Estado> tupla = null;

        for (Acao a : this.acoes) {
            Estado result = a.resultado(e);
            if (result.estadoValido()) { //TODO if a.preCondicoesSatisfeitas()
                tupla = new AbstractMap.SimpleEntry(a, result);
                set.add(tupla);
            }
        }

        return set;
    }

}
