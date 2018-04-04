package gameoflife;

public class Cell {
    private boolean alive;

    public Cell(boolean alive) {

    }

    public void nextState(int neighbours) {
        if(neighbours == 3){
            alive = true;
        }
    }

    public boolean isAlive() {
        return alive;
    }
}
