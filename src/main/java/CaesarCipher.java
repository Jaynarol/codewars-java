import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/first-variation-on-caesar-cipher/java
 */
public class CaesarCipher {

    public static List<String> movingShift(String s, int shift) {
        final String cipher = caesar(s, shift, true);
        final int CipherLength = (int) Math.ceil(cipher.length() / 5.0);
        final int[] i = {0};

        return Arrays.stream(new String[5]).map(ignore -> {
            int beginIndex = i[0] * CipherLength;
            int endIndex = i[0]++ < 4 ? beginIndex + CipherLength : cipher.length();
            return cipher.substring(beginIndex, endIndex);
        }).collect(Collectors.toList());
    }

    public static String demovingShift(List<String> s, int shift) {
        return caesar(String.join("", s), shift, false);
    }

    private static String caesar(String plain, int shift, boolean encode) {
        final String eng = encode ? "abcdefghijklmnopqrstuvwxyz" : "zyxwvutsrqponmlkjihgfedcba";
        final int[] i = {shift};

        return Arrays.stream(plain.split("")).map(word -> {
            String myeng = Character.isLowerCase(word.charAt(0)) ? eng.toLowerCase() : eng.toUpperCase();
            if (myeng.contains(word)) {
                int indexNext = (i[0] + myeng.indexOf(word)) % myeng.length();
                word = String.valueOf(myeng.charAt(indexNext));
            }
            i[0]++;
            return word;
        }).collect(Collectors.joining(""));
    }

}
