package gameoflife;

public class Cell {
    private boolean alive = true;

    public void setAlive() {

    }

    public void nextState(int neigbours) {
        if(neigbours == 2){
            alive = true;
            return;
        }
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }
}
