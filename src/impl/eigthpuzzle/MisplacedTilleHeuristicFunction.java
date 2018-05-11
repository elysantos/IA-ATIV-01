package impl.eigthpuzzle;

import estruturas.XYLocation;
import interfaces.FuncaoHeuristica;

/**
 * @author Ravi Mohan
 *
 */
public class MisplacedTilleHeuristicFunction implements FuncaoHeuristica {

    @Override
    public double h(Object estado) {
        EstadoEightPuzzle e = (EstadoEightPuzzle) estado;
        return getNumberOfMisplacedTiles(e);
    }

    private int getNumberOfMisplacedTiles(EstadoEightPuzzle e) {
        int numberOfMisplacedTiles = 0;
        if (!(e.getLocationOf(0).equals(new XYLocation(0, 0)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(1).equals(new XYLocation(0, 1)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(2).equals(new XYLocation(0, 2)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(3).equals(new XYLocation(1, 0)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(4).equals(new XYLocation(1, 1)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(5).equals(new XYLocation(1, 2)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(6).equals(new XYLocation(2, 0)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(7).equals(new XYLocation(2, 1)))) {
            numberOfMisplacedTiles++;
        }
        if (!(e.getLocationOf(8).equals(new XYLocation(2, 2)))) {
            numberOfMisplacedTiles++;
        }
        // Subtract the gap position from the # of misplaced tiles
        // as its not actually a tile (see issue 73).
        if (numberOfMisplacedTiles > 0) {
            numberOfMisplacedTiles--;
        }
        return numberOfMisplacedTiles;
    }
}
