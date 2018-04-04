package gameoflife;

public class Cell {
    private boolean alive;

    Cell(boolean alive) {
        this.alive = alive;
    }

    public void nextState(int neighbours) {
        if(neighbours == 3){
            alive = true;
        }
        if(neighbours < 2 || neighbours > 3){
            alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }
}
