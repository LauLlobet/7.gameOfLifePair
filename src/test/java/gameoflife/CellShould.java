package gameoflife;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CellShould {
    @Test
    public void an_alive_cell_dies_of_underpopulation() {
        Cell cell = new Cell(true);

        cell.nextState(1);

        assertThat(cell.isAlive(), is(false));
    }
    @Test
    public void a_dead_cell_is_reborn_when_has_three_neigbours(){
        Cell cell = new Cell(false);

        cell.nextState(3);

        assertThat(cell.isAlive(),is(true));
    }
}
