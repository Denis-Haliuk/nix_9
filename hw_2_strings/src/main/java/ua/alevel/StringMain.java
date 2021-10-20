package ua.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringMain {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                switcher(position);
                position = reader.readLine();
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
        System.out.println("1 - basic reverse");
        System.out.println("2 - reverse by substring");
        System.out.println("3 - reverse by index");
        System.out.println("0 - exit");
        System.out.println();
    }

    private static void switcher(String position) throws IOException {
        switch (position) {
            case "1" : basicReverse(); break;
            case "2" : reverseBySubstring(); break;
            case "3" : reverseByIndex(); break;
                    }
        runNavigation();
    }


    private static void basicReverse() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your string: ");
        String text = reader.readLine();
        String result = StringHelperUtil.reverse(text);
        System.out.println("result = " + result);
    }

    private static void reverseBySubstring() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your string: ");
        String text = reader.readLine();
        System.out.println("Enter your substring: ");
        String substring = reader.readLine();
        String result = StringHelperUtil.reverseBySubstring(text, substring);
        System.out.println("result = " + result);
    }

    private static void reverseByIndex() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your string: ");
        String text = reader.readLine();
        System.out.println("Enter your start index: ");
        int startIndex = Integer.parseInt(reader.readLine());
        System.out.println("Enter your end index: ");
        int endIndex = Integer.parseInt(reader.readLine());
        String result = StringHelperUtil.reverseByIndex(text, startIndex, endIndex);
        System.out.println("result = " + result);
    }


}
