package ua.alevel.navigation;

import ua.alevel.MathSet;
import ua.alevel.MathSetImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class CreateOperations {

    public static void createMathSetFromMathSets(BufferedReader reader) {
        try {
            Random random = new Random();
            System.out.println("Enter array size: ");
            int arrSize = Integer.parseInt(reader.readLine());
            Number[] numbers = new Number[arrSize];
            for (int i = 0; i < arrSize; i++) {
                numbers[i] = random.nextInt(1, 25);
            }
            MathSet mathSet = new MathSetImpl(numbers);
            System.out.println("mathSet:" + mathSet.toString());
            System.out.println("mathset size" + mathSet.getSize());

            System.out.println("Enter array size: ");
            int arrSize1 = Integer.parseInt(reader.readLine());
            Number[] numbers1 = new Number[arrSize];
            for (int i = 0; i < arrSize; i++) {
                numbers1[i] = random.nextInt(1, 25);
            }

            MathSet mathSet1 = new MathSetImpl(numbers1);
            System.out.println("mathSet1:" + mathSet1.toString());
            System.out.println("mathset1 size" + mathSet1.getSize());

            MathSet mathSet2 = new MathSetImpl(mathSet, mathSet1);
            System.out.println("mathSet(mathSet1, mathSet2) = " + mathSet2.toString());
            System.out.println("mathSet(mathSet, mathSet2) size = " + mathSet2.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createMathSetFromMathSet(BufferedReader reader) {
        try {
            Random random = new Random();
            System.out.println("Enter array size: ");
            int arrSize = Integer.parseInt(reader.readLine());
            Number[] numbers = new Number[arrSize];
            for (int i = 0; i < arrSize; i++) {
                numbers[i] = random.nextInt(1, 25);
            }
            MathSet mathSet = new MathSetImpl(numbers);
            System.out.println("mathSet:" + mathSet.toString());
            System.out.println("mathset size" + mathSet.getSize());

            MathSet mathSet1 = new MathSetImpl(mathSet);
            System.out.println("mathSet(mathSet) = " + mathSet1.toString());
            System.out.println("mathSet(mathSet) size = " + mathSet1.getSize());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createMathSetFromArrays(BufferedReader reader) {
        try {
            Random random = new Random();
            System.out.println("Enter first array size: ");
            int arrSize = Integer.parseInt(reader.readLine());
            Number[] numbers = new Number[arrSize];
            for (int i = 0; i < arrSize; i++) {
                numbers[i] = random.nextInt(1, 25);
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            System.out.println("Enter second array size: ");
            int arrSize1 = Integer.parseInt(reader.readLine());
            Number[] numbers1 = new Number[arrSize1];
            for (int i = 0; i < arrSize1; i++) {
                numbers1[i] = random.nextInt(1, 25);
                System.out.print(numbers1[i] + " ");
            }
            System.out.println();

            System.out.println("Enter third array size: ");
            int arrSize2 = Integer.parseInt(reader.readLine());
            Number[] numbers2 = new Number[arrSize2];
            for (int i = 0; i < arrSize2; i++) {
                numbers2[i] = random.nextInt(1, 25);
                System.out.print(numbers2[i] + " ");
            }
            System.out.println();

            MathSet mathSet = new MathSetImpl(numbers, numbers1, numbers2);
            System.out.println("mathSet:" + mathSet.toString());
            System.out.println("size" + mathSet.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createMathSetFromArray(BufferedReader reader) {
        try {
            Random random = new Random();
            System.out.println("Enter array size: ");
            int arrSize = Integer.parseInt(reader.readLine());
            Number[] numbers = new Number[arrSize];
            for (int i = 0; i < arrSize; i++) {
                numbers[i] = random.nextInt(1, 25);
            }
            MathSet mathSet = new MathSetImpl(numbers);
            System.out.println("mathSet:" + mathSet.toString());
            System.out.println("size" + mathSet.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createMathSet() {
        MathSet mathSet = new MathSetImpl();
        System.out.println("mathSet:" + mathSet.toString());
        System.out.println("size" + mathSet.getSize());
    }

    public static void createMathSetWithCapacity(BufferedReader reader) {
        try {
            System.out.println("Enter capacity:");
            int capacity = Integer.parseInt(reader.readLine());
            MathSetImpl mathSet = new MathSetImpl(capacity);
            System.out.println("mathSet:" + mathSet.toString());
            System.out.println("size" + mathSet.getSize());
            System.out.println("mathSet.getCapacity() = " + mathSet.getCapacity());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
