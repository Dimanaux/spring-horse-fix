package com.example.fixhorse.services;

import com.example.fixhorse.chess.Cell;
import com.example.fixhorse.chess.DijkstraHorseBoard;

public class HorseBoardFacade {
    private final DijkstraHorseBoard horseBoard;
    private Cell from;
    private Cell to;

    public HorseBoardFacade(int width, int height) {
        horseBoard = new DijkstraHorseBoard(width, height);
    }

    public HorseBoardFacade from(String cell) {
        this.from = parse(cell);
        return this;
    }

    public HorseBoardFacade to(String cell) {
        this.to = parse(cell);
        return this;
    }

    public int stepCount() {
        int rawStepCount = horseBoard.shortestPath(from, to);
        if (rawStepCount == DijkstraHorseBoard.INFINITY) {
            return -1;
        }
        return rawStepCount;
    }

    private Cell parse(String string) {
        assert string.length() == 2;
        char letter = string.charAt(0);
        char digit = string.charAt(1);
        return horseBoard.createCell(
                Character.toUpperCase(letter) - 'A',
                digit - '0' - 1
        );
    }
}
