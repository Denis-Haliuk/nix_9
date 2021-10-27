package ua.alevel.horsestep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CanHorseGoToEnteredCell {
    public static void canHorseGoToEnteredCell() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Enter horse position 1 : ");
        int h1 = Integer.parseInt(bufferedReader.readLine());


        System.out.println("Enter horse position 2 : ");
        int h2 = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Enter cell position 1: ");
        int c1 = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Enter cell position 2: ");
        int c2 = Integer.parseInt(bufferedReader.readLine());

        int dx = Math.abs(h1 - h2);
        int dy = Math.abs(c1 - c2);

        if (dx == 1 && dy == 1 || dx == 2 && dy == 1) {
            System.out.println("Horse can go there!");
        } else {
            System.out.println("Horse can`t go there.");
        }

    }
}
