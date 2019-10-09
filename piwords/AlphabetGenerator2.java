// package piwords;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AlphabetGenerator2 {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * 
     * This method will try to weight each character of the alphabet proportional to
     * their occurren ce in words in a training set.
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

        if (base <= 0)
            return null;

        char[] output = new char[base];

        // Creating a map to map character to frequency of appearing
        Map<Character, Integer> freqMap = new TreeMap<Character, Integer>();

        int charCount = 0;

        for (String word : trainingData) {

            for (char ch : word.toCharArray()) {
                charCount++;
                if (freqMap.containsKey(ch))
                    freqMap.put(ch, freqMap.get(ch) + 1);
                else
                    freqMap.put(ch, 1);
            }
        }

        double cdf = 0.0;
        int output_index = 0;

        for (Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();

            double freq = (double) entry.getValue();
            double prob = freq / charCount;
            cdf = cdf + prob;
            if (cdf > 1.0)
                cdf = 1.0;
            double cdfh = cdf * base;
            System.out.println("ch =" + ch + ", cdf = " + cdfh);
            while (output_index < Math.ceil(cdfh)) {
                output[output_index] = ch;
                output_index++;
            }
        }

        // TODO: Implement (Problem f)
        return output;
    }

    private static final boolean DEBUG = true;

    public static void main(String[] args) {
        int base = 26;
        String[] trainingData = { "aaaaaaaaaaaaaaaaaaaaaaaau" };

        char[] output = generateFrequencyAlphabet(base, trainingData);
        if (DEBUG) {
            System.out.println(output);
            System.out.println(output.length == base);

        }

    }
}
