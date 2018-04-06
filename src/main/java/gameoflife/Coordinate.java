package gameoflife;

import java.util.Objects;

public class Coordinate {
    public final int x;
    public final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Coordinate increment(Coordinate delta){
        return new Coordinate(x+delta.x,y+delta.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

