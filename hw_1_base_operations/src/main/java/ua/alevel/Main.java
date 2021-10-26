package ua.alevel;

import ua.alevel.sumofallnumbersinstring.SumOfAllNumbersInString;
import ua.alevel.amountofuniquechars.AmountOfUniqueChars;
import ua.alevel.lessontime.PrintLessonTimeByLessonNumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SumOfAllNumbersInString sumOfAllNumbersInString = new SumOfAllNumbersInString();
        AmountOfUniqueChars amountOfUniqueChars = new AmountOfUniqueChars();
        PrintLessonTimeByLessonNumber printLessonTimeByLessonNumber = new PrintLessonTimeByLessonNumber();
        int i = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select task: ");
        System.out.println("1 - sum of all numbers in string");
        System.out.println("2 - amount of letters in strings");
        System.out.println("3 - time of lesson");
        i = scanner.nextInt();
        switch (i) {
            case 1:
                sumOfAllNumbersInString.firstTask();
                break;
            case 2:
                amountOfUniqueChars.secondTask();
                break;
            case 3:
                printLessonTimeByLessonNumber.thirdTask();
                break;

        }


    }
}
