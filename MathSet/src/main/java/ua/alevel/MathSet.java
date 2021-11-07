package ua.alevel;

import java.util.Arrays;

public class MathSet {

    private static final int SIZE = 10;

    private Number[] numbers = new Number[SIZE];
    private int counter = 0;

    public MathSet() {

    }

    public MathSet(int capacity) {

    }

    public MathSet(Number[] numbers) {
        this.numbers = numbers;
    }


    private Number[] grow() {
        int newCapacity = numbers.length + 1;
        return numbers = Arrays.copyOf(numbers, newCapacity);
    }


    public void add(Number n) {
        if (counter == 0) {
            numbers[counter] = n;
            counter++;
        } else {
            if (counter < numbers.length) {
                numbers[counter] = n;
                counter++;
            } else {
                grow();
                numbers[counter] = n;
                counter++;
            }

        }
    }

    public void output() {
        System.out.println("numbers length= " + numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers = " + numbers[i]);
        }
    }
}
