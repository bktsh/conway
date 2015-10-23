package com.hb.conway;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConwayApplication {

    private static final GameOfLife game = new GameOfLife();
    private final File defaultInputSource = new File(getClass().getClassLoader().getResource("input.txt").getFile());

    public static void main(String[] args) {
        printGuidelines();
        ConwayApplication conwayApplication = new ConwayApplication();
        int[][] initial = conwayApplication.loadInput(args);
        while(true) {
            game.pritState(initial);
            System.out.println("\n  ||");
            System.out.println("  ||");
            System.out.println("  \\/\n");
            int[][] result = game.getNextState(initial);
            game.pritState(result);
            initial = result;
            displayMenu();
        }
    }

    private static void displayMenu() {
        System.out.println("\n  (1)quit, (2)Continue :");
        Scanner reader = new Scanner(System.in);
        int choice = reader.nextInt();
        if(choice == 1) System.exit(0);
        if(choice == 2) return;
        displayMenu();
    }

    private static void printGuidelines() {
        System.out.println("/////////////////////////////////////////////////////////////////////////////");
        System.out.println("// This progrm will need you to provide gameOfLife initial board in a file.//");
        System.out.println("// Otherwise it'll use following example as initial state:                 //");
        System.out.println("//                                                                         //");
        System.out.println("//                               00000010                                  //");
        System.out.println("//                               11100010                                  //");
        System.out.println("//                               00000010                                  //");
        System.out.println("//                               00000000                                  //");
        System.out.println("//                               00011000                                  //");
        System.out.println("//                               00011000                                  //");
        System.out.println("//                                                                         //");
        System.out.println("// At the end of state generation you will be prompted to quit or continue.//");
        System.out.println("//                                                                         //");
        System.out.println("/////////////////////////////////////////////////////////////////////////////");
    }

    /**
     * Reads input state from a file.
     */
    public int[][] loadInput(String[] args) {
        File file = args.length > 0 ? new File(args[0]): defaultInputSource;
        List<String> input = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("System cannot read the input file! please make sure the file exists.");
        }
        return convertInputToCharArray(input);
    }

    /**
     * Convert lines of Strings that was read from file/input to int[][]
     * @param input
     * @return
     */
    public int[][] convertInputToCharArray(List<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();
        int[][] initialConwayState = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                initialConwayState[row][col] = Integer.valueOf(String.valueOf(input.get(row).charAt(col)));
            }
        }
        return initialConwayState;
    }

}
