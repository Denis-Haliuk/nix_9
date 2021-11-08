package ua.alevel;

public class CollectionMain {
    public static void main(String[] args) {
        System.out.println("CollectionMain.main");

        Integer[] ints = {1,2,3,4,3};
        Integer[] ints1 = {125, 11};

        MathSet mathSet = new MathSetImpl(ints, ints);
        System.out.println("mathSet = " + mathSet);
        MathSet mathSet1 = new MathSetImpl(ints1, ints1);
        System.out.println("mathSet1 = " + mathSet1);

        mathSet.add(7,8,9,66,1L, 5.23, 3);
        System.out.println("mathSet = " + mathSet);

        mathSet.join(mathSet1);
        System.out.println("mathSet = " + mathSet);


    }
}
