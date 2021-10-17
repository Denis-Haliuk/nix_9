package ua.alevel.strings.reverse;

public class Reverse {

    public static String reverse(String src) {
        Character[] srcToChar = new Character[src.length()];
        src.toCharArray();
        Character[] reversed = new Character[src.length()];
        int i = src.length();
        int j = 0;
        while(i >= 0){
            reversed[j] = srcToChar[i];
            i--;
            j++;
        }
        for (char c : reversed){
            System.out.print(c);
        }

        return reversed.toString();



    }

}
