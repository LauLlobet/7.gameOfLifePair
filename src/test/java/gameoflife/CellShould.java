package gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

    @Test
    public void an_alive_cell_is_keept_alive_if_has_normal_population(){
        Cell cell = new Cell(true);

        cell.nextState(2);

        assertThat(cell.isAlive(),is(true));

       cell.nextState(3);

       assertThat(cell.isAlive(),is(true));
    }

    @Test
    public void a_alive_cell_should_die_for_overpopulation(){
        Cell cell = new Cell(true);

        cell.nextState(4);

        assertThat(cell.isAlive(),is(false));
    }



    @Test
    public void a_dead_cell_should_remain_dead_if_has_not_three_neigbours(){
        Cell cell = new Cell(false);

        cell.nextState(2);

        assertThat(cell.isAlive(),is(false));
    }
}
