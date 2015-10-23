package com.hb.conway;

import org.apache.log4j.Logger;

public class GameOfLife {

    public static final String DEAD_CELL_SYMBOL = ".";
    public static final String LIVE_CELL_SYMBOL = "O";
    public static final int DEAD = 0;
    public static final int ALIVE = 1;

    /**
     * Given a State, acan all cells
     * row by row and create next State array
     *
     * @param state
     * @return
     */
    public int[][] getNextState(final int[][] state) {
        int rows = state.length;
        int cols = state[0].length;
        int[][] result = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[row][col] = getCellUpdatedStatus(row, col, state);
            }
        }
        return result;
    }

    /**
     * based on number of surrounding cells in current state,
     * the cell's future will be determined
     *
     * @param row
     * @param col
     * @param state
     * @return
     */
    int getCellUpdatedStatus(int row, int col,final int[][] state) {
        int neighbours = getNumberOfLiveNeihbourCells(row, col, state);
        if (neighbours < 2 && state[row][col] == 1) {
            return DEAD;
        }else if (neighbours > 3 && state[row][col] == 1) {
            return DEAD;
        }else if ((neighbours == 2 || neighbours == 3) && state[row][col] == 1) {
            return ALIVE;
        }else if (neighbours == 3 && state[row][col] == 0) {
            return ALIVE;
        }
        return DEAD;
    }

    /**
     * count number of live neighbours of a given cell
     *
     * @param row
     * @param col
     * @param state
     * @return
     */
    public int getNumberOfLiveNeihbourCells(int row, int col, int[][] state) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if( r== row && c == col )continue;//skip the cell itself and just count surrounding cells
                if (indexInRange(r, c, state) && state[r][c] == 1) {//neighbour is alive
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * check given [row,col] index to see if it's a valid cell on board
     * @param row
     * @param col
     * @param state
     * @return
     */
    private boolean indexInRange(int row, int col, int[][] state) {
        return row >= 0 && row < state.length && col >= 0 && col < state[0].length;
    }

    /**
     * Print given State in dots-circles format
     *
     * @param State
     */
    public void pritState(final int[][] State) {
        for (int i = 0; i < State.length; i++) {
            for (int j = 0; j < State[0].length; j++) {
                System.out.print(State[i][j] == 0 ? DEAD_CELL_SYMBOL : LIVE_CELL_SYMBOL);
            }
            System.out.println();
        }
    }
}
