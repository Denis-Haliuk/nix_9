package ua.alevel;

import ua.alevel.firsttask.FirstTask;
import ua.alevel.secondtask.SecondTask;
import ua.alevel.thirdtask.ThirdTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask();
        SecondTask secondTask = new SecondTask();
        ThirdTask thirdTask = new ThirdTask();
        int i = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select task: ");
        System.out.println("1 - sum of all numbers in string");
        System.out.println("2 - amount of letters in strings");
        System.out.println("3 - time of lesson");
        i = scanner.nextInt();
        switch (i) {
            case 1:
                firstTask.firstTask();
                break;
            case 2:
                secondTask.secondTask();
                break;
            case 3:
                thirdTask.thirdTask();
                break;

        }


    }
}
