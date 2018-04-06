package gameoflife;

public class Cell {
    private final  boolean alive; // wrappable primitive

    Cell(boolean alive) {
        this.alive = alive;
    }

    public Cell nextStep(int aliveNeighbours) {
        if(aliveNeighbours == 3){
            return new Cell(true);
        }
        if(aliveNeighbours < 2 || aliveNeighbours > 3){
            return new Cell(false);
        }
        return this;
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
