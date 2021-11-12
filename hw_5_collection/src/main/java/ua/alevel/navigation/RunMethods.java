package ua.alevel.navigation;

import ua.alevel.MathSet;
import ua.alevel.MathSetImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Random;


public class RunMethods {


    public static void add(BufferedReader reader) {
        MathSet mathSet = getRandomMathSet();
        try {
            System.out.println("enter any number: ");
            Number number = NumberFormat.getInstance().parse(reader.readLine());
            mathSet.add(number);
        } catch (ParseException | IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
        System.out.println("mathSet = " + mathSet);
    }

    public static void addArray(BufferedReader reader) {
        MathSet mathSet = getRandomMathSet();

        Number[] numbers = {1, 2.3, 22, 2L, 2};
        System.out.println("Array: ");
        for (Number number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        mathSet.add(numbers);
        System.out.println("mathSet = " + mathSet);
    }

    public static void join() {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();
        MathSet mathSet1 = getRandomMathSet();

        mathSet.join(mathSet1);

        System.out.println("after join: mathSet = " + mathSet);
    }

    public static void joinMatSetArray() {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();
        MathSet mathSet1 = getRandomMathSet();
        MathSet mathSet2 = getRandomMathSet();
        MathSet mathSet3 = getRandomMathSet();

        mathSet.join(mathSet1, mathSet2, mathSet3);

        System.out.println("after join: mathSet = " + mathSet);
    }

    public static void intersection() {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();
        MathSet mathSet1 = getRandomMathSet();

        mathSet.intersection(mathSet1);

        System.out.println("after intersection: mathSet = " + mathSet);
    }

    public static void intersectionMatSetArray() {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();
        MathSet mathSet1 = getRandomMathSet();
        MathSet mathSet2 = getRandomMathSet();
        MathSet mathSet3 = getRandomMathSet();

        mathSet.intersection(mathSet1, mathSet2, mathSet3);

        System.out.println("after join: mathSet = " + mathSet);
    }


    public static void sortAsc() {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();


        for (int i = 0; i < 10; i++) {
            mathSet.add(random.nextInt(0, 30));
        }

        System.out.println("mathSet = " + mathSet);

        mathSet.sortAsc();

        System.out.println("after ascending sort: mathSet = " + mathSet);
    }

    public static void sortAscByIndex(BufferedReader reader) {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();

        for (int i = 0; i < 10; i++) {
            mathSet.add(random.nextInt(0, 30));
        }

        System.out.println("mathSet = " + mathSet);

        try {
            System.out.println("enter first index:");
            int firstIndex = Integer.parseInt(reader.readLine());

            System.out.println("enter second index:");
            int secondIndex = Integer.parseInt(reader.readLine());

            mathSet.sortAsc(firstIndex, secondIndex);
            System.out.println("after ascending sort with indexes: mathSet = " + mathSet);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
    }

    public static void sortAscByNumber(BufferedReader reader) {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();

        for (int i = 0; i < 10; i++) {
            mathSet.add(random.nextInt(0, 30));
        }

        System.out.println("mathSet = " + mathSet);

        try {
            System.out.println("enter number:");
            int number = Integer.parseInt(reader.readLine());

            mathSet.sortAsc(number);
            System.out.println("after ascending sort by number: mathSet = " + mathSet);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
    }


    public static void sortDesc() {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();

        for (int i = 0; i < 10; i++) {
            mathSet.add(random.nextInt(0, 30));
        }

        System.out.println("mathSet = " + mathSet);

        mathSet.sortDesc();

        System.out.println("after descending sort: mathSet = " + mathSet);
    }

    public static void sortDescByIndex(BufferedReader reader) {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();

        for (int i = 0; i < 10; i++) {
            mathSet.add(random.nextInt(0, 30));
        }

        System.out.println("mathSet = " + mathSet);

        try {
            System.out.println("enter first index:");
            int firstIndex = Integer.parseInt(reader.readLine());

            System.out.println("enter second index:");
            int secondIndex = Integer.parseInt(reader.readLine());

            mathSet.sortDesc(firstIndex, secondIndex);
            System.out.println("after descending sort with indexes: mathSet = " + mathSet);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
    }

    public static void sortDescByNumber(BufferedReader reader) {
        Random random = new Random();
        MathSet mathSet = getRandomMathSet();

        for (int i = 0; i < 10; i++) {
            mathSet.add(random.nextInt(0, 30));
        }

        System.out.println("mathSet = " + mathSet);

        try {
            System.out.println("enter number:");
            int number = Integer.parseInt(reader.readLine());

            mathSet.sortDesc(number);
            System.out.println("after descending sort by number: mathSet = " + mathSet);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
    }

    public static void isContains(BufferedReader reader) {

        MathSet mathSet = getRandomMathSet();
        try {

            System.out.println("enter number");
            int number = Integer.parseInt(reader.readLine());
            System.out.println("number contains in mathset: " + mathSet.isContains(number));

        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
    }

    public static void getSize() {
        MathSet mathSet = getRandomMathSet();
        mathSet.getSize();
    }

    public static void getMax() {
        MathSet mathSet = getRandomMathSet();
        System.out.println("mathset max: " + mathSet.getMax());
    }

    public static void getMin() {
        MathSet mathSet = getRandomMathSet();
        System.out.println("mathset min: " + mathSet.getMin());
    }

    public static void getAverage() {
        MathSet mathSet = getRandomMathSet();
        System.out.println("mathset average: " + mathSet.getAverage());
    }

    public static void getMedian() {
        MathSet mathSet = getRandomMathSet();
        System.out.println("mathset median: " + mathSet.getMedian());
    }

    public static void toArray() {
        MathSet mathSet = getRandomMathSet();

        Number[] numbers = mathSet.toArray();
        System.out.println("mathSet.toArray() = " + Arrays.toString(numbers));
    }

    public static void toArrayByIndexes(BufferedReader reader) {
        MathSet mathSet = getRandomMathSet();
        try {
            System.out.println("enter first index:");
            int firstIndex = Integer.parseInt(reader.readLine());

            System.out.println("enter second index:");
            int secondIndex = Integer.parseInt(reader.readLine());

            System.out.println("mathset: " + Arrays.toString(mathSet.toArray(firstIndex, secondIndex)));

        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
    }

    public static void get(BufferedReader reader) {
        MathSet mathSet = getRandomMathSet();
        try {
            System.out.println("enter first index:");
            int firstIndex = Integer.parseInt(reader.readLine());

            System.out.println("mathset[index]: " + mathSet.get(firstIndex));

        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }

    }

    public static void cut(BufferedReader reader) {
        MathSet mathSet = getRandomMathSet();
        try {
            System.out.println("enter first index:");
            int firstIndex = Integer.parseInt(reader.readLine());

            System.out.println("enter second index:");
            int secondIndex = Integer.parseInt(reader.readLine());

           MathSet cuttedMatSet = mathSet.cut(firstIndex, secondIndex);

            System.out.println("cuttedMatSet = " + cuttedMatSet);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Wrong input:" + e);
        }
    }

    public static void clear() {
        MathSet mathSet = getRandomMathSet();
        mathSet.clear();
        System.out.println("mathSet = " + mathSet);
    }

    public static void clearByArray() {
        MathSet mathSet = getRandomMathSet();
        Random random = new Random();
        Number[] numbers = new Number[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(0, 25);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        mathSet.clear(numbers);

        System.out.println("mathSet = " + mathSet);
    }

    private static MathSet getRandomMathSet() {
        Random random = new Random();

        MathSet mathSet = new MathSetImpl();

        for (int i = 0; i < 10; i++) {
            mathSet.add(random.nextInt(0, 30));
        }
        System.out.println("mathSet = " + mathSet);
        return mathSet;
    }

}
