package ua.alevel;

import java.util.Arrays;

public class CollectionMain {
    public static void main(String[] args) {
        System.out.println("CollectionMain.main");

        Integer[] integers = {
                1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
        };


        System.out.println("integers = " + Arrays.toString(integers));
        MathSet mathSet = new MathSet(integers);

        mathSet.add(66);
//        for (int i = 0; i < 20; i++) {
//            mathSet.add(i);
//        }


        mathSet.output();


    }
}
