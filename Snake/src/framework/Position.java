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

    int getRow() {
        return row;
    }

    int getColumn() {
        return col;
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
}
