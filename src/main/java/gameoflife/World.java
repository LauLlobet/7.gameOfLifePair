package gameoflife;

public class World {
    Cell cell = new Cell(false);
    public Cell getCell(int x, int y) {
        return cell;
    }

    public void putCell(int x, int y, Cell cell) {
        this.cell = cell;
    }
}
