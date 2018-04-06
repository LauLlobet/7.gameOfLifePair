package gameoflife;

enum Direction {
    TOP(0,1),BOTTOM(0,-1),LEFT(1,0),RIGHT(-1,0),TOPLEFT(1,1),TOPRIGHT(-1,1),BOTTOMLEFT(-1,1),BOTTOMRIGHT(-1,-1);

    public Coordinate getIncrement() {
        return increment;
    }

    private final Coordinate increment;

    Direction(int incrementX, int incrementY){
        this.increment = new Coordinate(incrementX,incrementY);
    }
}
