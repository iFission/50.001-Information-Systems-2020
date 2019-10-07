// package piwords;

import java.util.HashMap;
import java.util.Map;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * 
     * This method will try to weight each character of the alphabet proportional to
     * their occurrence in words in a training set.
     * 
     * This method should do the following to generate an alphabet: 1. Count the
     * occurrence of each character a-z in trainingData. 2. Compute the probability
     * of each character a-z by taking (occurrence / total_num_characters). 3. The
     * output generated in step (2) is a PDF of the characters in the training set.
     * Convert this PDF into a CDF for each character. 4. Multiply the CDF value of
     * each character by the base we are converting into. 5. For each index 0 <= i <
     * base, output[i] = (the first character whose CDF * base is > i)
     * 
     * A concrete example: 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     * "ccccc..." (198 "c"s)}, base = 93 1. Count(a) = 302, Count(b) = 500, Count(c)
     * = 198 2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5, Pr(c) = 198 /
     * 1000 = .198 3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1 4. CDF(a) * base =
     * 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93 5. Output = {"a", "a", ...
     * (29 As, indexes 0-28), "b", "b", ... (46 Bs, indexes 29-74), "c", "c", ...
     * (18 Cs, indexes 75-92)}
     * 
     * The letters should occur in lexicographically ascending order in the returned
     * array. - {"a", "b", "c", "c", "d"} is a valid output. - {"b", "c", "c", "d",
     * "a"} is not.
     * 
     * If base >= 0, the returned array should have length equal to the size of the
     * base.
     * 
     * If base < 0, return null.
     * 
     * If a String of trainingData has any characters outside the range a-z, ignore
     * those characters and continue.
     * 
     * @param base         A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the digit
     *         should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {
        // error checking
        if (base < 0) {
            return null;
        }

        String trainingDataString = String.join("", trainingData);

        // remove characters outside a-z
        String string = new String();
        for (char chr : trainingDataString.toCharArray()) {
            if (new String(BASIC_ALPHABET).indexOf(chr) != -1) {
                string += chr;
            }
        }

        int totalNumCharacters = string.length();

        if (DEBUG) {
            System.out.println(trainingData);
        }
        if (DEBUG) {
            System.out.println(totalNumCharacters);
        }
        if (DEBUG) {
            System.out.println(string);
        }

        // count occurrence for all chars
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character chr : BASIC_ALPHABET) {
            charMap.put(chr, countOccurrence(string, chr));
        }

        // count probability
        Map<Character, Float> charProbability = new HashMap<Character, Float>();
        for (char chr : BASIC_ALPHABET) {
            charProbability.put(chr, (float) charMap.get(chr) / totalNumCharacters);
        }

        // calculate combined probability, multiply by base
        float runningSum = 0;
        for (int i = 0; i < BASIC_ALPHABET.length; i++) {
            if (i == 0) {
                runningSum += charProbability.get(BASIC_ALPHABET[i]);
                charProbability.put(BASIC_ALPHABET[i], runningSum * base);
            } else if (charProbability.get(BASIC_ALPHABET[i]) != 0.0) {
                runningSum += charProbability.get(BASIC_ALPHABET[i]);
                charProbability.put(BASIC_ALPHABET[i], runningSum * base);
            }
        }

        if (DEBUG) {
            System.out.println(charProbability);
        }

        char[] output = new char[base];
        int cur = 0;
        for (Map.Entry<Character, Float> entry : charProbability.entrySet()) {
            Character key = entry.getKey();
            float value = entry.getValue();

            while (cur < (int) value) {
                output[cur] = key;
                cur += 1;
            }
        }
        return output;
    }

    private static int countOccurrence(String string, char chr) {
        int count = 0;
        for (char stringChr : string.toCharArray()) {
            if (stringChr == chr) {
                count += 1;
            }
        }
        return count;
    }

    private static final char[] BASIC_ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    private static final boolean DEBUG = true;

    public static void main(String[] args) {
        int base = 13;
        String[] trainingData = { "aaaaaaaaaaaaaaaaaaaaaaaau" };

        char[] output = generateFrequencyAlphabet(base, trainingData);
        if (DEBUG) {
            System.out.println(output);
            System.out.println(output.length == base);

        }

    }
}
