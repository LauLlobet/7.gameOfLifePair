package gameoflife;

import java.util.HashMap;

public class World extends HashMap<Coordinate,Cell> {

    public Cell get(Coordinate coordinate) {
        Cell cell = new Cell(false);
        Cell oldCell = putIfAbsent(coordinate, cell);
        return oldCell == null ? cell : oldCell;
    }

    public int countAliveNeighboursOfACell(Coordinate coordinate) {
        int neighbours = 0;
        for(Direction direcction : Direction.values()){
            Coordinate neighbourCoordinate = coordinate.increment(direcction.getDelta());
            Cell cell = get(neighbourCoordinate);
            if(cell.isAlive()) neighbours++;
        }
        return neighbours;
    }
}
