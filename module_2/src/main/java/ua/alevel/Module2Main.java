package ua.alevel;

import ua.alevel.tasks.DateFormatter;
import ua.alevel.tasks.FindUniqueNames;

import java.util.ArrayList;
import java.util.List;

public class Module2Main {
    public static void main(String[] args) {

        System.out.println("Module2Main.main");

        DateFormatter dataFormatter = new DateFormatter();
        System.out.println("Formatted date = " + dataFormatter.formattedDate());

        FindUniqueNames findUniqueNames = new FindUniqueNames();
        System.out.println("First unique name = " + findUniqueNames.findFirstUniqueName());


    }
}
