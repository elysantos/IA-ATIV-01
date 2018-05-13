/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package exemplo.impl.misscanib.acoes;

import interfaces.Acao;
import interfaces.Estado;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public abstract class AcaoMissCanib implements Acao{
    private String id = "NoOp";
    
    public AcaoMissCanib(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }
    @Override
    public String toString(){
        return id;
    }

    @Override
    public abstract Estado resultado(Estado e);
    
    @Override
    public double custo(Estado e) {
        return 1.0;
    }

    public boolean equals(AcaoMissCanib a){
        return this.id.equalsIgnoreCase(a.getId());
    }
}

