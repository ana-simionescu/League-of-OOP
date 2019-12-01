package main;

public final class PlayerInput {
    private String type;
    private int row;
    private int column;

    public String getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(final int column) {
        this.column = column;
    }

    public void setRow(final int row) {
        this.row = row;
    }

    public void setType(final String type) {
        this.type = type;
    }
}
