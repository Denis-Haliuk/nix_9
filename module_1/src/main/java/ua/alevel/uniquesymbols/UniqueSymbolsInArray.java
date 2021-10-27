package ua.alevel.uniquesymbols;

public class UniqueSymbolsInArray {
    public static void printUniqueSymbolsInArray() {
        int[] numArray = {1, 4, 5, 1, 1, 3};

        for (int number : numArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        int unique = 0;
        for (int i = 0; i <
                numArray.length; i++) {
            boolean isUnique = true;
            for (int j = i + 1; j < numArray.length; j++) {
                isUnique = isUnique && (numArray[i] != numArray[j]);
            }
            if (isUnique) unique++;
        }
        System.out.println("unique = " + unique);
    }
}
