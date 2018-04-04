package gameoflife;

import java.util.HashMap;

public class World {
    HashMap<Coordinate,Cell> hashMap = new HashMap<Coordinate, Cell>();

    private Cell cell = new Cell(false);

    public Cell getCell(Coordinate coordinate) {
        if(hashMap.containsKey(coordinate)) {
            return hashMap.get(coordinate);
        }
        putCell(coordinate, new Cell(false));
        return getCell(coordinate);
    }

    public void putCell(Coordinate coordinate, Cell cell) {
        hashMap.put(coordinate,cell);
    }

    public int countNeighbours(Coordinate coordinate) {
        int neighbours = 6;
        return neighbours;
    }
}
