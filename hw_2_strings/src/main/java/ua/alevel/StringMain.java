package ua.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringMain {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string: ");
        String input = bufferedReader.readLine();

        StringHelperUtil.reverse(input, true);

        System.out.println("input = " + input);
    }
}
