package gameoflife;

enum Direction {
    TOP(0,1),BOTTOM(0,-1),LEFT(1,0),RIGHT(-1,0),TOPLEFT(1,1),TOPRIGHT(-1,1),BOTTOMLEFT(-1,1),BOTTOMRIGHT(-1,-1);

    public Coordinate getDelta() {
        return delta;
    }

    private final Coordinate delta;

    Direction(int dx, int dy){
        this.delta = new Coordinate(dx,dy);
    }
}
