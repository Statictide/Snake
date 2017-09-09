package framework;

/**
 * Created by markn on 09-09-2017.
 */
public class Position {
    int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    /**
     * Returns the position in the specified direction
     * @param dir direction of the desired position
     * @return position in the desired direction
     */
    public Position getPosition(Direction dir) {
        Position result = null;
        switch (dir) {
            case UP:
                result = new Position(row - 1, col);
                break;
            case DOWN:
                result = new Position(row + 1, col);
                break;
            case LEFT:
                result = new Position(row, col - 1);
                break;
            case RIGHT:
                result = new Position(row, col + 1);
                break;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Position position = (Position) obj;
        return (position.row == this.row) && (position.col == this.col);
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }

    @Override
    public int hashCode() {
        return row * GameConstants.WORLD_SIZE + col;
    }
}
