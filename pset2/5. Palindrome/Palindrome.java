// Example outputs:
// abba is a palindrome.
// abdcba is not a palindrome.
// ZZaZZ is a palindrome.
// 124321 is a not palindrome.
// Note: No credit will be given for non-recursive code.

/**
 * Palindrome
 */
import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        System.err.println(Palindrome("1234321"));
    }

    public static String Palindrome(String inputString) {
        if (isPalindrome(inputString.toCharArray())) {
            return inputString + " is a palindrome.";
        } else {
            return inputString + " is not a palindrome.";

        }
    }

    public static boolean isPalindrome(char[] S) {
        if (S.length == 1 || S.length == 0) {
            return true;
        } else if (S[0] == S[S.length - 1]) {
            return isPalindrome(Arrays.copyOfRange(S, 1, S.length - 1));
        } else {
            return false;
        }
    }
}
