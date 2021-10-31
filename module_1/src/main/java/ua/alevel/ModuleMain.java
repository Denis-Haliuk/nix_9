package ua.alevel;

import ua.alevel.firstlevel.horsestep.CanHorseGoToEnteredCell;
import ua.alevel.secondlevel.isstringvalid.IsStringValid;
import ua.alevel.secondlevel.maxdepthoftree.TreeNodeUtil;
import ua.alevel.firstlevel.trianglearea.TriangleAreaByThreePoints;
import ua.alevel.firstlevel.uniquesymbols.UniqueSymbolsInArray;
import ua.alevel.thirdlevel.gameoflife.GameOfLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModuleMain {
    public static void main(String[] args) {
        System.out.println("ModuleMain.main");

        System.out.println("Module 1 - Select task: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("0")) {
                    System.exit(0);
                }
                switcher(position);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void runNavigation() {
        System.out.println();
        System.out.println("Task 1 - find unique symbols in array");
        System.out.println("Task 2 - can horse go there?");
        System.out.println("Task 3 - calculate area of triangle by three points");
        System.out.println("Task 4 - is string valid?");
        System.out.println("Task 5 - get max tree length");
        System.out.println("Task 6 - Game of Life");
        System.out.println("0 - exit");
        System.out.println();
    }

    private static void switcher(String position) throws IOException {
        switch (position) {
            case "1" -> UniqueSymbolsInArray.printUniqueSymbolsInArray();
            case "2" -> CanHorseGoToEnteredCell.canHorseGoToEnteredCell();
            case "3" -> TriangleAreaByThreePoints.findTriangleAreaByThreePoints();
            case "4" -> isStringValid();
            case "5" -> calculateMaxLengthOfTree();
            case "6" -> GameOfLife.runGame();
        }
        runNavigation();
    }

    private static void isStringValid() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your string: ");
        boolean isStringValid = IsStringValid.isValid(bufferedReader.readLine());
        System.out.println("isStringValid = " + isStringValid);
    }

    private static void calculateMaxLengthOfTree() {
        var treeNodeUtil = new TreeNodeUtil();
        treeNodeUtil.consoleOutput();
        System.out.println("maxLength = " + treeNodeUtil.getMaxLength());
    }
}
