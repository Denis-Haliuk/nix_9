package ua.alevel.navigation;

import java.io.BufferedReader;
import java.io.IOException;

public class MathSethMethodNavigation {

    public static void runMethodsInterface(BufferedReader reader) {
        System.out.println("MathSet methods");
        System.out.println("Select operation:");
        String position;
        try {
            runMethodsNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("0")) {
                    break;
                }
                runMethods(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void runMethodsNavigation() {
        System.out.println("1 - void add(Number n);");
        System.out.println("2 - void add(Number ... n);");
        System.out.println("3 - void join(MathSet ms);");
        System.out.println("4 - void join(MathSet ... ms);");
        System.out.println("5 - void intersection(MathSet ms);");
        System.out.println("6 - void intersection(MathSet... ms);");
        System.out.println("7 - void sortDesc();");
        System.out.println("8 - void sortDesc(int firstIndex, int lastIndex);");
        System.out.println("9 - void sortDesc(Number value);");
        System.out.println("10 - void sortAsc();");
        System.out.println("11 - void sortAsc(int firstIndex, int lastIndex);");
        System.out.println("12 - void sortAsc(Number value);");
        System.out.println("13 - boolean isContains(Number number);");
        System.out.println("14 - int getSize();");
        System.out.println("15 - Number get(int index);");
        System.out.println("16 - Number getMax();");
        System.out.println("17 - Number getMin();");
        System.out.println("18 - Number getAverage();");
        System.out.println("19 - Number getMedian();");
        System.out.println("20 - Number[] toArray();");
        System.out.println("21 - Number[] toArray(int firstIndex, int lastIndex);");
        System.out.println("22 - MathSet cut(int firstIndex, int lastIndex);");
        System.out.println("23 - void clear();");
        System.out.println("24 - void clear(Number[] numbers);");
        System.out.println("0 - exit");
        System.out.println();
    }

    private static void runMethods(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> RunMethods.add(reader);
            case "2" -> RunMethods.addArray(reader);
            case "3" -> RunMethods.join();
            case "4" -> RunMethods.joinMatSetArray();
            case "5" -> RunMethods.intersection();
            case "6" -> RunMethods.intersectionMatSetArray();
            case "7" -> RunMethods.sortDesc();
            case "8" -> RunMethods.sortDescByIndex(reader);
            case "9" -> RunMethods.sortDescByNumber(reader);
            case "10" -> RunMethods.sortAsc();
            case "11" -> RunMethods.sortAscByIndex(reader);
            case "12" -> RunMethods.sortAscByNumber(reader);
            case "13" -> RunMethods.isContains(reader);
            case "14" -> RunMethods.get(reader);
            case "15" -> RunMethods.getSize();
            case "16" -> RunMethods.getMax();
            case "17" -> RunMethods.getMin();
            case "18" -> RunMethods.getAverage();
            case "19" -> RunMethods.getMedian();
            case "20" -> RunMethods.toArray();
            case "21" -> RunMethods.toArrayByIndexes(reader);
            case "22" -> RunMethods.cut(reader);
            case "23" -> RunMethods.clear();
            case "24" -> RunMethods.clearByArray();

        }
        runMethodsNavigation();
    }
}
