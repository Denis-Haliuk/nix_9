package ua.alevel.navigation;

import java.io.BufferedReader;
import java.io.IOException;

public class MathSetCreationNavigation {

    public static void runCreationInterface(BufferedReader reader) {
        System.out.println("MathSet creation");
        System.out.println("Select operation:");
        String position;
        try {
            runCreateNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("0")) {
                    break;
                }
                createOperations(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void runCreateNavigation() {
        System.out.println("1 - MathSet()");
        System.out.println("2 - MathSet(int capacity)");
        System.out.println("3 - MathSet(Number[] numbers)");
        System.out.println("4 - MathSet(Number[] ... numbers)");
        System.out.println("5 - MathSet(MathSet numbers)");
        System.out.println("6 - MathSet(MathSet ... numbers)");
        System.out.println("0 - exit");
        System.out.println();
    }

    private static void createOperations(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> CreateOperations.createMathSet();
            case "2" -> CreateOperations.createMathSetWithCapacity(reader);
            case "3" -> CreateOperations.createMathSetFromArray(reader);
            case "4" -> CreateOperations.createMathSetFromArrays(reader);
            case "5" -> CreateOperations.createMathSetFromMathSet(reader);
            case "6" -> CreateOperations.createMathSetFromMathSets(reader);
        }
        runCreateNavigation();
    }
}
