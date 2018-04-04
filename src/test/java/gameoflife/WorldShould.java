package gameoflife;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WorldShould {
    @Test
    public void start_with_all_cells_dead() {
        World world = new World();

        Cell cell = world.getCell(new Coordinate(1, 1));

        assertThat(cell.isAlive(), is(false));
    }

    @Test
    public void store_cells_at_postion() {
        World world = new World();

        Cell cell = new Cell(false);
        world.putCell(new Coordinate(1, 1), cell);
        Cell recoveredCell = world.getCell(new Coordinate(1, 1));


        assertEquals(cell, recoveredCell);
    }

    @Test
    public void count_neigbours_at_position_in_board(){
        World world = new World();
        Cell alive = new Cell(true);


        world.putCell(new Coordinate(0,0), alive);
        world.putCell(new Coordinate(1,0), alive);
        world.putCell(new Coordinate(2,0), alive);

        world.putCell(new Coordinate(0,1), alive);
        world.putCell(new Coordinate(2,1), alive);

        world.putCell(new Coordinate(0,2), alive);
        world.putCell(new Coordinate(1,2), alive);
        world.putCell(new Coordinate(2,2), alive);

        int neighbours = world.countNeighbours(new Coordinate(1,1));


        assertThat(neighbours,is(8));
    }

}
