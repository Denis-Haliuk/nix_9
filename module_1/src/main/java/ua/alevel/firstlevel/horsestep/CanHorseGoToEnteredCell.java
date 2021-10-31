package ua.alevel.firstlevel.horsestep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CanHorseGoToEnteredCell {
    public static void canHorseGoToEnteredCell() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter horse position 1 : ");
            int h1 = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Enter horse position 2 : ");
            int h2 = Integer.parseInt(bufferedReader.readLine());

            printBoard(h1, h2);

            System.out.println("Enter cell position 1: ");
            int c1 = Integer.parseInt(bufferedReader.readLine());

            System.out.println("Enter cell position 2: ");
            int c2 = Integer.parseInt(bufferedReader.readLine());

            int dx = Math.abs(h1 - c1);
            int dy = Math.abs(h2 - c2);

            printBoard(c1, c2);

            if (dx == 1 && dy == 2 || dx == 2 && dy == 1) {
                System.out.println("Horse can go there!");
            } else {
                System.out.println("Horse can`t go there.");
            }
        } catch (NumberFormatException e) {
            System.out.println("error = " + e);
        }
    }

    static void printBoard(int x, int y) {
        for (int i = 1; i <= 8; i++) {
            System.out.println(" ");
            for (int j = 1; j <= 8; j++) {
                if (i == 8 - y + 1 && j == x) System.out.print("1 ");
                else System.out.print("0 ");
            }
        }
        System.out.println();
    }
}
