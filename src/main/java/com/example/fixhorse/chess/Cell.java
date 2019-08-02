package com.example.fixhorse.chess;

import java.util.Objects;

public class Cell {
    private DijkstraHorseBoard dijkstraHorseBoard;
    private final int x;
    private final int y;

    public Cell(DijkstraHorseBoard dijkstraHorseBoard, int x, int y) {
        this.dijkstraHorseBoard = dijkstraHorseBoard;
        this.x = x;
        this.y = y;
    }

    public int marking() {
        return dijkstraHorseBoard.at(x, y);
    }

    void mark(int mark) {
        if (mark < marking()) {
            dijkstraHorseBoard.set(mark, x, y);
        }
    }

    boolean inside() {
        return 0 <= x && 0 <= y && dijkstraHorseBoard.contains(x, y);
    }

    Cell plus(int deltaX, int deltaY) {
        return dijkstraHorseBoard.createCell(x + deltaX, y + deltaY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("%d@%c%d", marking(), x + 'A', y + 1);
    }
}
