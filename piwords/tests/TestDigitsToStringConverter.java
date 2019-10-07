// package piwords;

/**
 * TestDigitsToStringConverter
 */
public class TestDigitsToStringConverter {
    public static void main(String[] args) {
        int[] digits = { 3, 17, 18, 16, 4 };
        int baseA = 26;
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        String output = DigitsToStringConverter.convertDigitsToString(digits, baseA, alphabet);
        System.out.println(output);

        int[] digits2 = { 3, 17, 18, 16, 11, 14, 10, 25 };
        int baseA2 = 26;
        char[] alphabet2 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        String output2 = DigitsToStringConverter.convertDigitsToString(digits2, baseA2, alphabet2);
        System.out.println(output2);

    }
}