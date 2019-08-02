package com.example.fixhorse.chess;

import java.util.*;
import java.util.stream.Stream;

public class DijkstraHorseBoard {
    public final static int INFINITY = 1024;

    private final int[][] marks;
    private PriorityQueue<Cell> queue;
    private HashSet<Cell> done;

    public DijkstraHorseBoard(int width, int height) {
        marks = new int[width][height];
        for (int[] line : marks) {
            for (int i = 0; i < height; i++) {
                line[i] = INFINITY;
            }
        }
    }

    public int shortestPath(Cell from, Cell to) {
        markFromTo(from, to);
        return to.marking();
    }

    private void markFromTo(Cell start, Cell end) {
        start.mark(0);
        queue = new PriorityQueue<>(
                Comparator.comparing(Cell::marking)
        );
        done = new HashSet<>();
        markAndMove(start, end, 0);
    }

    private void markAndMove(Cell cell, Cell end, int step) {
        if (done.contains(end)) {
            return;
        }
        if (cell.marking() <= step) {
            done.add(cell);
        }
        adjacentWithDeltas(cell)
                .peek(c -> c.mark(step + 1))
                .forEach(queue::offer);
        if (queue.isEmpty()) {
            return;
        }
        Cell first = queue.poll();
        markAndMove(first, end, first.marking());
    }

    boolean contains(int x, int y) {
        return x < marks.length && y < marks[0].length;
    }

    int at(int x, int y) {
        return marks[x][y];
    }

    void set(int mark, int x, int y) {
        marks[x][y] = mark;
    }

    public Cell createCell(int x, int y) {
        return new Cell(this, x, y);
    }

    private Stream<Cell> adjacentWithDeltas(Cell cell) {
        int delta1 = 1;
        int delta2 = 2;
        return Stream.of(
                cell.plus(delta1, delta2),
                cell.plus(delta1, -delta2),
                cell.plus(-delta1, delta2),
                cell.plus(-delta1, -delta2),
                cell.plus(delta2, delta1),
                cell.plus(delta2, -delta1),
                cell.plus(-delta2, delta1),
                cell.plus(-delta2, -delta1)
        ).filter(Cell::inside)
                .filter(c -> c.marking() == DijkstraHorseBoard.INFINITY)
                .distinct();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (int[] line : marks) {
            joiner.add(Arrays.toString(line));
        }
        return joiner.toString();
    }
}
