package gameoflife;

import java.util.HashMap;

public class World extends HashMap<Coordinate,Cell> {

    private Cell cell = new Cell(false);
    private int[] directionsX = {-1,-1,-1,0,0,1,1,1};
    private int[] directionsY = {-1,0,-1,-1,1,-1,0,1};

    public Cell get(Coordinate coordinate) {
        if(this.containsKey(coordinate)) {
            return super.get(coordinate);
        }
        put(coordinate, new Cell(false));
        return super.get(coordinate);
    }

    public int countNeighbours(Coordinate coordinate) {
        int neighbours = 0;
        for(int i=0; i< 8; i++){
            Cell cell = get(new Coordinate(coordinate.x+directionsX[i], coordinate.y+directionsY[i]));
            if(cell.isAlive()) neighbours++;
        }
        return neighbours;
    }
}
