package gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CellShould {
    private Cell initiallyAliveCell;
    private Cell initiallyDeadCell;

    @Before
    public void before(){
        initiallyAliveCell = new Cell(true);
        initiallyDeadCell = new Cell(false);
    }
    @Test
    public void an_alive_cell_dies_of_underpopulation() {
        initiallyAliveCell.nextStep(1);

        assertThat(initiallyAliveCell.isAlive(), is(false));
    }

    @Test
    public void a_dead_cell_is_reborn_when_has_three_neigbours(){
        initiallyDeadCell.nextStep(3);

        assertThat(initiallyDeadCell.isAlive(),is(true));
    }

    @Test
    public void an_alive_cell_is_keept_alive_if_has_normal_population(){
        initiallyAliveCell.nextStep(2);

        assertThat(initiallyAliveCell.isAlive(),is(true));

        initiallyAliveCell.nextStep(3);

        assertThat(initiallyAliveCell.isAlive(),is(true));
    }

    @Test
    public void a_alive_cell_should_die_for_overpopulation(){
        initiallyAliveCell.nextStep(4);

        assertThat(initiallyAliveCell.isAlive(),is(false));
    }



    @Test
    public void a_dead_cell_should_remain_dead_if_has_not_three_neigbours(){
        initiallyDeadCell.nextStep(2);

        assertThat(initiallyDeadCell.isAlive(),is(false));
    }
}
