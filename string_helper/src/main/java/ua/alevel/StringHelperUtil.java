package ua.alevel;

import java.util.Arrays;

public class StringHelperUtil {

    private StringHelperUtil() { }

    public static String reverse(String text, boolean fullString) {
        char[] chars = text.toCharArray();
        int len = chars.length;

        for (int i = 0; i < (len / 2); i++) {
            char l = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = l;
        }

        text = Arrays.toString(chars);
        return text;
    }

}
