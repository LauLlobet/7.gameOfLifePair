package gameoflife;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WorldShould {

    private World world;
    private int randomY;
    private int randomX;

    @Before
    public void prepare() {
        world =  new World();
        randomX = getRandomInt();
        randomY = getRandomInt();
    }

    private int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(-99999, 999999 + 1);
    }

    @Test
    public void start_with_any_cell_dead() {
        Cell cell = world.get(new Coordinate(randomX, randomY));

        assertThat(cell.isAlive(), is(false));
    }

    @Test
    public void store_cells_at_any_position() {
        Cell cell = new Cell(false);

        world.put(new Coordinate(randomX, randomY), cell);
        Cell recoveredCell = world.get(new Coordinate(randomX, randomY));

        assertEquals(cell, recoveredCell);
    }

    @Test
    public void count_neighbours_at_position_in_board(){
        Cell alive = new Cell(true);


        world.put(new Coordinate(0,0), alive);
        world.put(new Coordinate(1,0), alive);
        world.put(new Coordinate(2,0), alive);

        world.put(new Coordinate(0,1), alive);
        world.put(new Coordinate(2,1), alive);

        world.put(new Coordinate(0,2), alive);
        world.put(new Coordinate(1,2), alive);
        world.put(new Coordinate(2,2), alive);

        int neighbours = world.countAliveNeighboursOfACell(new Coordinate(1,1));


        assertThat(neighbours,is(8));
    }

}
