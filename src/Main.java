
import busca.informada.BuscaAStar;
import busca.naoinformada.BuscaEmLargura;
import busca.naoinformada.BuscaEmProfundidade;
import impl.quatrocavalos.EstadoQuatroCavalos;
import impl.quatrocavalos.ProblemaQuatroCavalos;
import impl.quatrocavalos.TesteDeObjetivoQuatroCavalos;
import interfaces.Acao;
import interfaces.Estado;
import interfaces.FuncaoHeuristica;
import interfaces.Problema;
import interfaces.TesteDeObjetivo;
import java.util.List;

/**
 *
 * @author Ely Franklin
 */
public class Main {

    public static void main(String[] args) {
        Problema p = new ProblemaQuatroCavalos();
        Estado e = p.estadoInicial();
        EstadoQuatroCavalos eQ =  (EstadoQuatroCavalos)e;
        
        TesteDeObjetivoQuatroCavalos teste =  new TesteDeObjetivoQuatroCavalos();
        
        System.out.println(teste.ehObjetivo(eQ));
        
//        
//        
        BuscaEmProfundidade b1 = new BuscaEmProfundidade();
        BuscaEmLargura b2 = new BuscaEmLargura();
        
        long t0 = System.currentTimeMillis();
        List<Acao> result1 = b2.buscar_v2_0(p);
        long t1 = System.currentTimeMillis();


        System.out.println(teste.ehObjetivo(e));
        //System.out.println(result1.size());
        for (int i = 0; i < result1.size(); i++) {
            System.out.println("[Passo " + i + "]" + result1.get(i));
            Acao a = result1.get(i);
            e = (EstadoQuatroCavalos) a.resultado(e);
            System.out.println(e);
        }

    }
}
