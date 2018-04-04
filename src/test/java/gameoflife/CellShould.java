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
    @Parameters({ "0",
                    "1"})
    public void die_of_underpopulation(int neighbours){
        Cell cell = new Cell();

        cell.nextState(neighbours);

        assertThat(cell.isAlive(), is(false));
    }

    @Test
    public void keep_alive_if_has_normal_population(){
        Cell cell = new Cell();

        cell.nextState(2);

        assertThat(cell.isAlive(),is(true));
    }

}
