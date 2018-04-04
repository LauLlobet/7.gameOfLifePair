package gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CellShould {
    @Test
    public void die_of_underpopulation(){
        Cell cell = new Cell();
        cell.setAlive();
        cell.nextState(1);
        assertThat(cell.isAlive(),is(false));
    }
}
