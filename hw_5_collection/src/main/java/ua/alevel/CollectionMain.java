package ua.alevel;

import java.util.Random;

public class CollectionMain {
    public static void main(String[] args) {
        System.out.println("CollectionMain.main");


        Random random = new Random();

        MathSet mathSet = new MathSetImpl();
        MathSet mathSet1 = new MathSetImpl();
        MathSet mathSet2 = new MathSetImpl();
        MathSet mathSet3 = new MathSetImpl();


        for (int i = 0; i < 100; i++) {
            mathSet.add(random.nextInt(25, 55));
            mathSet1.add(random.nextInt(25, 55));
            mathSet2.add(random.nextInt(25, 55));
            mathSet3.add(random.nextInt(25, 55));
        }

//        mathSet.add(1,2,3,4);
//        mathSet1.add(3,4,5,6);
//        mathSet2.add(1,2,3,7);

        System.out.println("mathSet = " + mathSet);
//        System.out.println("mathSet1 = " + mathSet1);
//        System.out.println("mathSet2 = " + mathSet2);
//        System.out.println("mathSet3 = " + mathSet3);
////
//        mathSet.join(mathSet1);
//        System.out.println("mathSet = " + mathSet);
//
//        mathSet.join(mathSet1, mathSet3);
//        System.out.println("mathSet = " + mathSet);
//
//        mathSet.sortAsc();
//        System.out.println("mathSet = " + mathSet);
//
//        mathSet.sortDesc();
//        System.out.println("mathSet = " + mathSet);


//        mathSet.intersection(mathSet1);
//        System.out.println("mathSet = " + mathSet);

        System.out.println("mathSet.getMax() = " + mathSet.getMax());
        System.out.println("mathSet.getMin() = " + mathSet.getMin());


        MathSet mathSet4 = mathSet.cut(2, 6);
        System.out.println("mathSet4 = " + mathSet4);

    }
}
