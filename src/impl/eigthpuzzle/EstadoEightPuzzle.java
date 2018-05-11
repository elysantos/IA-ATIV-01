/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.eigthpuzzle;

import estruturas.XYLocation;
import interfaces.Estado;
import java.util.Arrays;

/**
 *
 * @author jcsilva
 */
public class EstadoEightPuzzle implements Estado {

    private final int pecas[];

    public EstadoEightPuzzle(int pecas[]) {
        this.pecas = pecas;
    }

    @Override
    public boolean estadoValido() {
        return this.getPecas().length == 9;
    }

    @Override
    public boolean igual(Estado e) {
        if (this == e) {
            return true;
        }
        if ((e == null) || (this.getClass() != e.getClass())) {
            return false;
        }
        EstadoEightPuzzle estado = (EstadoEightPuzzle) e;

        for (int i = 0; i < 8; i++) {
            if ((this.getPecas()[i]) != estado.getPecas()[i]) {
                return false;
            }
        }
        return true;

    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean equals(Object e){
        return this.igual((EstadoEightPuzzle)e);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Arrays.hashCode(this.pecas);
        return hash;
    }
    /**
     * @return the pecas
     */
    public int[] getPecas() {
        return pecas;
    }

    @Override
    public String toString() {
        String retVal = pecas[0] + " " + pecas[1] + " " + pecas[2] + "\n"
                + pecas[3] + " " + pecas[4] + " " + pecas[5] + " " + "\n"
                + pecas[6] + " " + pecas[7] + " " + pecas[8];
        return retVal;
    }

    public EstadoEightPuzzle moveGapParaDireita() {
        int p[] = new int[this.pecas.length];
        System.arraycopy(this.pecas, 0, p, 0, this.pecas.length);
        if (p == null) {
            return this; // guarda contra null assignment
        }
        int gapPos = getGapPosition();
        int x = getXCoord(gapPos);
        int ypos = getYCoord(gapPos);
        if (!(ypos == 2)) {
            int valueOnRight = getValueAt(x, ypos + 1);
            setValue(p, x, ypos, valueOnRight);
            setValue(p, x, ypos + 1, 0);
            return new EstadoEightPuzzle(p);
        }
        return this;
    }

    public EstadoEightPuzzle moveGapPraEsquerda() {
        int p[] = new int[this.pecas.length];
        System.arraycopy(this.pecas, 0, p, 0, this.pecas.length);
        if (p == null) {
            return this; // guarda contra null assignment
        }
        int gapPos = getGapPosition();
        int x = getXCoord(gapPos);
        int ypos = getYCoord(gapPos);
        if (!(ypos == 0)) {
            int valueOnLeft = getValueAt(x, ypos - 1);
            setValue(p, x, ypos, valueOnLeft);
            setValue(p, x, ypos - 1, 0);
            return new EstadoEightPuzzle(p);
        }
        return this;
    }

    public EstadoEightPuzzle moveGapPraBaixo() {
        int p[] = new int[this.pecas.length];
        System.arraycopy(this.pecas, 0, p, 0, this.pecas.length);
        if (p == null) {
            return this; // guarda contra null assignment
        }
        int gapPos = getGapPosition();
        int x = getXCoord(gapPos);
        int y = getYCoord(gapPos);
        if (!(x == 2)) {
            int valueOnBottom = getValueAt(x + 1, y);
            setValue(p, x, y, valueOnBottom);
            setValue(p, x + 1, y, 0);
             return new EstadoEightPuzzle(p);
        }
        return this;
    }

    public EstadoEightPuzzle moveGapPraCima() {
        int p[] = new int[this.pecas.length];
        System.arraycopy(this.pecas, 0, p, 0, this.pecas.length);
        //Pre condicao: Não estamos na borda superior
        //A borda superior não contem o GAP (zero)
        //caso a pre-condição não seja satisfeita não faz nada   
        if (p == null) {
            return this; // guarda contra null assignment
        }
        // Troca a posicao atual do GAP com a peça superior a ele. 
        int gapPos = getGapPosition();
        int x = getXCoord(gapPos);
        int y = getYCoord(gapPos);
        if (!(x == 0)) {
            int valueOnTop = getValueAt(x - 1, y);
            setValue(p, x, y, valueOnTop); //set TOP 
            setValue(p, x - 1, y, 0);//set GAP
            return new EstadoEightPuzzle(p);
        }
        return this;
    }

    //
    // PRIVATE METHODS: copiados da implementação do AIMA
    //
    /**
     * Note: The graphic representation maps x values on row numbers (x-axis in
     * vertical direction).
     */
    public int getXCoord(int absPos) {
        return absPos / 3;
    }

    /**
     * Note: The graphic representation maps y values on column numbers (y-axis
     * in horizontal direction).
     */
    private int getYCoord(int absPos) {
        return absPos % 3;
    }

    private int getAbsPosition(int x, int y) {
        return x * 3 + y;
    }

    private int getValueAt(int x, int y) {
        // refactor this use either case or a div/mod soln
        return this.pecas[getAbsPosition(x, y)];
    }

    private int getGapPosition() {
        return getPositionOf(0);
    }

    private int getPositionOf(int val) {
        int retVal = -1;
        for (int i = 0; i < 9; i++) {
            if (pecas[i] == val) {
                retVal = i;
            }
        }
        return retVal;
    }

    private void setValue(int[] p, int x, int y, int val) {
        int absPos = getAbsPosition(x, y);
        p[absPos] = val;
    }
	public int getValueAt(XYLocation loc) {
		return getValueAt(loc.getXCoOrdinate(), loc.getYCoOrdinate());
	}

	public XYLocation getLocationOf(int val) {
		int absPos = getPositionOf(val);
		return new XYLocation(getXCoord(absPos), getYCoord(absPos));
	}

}
