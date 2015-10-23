# Conway’s Game of Life Exercise

## Goal

> The goal of this exercise is to calculate the next generation of Conway’s game of life 
 given any initial state. Take a look at the following for some background on 
 Conway’s game of life:

## Rules 

 1. Any live cell with fewer than two live neighbors dies, as if caused by underN
 population.
 2. Any live cell with more than three live neighbors dies, as if by overcrowding.
 3. Any live cell with two or three live neighbors lives on to the next generation.
 4. Any dead cell with exactly three live neighbors becomes a live cell.
 5. A cell’s neighbors are those cells which are horizontally, vertically or 
 diagonally adjacent. Most cells will have eight neighbors. Cells placed on the 
 edge of the grid will have fewer.

 ## Implementation

 This Program uses the simplest implementation of the game using command line to print
 output. It'll read the input file from command line(passed through command line arguments),
 or otherwise it'll use default input.txt from resources directory. It will propmt user if
 he/she wants to continue output as next initial state and play next states and so on!

 ## Running the App

 >open command line and go to the directory where you copied application then use following command:
        %APP_DIR%> gradlew run -Dexec.args="PATH TO YOUR INPUT FILE"
