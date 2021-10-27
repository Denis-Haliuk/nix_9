package ua.alevel;

import ua.alevel.horsestep.CanHorseGoToEnteredCell;
import ua.alevel.isstringvalid.IsStringValid;
import ua.alevel.trianglearea.TriangleAreaByThreePoints;
import ua.alevel.uniquesymbols.UniqueSymbolsInArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModuleMain {
    public static void main(String[] args) throws IOException {
        System.out.println("ModuleMain.main");

//        System.out.println("Task 1 - find unique symbols in array");
//        UniqueSymbolsInArray.printUniqueSymbolsInArray();
//
//        System.out.println("Task 2 - can horse go there?");
//        CanHorseGoToEnteredCell.canHorseGoToEnteredCell();
//
//        System.out.println("Task 3 - calculate area of triangle by three points");
//        TriangleAreaByThreePoints.findTriangleAreaByThreePoints();

        System.out.println("Task 4 - is string valid?)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isStringValid = IsStringValid.isValid(bufferedReader.readLine());
        System.out.println("isStringValid = " + isStringValid);


    }
}
