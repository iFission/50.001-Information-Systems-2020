import java.util.ArrayList;

// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit the Main.java file 

// Title: Fibonacci Numbers Generator
// [5 points] Write a JAVA program that print out the first N (N>2) numbers in the fibonacci sequence, in this format:
//   0,1,1,2,3,5,...
// When submitting, return these numbers in this format as a string, instead of printing.

public class Fibonacci {

    public static String fibonacci(int n) {
        ArrayList<Integer> out_ls = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            System.out.println(out_ls.size());
            if (out_ls.size() < 2) {
                out_ls.add(i);
            } else {
                out_ls.add(out_ls.get(i - 1) + out_ls.get(i - 2));
            }
        }
        String outString = out_ls.toString();
        return outString.substring(1, outString.length() - 1).replaceAll("\\s", "");
    }

    // public static String fibonacci(int n) {
    // int int1 = 0;
    // int int2 = 1;
    // String outString = "";
    // for (int i = 0; i < n; i++) {
    // outString += Integer.toString(int1) + ",";

    // int temp = int1 + int2;
    // int1 = int2;
    // int2 = temp;
    // }
    // return outString.substring(0, outString.length() - 1);
    // }

}