package ua.alevel.util;

import ua.alevel.tasks.dateFormatter.DateFormatter;
import ua.alevel.tasks.findUniqueNames.FindUniqueNames;
import ua.alevel.tasks.shortestWay.ShortestWays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class NavigationController {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select operation:");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("0")) {
                    break;
                }
                mainOperations(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println("1 - Date formatter");
        System.out.println("2 - Find unique name");
        System.out.println("3 - Shortest ways");
        System.out.println("0 - exit");
        System.out.println();
    }

    private void mainOperations(String position, BufferedReader reader) {

        switch (position) {
            case "1" -> {
                DateFormatter dateFormatter = new DateFormatter();
                System.out.println("dateFormatt er = " + dateFormatter.formattedDate());
            }
            case "2" -> {
                FindUniqueNames findUniqueNames = new FindUniqueNames();
                System.out.println("First unique name = " + findUniqueNames.findFirstUniqueName());

            }
            case "3" -> {
                ShortestWays shortestWays = new ShortestWays();
                shortestWays.run();
            }
        }
        runNavigation();
    }




}
