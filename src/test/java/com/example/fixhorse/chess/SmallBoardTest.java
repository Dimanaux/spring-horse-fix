package com.example.fixhorse.chess;

import com.example.fixhorse.services.HorseBoardFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SmallBoardTest {
    private HorseBoardFacade board;

    @Before
    public void createBoard() {
        board = new HorseBoardFacade(2, 3);
    }

    @Test
    public void oppositeCorners() {
        int count = board.from("A1").to("B3").stepCount();
        Assert.assertEquals(1, count);
    }

    @Test
    public void reverseOppositeCorners() {
        int count = board.from("B3").to("A1").stepCount();
        Assert.assertEquals(1, count);
    }

    @Test
    public void sameCell() {
        int count = board.from("A2").to("A2").stepCount();
        Assert.assertEquals(0, count);
    }

    @Test
    public void noWay() {
        int count = board.from("A2").to("B1").stepCount();
        Assert.assertEquals(-1, count);
    }
}
