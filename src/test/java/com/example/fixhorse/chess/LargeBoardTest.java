package com.example.fixhorse.chess;

import com.example.fixhorse.services.HorseBoardFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LargeBoardTest {
    private HorseBoardFacade board;

    @Before
    public void createBoard() {
        board = new HorseBoardFacade(3, 4);
    }

    @Test
    public void fromBottomLeftCorner1() {
        int count = board.from("A1").to("A4").stepCount();
        Assert.assertEquals(5, count);
    }

    @Test
    public void fromBottomLeftCorner2() {
        int count = board.from("A1").to("C4").stepCount();
        Assert.assertEquals(3, count);
    }

    @Test
    public void fromBottomLeftCorner3() {
        int count = board.from("A1").to("C3").stepCount();
        Assert.assertEquals(4, count);
    }

    @Test
    public void fromCenter1() {
        int count = board.from("B2").to("B3").stepCount();
        Assert.assertEquals(5, count);
    }

    @Test
    public void fromCenter2() {
        int count = board.from("B2").to("A4").stepCount();
        Assert.assertEquals(1, count);
    }

    @Test
    public void fromCenter3() {
        int count = board.from("B2").to("A1").stepCount();
        Assert.assertEquals(4, count);
    }
}
