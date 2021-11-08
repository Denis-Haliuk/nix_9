package ua.alevel;

import java.util.Arrays;
import java.util.Random;

public class CollectionMain {
    public static void main(String[] args) {
        System.out.println("CollectionMain.main");

        MathSet mathSet = new MathSet();

        for (int i = 0; i < 50; i++) {
            mathSet.add(i);
        }

        Number[] numbers = mathSet.toArray(0, 10);
        Number[] clearNumbers = {34};

        System.out.println("mathSet = " + mathSet);
        for (Number number: numbers) {
            System.out.println("numbers = " + number);
        }

        mathSet.clear(clearNumbers);
        System.out.println("mathSet = " + mathSet);

    }
}
