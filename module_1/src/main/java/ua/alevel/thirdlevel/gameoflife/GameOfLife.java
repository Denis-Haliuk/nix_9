package ua.alevel.thirdlevel.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GameOfLife {
    private static boolean secondGeneration = true;

    public static void runGame() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String menu;
        int[][] nextGenerationMatrix;
        int[][] gameMatrix;
        int x = 0;
        int y = 0;

        System.out.println("New game: ");
        do {
            try {
                System.out.println("Enter size (x):  ");
                x = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter size (y):  ");
                y = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("error = " + e);
            }
        } while (x <= 0 || y <= 0);

        gameMatrix = randomizeLifeGame(x, y);
        nextGenerationMatrix = new int[x][y];

        try {
            navigation();
            while ((menu = bufferedReader.readLine()) != null) {
                if (menu.equals("0")) {
                    break;
                }
                switch (menu) {
                    case "1" -> {
                        do {
                            try {
                                System.out.println("Enter size (x):  ");
                                x = Integer.parseInt(bufferedReader.readLine());
                                System.out.println("Enter size (y):  ");
                                y = Integer.parseInt(bufferedReader.readLine());
                            } catch (NumberFormatException ex) {
                                System.out.println("Invalid input.");
                            }
                        } while (x <= 0 || y <= 0);
                        System.out.println("New life game: ");
                        gameMatrix = randomizeLifeGame(x, y);
                        nextGenerationMatrix = new int[x][y];
                        break;
                    }
                    case "2" -> {
                        if (secondGeneration) {
                            nextGenerationMatrix = nextGeneration(gameMatrix, x, y);
                            secondGeneration = false;
                        } else {
                            nextGenerationMatrix = nextGeneration(nextGenerationMatrix, x, y);
                        }
                        System.out.println("Next generation: ");
                        for (int i = 0; i < x; i++) {
                            for (int j = 0; j < y; j++) {
                                System.out.print(nextGenerationMatrix[i][j] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    }
                }
                navigation();
            }

        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    public static int[][] randomizeLifeGame(int mSize, int nSize) {
        Random random = new Random();
        int[][] lifeMatrix = new int[mSize][nSize];
        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < nSize; j++) {
                lifeMatrix[i][j] = random.nextInt(2);
                System.out.print(lifeMatrix[i][j] + " ");
            }
            System.out.println();
        }
        secondGeneration = true;
        return lifeMatrix;
    }

    private static void navigation() {
        System.out.println("1 - New game [x / y]");
        System.out.println("2 - Next generation");
        System.out.println("0 - Exit");
    }

    public static int[][] nextGeneration(int[][] generationMatrix, int mSize, int nSize) {
        int[][] nextGenerationMatrix = new int[mSize][nSize];

        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < nSize; j++) {
                if (liveNeighbours(generationMatrix, i, j, mSize, nSize) < 2 && generationMatrix[i][j] == 1)
                    nextGenerationMatrix[i][j] = 0;
                if ((liveNeighbours(generationMatrix, i, j, mSize, nSize) == 2 || liveNeighbours(generationMatrix, i, j, mSize, nSize) == 3) && generationMatrix[i][j] == 1)
                    nextGenerationMatrix[i][j] = 1;
                if (liveNeighbours(generationMatrix, i, j, mSize, nSize) > 3 && generationMatrix[i][j] == 1)
                    nextGenerationMatrix[i][j] = 0;
                if (liveNeighbours(generationMatrix, i, j, mSize, nSize) == 3 && generationMatrix[i][j] == 0)
                    nextGenerationMatrix[i][j] = 1;
            }
        }
        return nextGenerationMatrix;
    }

    public static int liveNeighbours(int[][] board, int i, int j, int m, int n) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
