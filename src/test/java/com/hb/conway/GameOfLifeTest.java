package com.hb.conway;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.hb.conway.GameOfLife.ALIVE;
import static com.hb.conway.GameOfLife.DEAD;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class GameOfLifeTest {

    private GameOfLife subject;

    public int[][] initialState = {
            {0, 0, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0}};

    @Before
    public void setUp() throws Exception {
        subject = new GameOfLife();
    }

    @Test
    public void itShouldPrintGivenStateInDesiredFormat() {
        System.out.println();
        subject.pritState(initialState);
    }

    @Test
    public void itShouldReturnNumberOfLiveNeighboursOfAGivenCell(){
        int count = subject.getNumberOfLiveNeihbourCells(0, 0, initialState);
        assertEquals(2,count);
        count = subject.getNumberOfLiveNeihbourCells(0, 6, initialState);
        assertEquals(1,count);
        count = subject.getNumberOfLiveNeihbourCells(0, 1, initialState);
        assertEquals(3,count);
        count = subject.getNumberOfLiveNeihbourCells(0, 7, initialState);
        assertEquals(2, count);
    }

    @Test
    public void itShouldReturnNextState() {
        int[][] nextState = subject.getNextState(initialState);
        System.out.println();
        subject.pritState(nextState);
    }

    @Test
    public void itShouldReturnDeadForCellWirhMoreThan3Neighbours(){
        assertEquals(DEAD,subject.getCellUpdatedStatus(0,0,initialState));
        assertEquals(ALIVE,subject.getCellUpdatedStatus(0,1,initialState));
        assertEquals(ALIVE, subject.getCellUpdatedStatus(5, 3, initialState));
    }


}