package ua.alevel;

public class StringHelperUtil {

    private static String errorMessage = "substring not found";

    private StringHelperUtil() {
    }

    public static String reverse(String text) {

        char[] chars = text.toCharArray();
        int len = chars.length;

        for (int i = 0; i < (len / 2); i++) {
            char l = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = l;
        }
        text = String.valueOf(chars);
        return text;
    }

    public static String reverseBySubstring(String text, String substring) {
        boolean isFoundSubstring = false;
        char[] chars = text.toCharArray();
        int len = chars.length;
        char[] substringChar = substring.toCharArray();
        for (int i = 0; i < len - substring.length(); i++) {
            boolean isFound = true;
            for (int j = 0; j < substring.length(); j++) {
                if (chars[i + j] != substringChar[j]) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                int reversedLength = substring.length() / 2;
                for (int j = 0; j < reversedLength; j++) {
                    var temp = chars[i+j];
                    chars[i+j] = chars[i+substring.length()-j-1];
                    chars[i+substring.length()-j-1] = temp;
                }
                isFoundSubstring = true;
            }
        }

        return isFoundSubstring? String.valueOf(chars): errorMessage;
    }
}



