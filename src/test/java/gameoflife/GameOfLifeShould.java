package gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeShould {

    private Cell aliveCell;
    private World world;
    private Coordinate leftCoordinate;
    private Coordinate rightCoordinate;
    private Coordinate middleCoordinate;
    private GameOfLife gameOfLife;

    @Before
    public void before(){
        aliveCell = new Cell(true);
        world = new World(new Coordinate(0,0),new Coordinate(100,100));
        leftCoordinate = new Coordinate(0, 0);
        rightCoordinate = new Coordinate(2, 0);
        middleCoordinate = new Coordinate(1, 0);
        gameOfLife = new GameOfLife(world);
        world.put(leftCoordinate, aliveCell);
        world.put(middleCoordinate, aliveCell);
        world.put(rightCoordinate, aliveCell);
    }

    @Test
    public void calculate_next_state_to_each_cell_in_World(){
        gameOfLife.nextStep();

        assertThat( world.get(leftCoordinate).isAlive(), is(false));
        assertThat( world.get(middleCoordinate).isAlive(), is(true));
        assertThat( world.get(rightCoordinate).isAlive(), is(false));
    }
}