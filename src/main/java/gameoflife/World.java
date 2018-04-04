package gameoflife;

import java.util.HashMap;

public class World {
    HashMap<Coordinate,Cell> hashMap = new HashMap<Coordinate, Cell>();

    private Cell cell = new Cell(false);
    private int[] directionsX = {-1,-1,-1,0,0,1,1,1};
    private int[] directionsY = {-1,0,-1,-1,1,-1,0,1};

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
        int neighbours = 0;
        for(int i=0; i< 8; i++){
            neighbours += oneIfAliveAtCoordinateWithIncElseZero(coordinate,directionsX[i],directionsY[i]);
        }
        return neighbours;
    }

    private int oneIfAliveAtCoordinateWithIncElseZero(Coordinate coordinate, int incX, int incY) {
        Cell cell = getCell(new Coordinate(coordinate.x+incX, coordinate.y+incY));
        if(cell.isAlive()) return 1;
        else return 0;
    }
}
