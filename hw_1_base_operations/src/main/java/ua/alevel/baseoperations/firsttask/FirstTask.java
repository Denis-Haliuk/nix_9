package ua.alevel.baseoperations.firsttask;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstTask {
    public void firstTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string:");
        String input = scanner.nextLine();

        char[] arr = input.toCharArray();
        var numbers = new ArrayList<Integer>();
        int k = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(arr[i])) {
                k++;
                numbers.add(Character.getNumericValue(arr[i]));
            }
        }

        int sum = 0;
        for (var number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}
