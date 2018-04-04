package gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WorldShould {
    @Test
    public void start_with_all_cells_dead(){
        World world = new World();

        Cell cell = world.getCell(1,1);

        assertThat(cell.isAlive(),is(false));
    }

    @Test
    public void store_cells_at_postion(){
        World world = new World();

        Cell cell = new Cell(false);
        world.putCell(1,1,cell);
        Cell recoveredCell = world.getCell(1,1);


        assertEquals(cell,recoveredCell);
    }
}
