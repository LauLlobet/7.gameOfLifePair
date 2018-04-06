package gameoflife;

import java.util.HashMap;

public class World extends HashMap<Coordinate,Cell> {

    Coordinate lowerLeftBound, higherRigthBound;

    World(Coordinate lowerLeft, Coordinate higherRight) {
        lowerLeftBound = lowerLeft;
        higherRigthBound = higherRight;
        for(int x = lowerLeft.x; x < higherRight.x; x++){
            for(int y = lowerLeft.y; y < higherRight.y; y++){
                this.put(new Coordinate(x,y),new Cell(false));
            }
        }
    }

    public Cell get(Coordinate coordinate) {
        Cell cell = super.get(coordinate);
        return cell != null ? cell : new Cell(false);
    }

    @Override
    public Cell put(Coordinate coordinate, Cell cell){
        if(coordinate.x < lowerLeftBound.x || coordinate.y < lowerLeftBound.y
                || coordinate.y > higherRigthBound.y || coordinate.x > higherRigthBound.x ){
            return null;
        }
        return super.put(coordinate,cell);
    }

    public int countAliveNeighboursAt(Coordinate coordinate) {
        int aliveNeighbours = 0;
        for(Direction direction : Direction.values()){
            Coordinate neighbourCoordinate = coordinate.increment(direction.getIncrement());
            Cell cell = get(neighbourCoordinate);
            if(cell.isAlive()) aliveNeighbours++;
        }
        return aliveNeighbours;
    }
}
