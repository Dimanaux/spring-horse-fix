package com.example.fixhorse.chess;

import com.example.fixhorse.services.HorseBoardFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MediumBoardTest {
    private HorseBoardFacade board;

    @Before
    public void createBoard() {
        board = new HorseBoardFacade(3, 3);
    }

    @Test
    public void noWayToCenter() {
        int count = board.from("A2").to("B2").stepCount();
        Assert.assertEquals(-1, count);
    }

    @Test
    public void noWayOutFromCenter() {
        int count = board.from("B2").to("A2").stepCount();
        Assert.assertEquals(-1, count);
    }

    @Test
    public void centerFromCenter() {
        int count = board.from("B2").to("B2").stepCount();
        Assert.assertEquals(0, count);
    }

    @Test
    public void adjacentCell() {
        int count = board.from("A1").to("A2").stepCount();
        Assert.assertEquals(3, count);
    }

    @Test
    public void oppositeCorners() {
        int count = board.from("A3").to("C1").stepCount();
        Assert.assertEquals(4, count);
    }
}
