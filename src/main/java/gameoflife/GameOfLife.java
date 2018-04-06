package gameoflife;

import java.util.Map;

public class GameOfLife {
    private World world;

    GameOfLife(World world) {
        this.world = world;
    }

    public void nextStep() {
        World nextWorld = new World(world.lowerLeftBound, world.higherRigthBound);

        for (Map.Entry<Coordinate,Cell> currentWorldEntry: world.entrySet()) {
            Coordinate currentCoordinate = currentWorldEntry.getKey();
            Cell currentCell = currentWorldEntry.getValue();
            int aliveNeighboursOfCurrentCell = world.countAliveNeighboursAt(currentCoordinate); //feature envy?

            Cell nextCell = currentCell.nextStep(aliveNeighboursOfCurrentCell);

            nextWorld.put(currentCoordinate,nextCell);
        }
        world.clear();
        world.putAll(nextWorld);
    }
}
