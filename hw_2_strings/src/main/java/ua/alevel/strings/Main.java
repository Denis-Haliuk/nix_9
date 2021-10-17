package ua.alevel.strings;

import ua.alevel.strings.reverse.Reverse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your string: ");
        String src = bufferedReader.readLine();
        System.out.println("src = " + src);

        Reverse reverse = new Reverse(src);



    }
}
