package gameoflife;

import java.util.Objects;

public class Cell {
    private boolean alive;

    Cell(boolean alive) {
        this.alive = alive;
    }

    public void nextStep(int aliveNeighbours) {
        if(aliveNeighbours == 3){
            alive = true;
        }
        if(aliveNeighbours < 2 || aliveNeighbours > 3){
            alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return alive == cell.alive;
    }
}
