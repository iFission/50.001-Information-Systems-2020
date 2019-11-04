import java.util.*;

public class Permutation {
    public String in;
    private ArrayList<String> a = new ArrayList<String>();
    public int index_start;

    Permutation(String str) {
        in = str;
        index_start = 0;
    }

    public String swap(String in_str, int i, int j) {
        char temp;
        char[] charArray = in_str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public void permute() {
        int length = in.length();
        int index_end = length - 1;

        if (index_start == index_end) {
            a.add(in);
        }

        else {
            for (int i = index_start; i <= index_end; i++) {

                in = swap(in, index_start, i);
                index_start += 1;
                permute();
                index_start -= 1;
                in = swap(in, index_start, i);
                if (a.contains(in)) {
                    continue;
                }
                a.add(in);

            }
        }

    }

    public ArrayList<String> getA() {
        return a;
    }
}