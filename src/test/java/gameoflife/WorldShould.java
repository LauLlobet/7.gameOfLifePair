package gameoflife;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WorldShould {

    private World world;
    private int randomYinWorldRange;
    private int randomXinWorldRange;
    private int sideSize = 100;
    private Coordinate inRangeCoordinate;
    private Coordinate outOfRangeCoordinate;

    @Before
    public void before() {
        world =  new World(new Coordinate(0,0),new Coordinate(sideSize,sideSize));
        randomXinWorldRange = getRandomInt();
        randomYinWorldRange = getRandomInt();
        inRangeCoordinate = new Coordinate(randomXinWorldRange, randomYinWorldRange);
        outOfRangeCoordinate = new Coordinate(-10,-10);
    }

    private int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(0, sideSize + 1);
    }


    @Test
    public void start_with_all_cell_dead() {
        Cell cell = world.get(new Coordinate(randomXinWorldRange, randomYinWorldRange));

        assertThat(cell.isAlive(), is(false));
    }

    @Test
    public void store_cells_in_world_range() {
        Cell aliveCell = new Cell(true);
        world.put(inRangeCoordinate, aliveCell);

        Cell recoveredCell = world.get(inRangeCoordinate);

        assertThat(recoveredCell.isAlive(),is(true));
    }

    @Test
    public void have_dead_cells_out_of_range() {
        Cell recoveredCell = world.get(outOfRangeCoordinate);

        assertThat(recoveredCell.isAlive(),is(false));
    }

    @Test
    public void count_alive_neighbours_at_position_in_board(){
        Cell alive = new Cell(true);


        world.put(new Coordinate(0,0), alive);
        world.put(new Coordinate(1,0), alive);
        world.put(new Coordinate(2,0), alive);

        world.put(new Coordinate(0,1), alive);
        world.put(new Coordinate(2,1), alive);

        world.put(new Coordinate(0,2), alive);
        world.put(new Coordinate(1,2), alive);
        world.put(new Coordinate(2,2), alive);

        int aliveNeighbours = world.countAliveNeighboursAt(new Coordinate(1,1));


        assertThat(aliveNeighbours,is(8));
    }

}
