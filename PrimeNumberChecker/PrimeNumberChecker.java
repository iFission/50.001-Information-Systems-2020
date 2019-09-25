public class PrimeNumberChecker {

    public static void main(String[] args) {

        int[] intArray = { 4, 7, 14, 23, 99 };
        int[] resultArray2 = new int[intArray.length];
        int[] resultArray = { 0, 1, 0, 1, 0 };

        for (int i = 0; i < intArray.length; i++) {
            resultArray2[i] = checkPrime(intArray[i]);
        }

        for (int number : resultArray2) {

            System.out.println(number);
        }

    }

    public static int checkPrime(int number) {

        for (int dividend = 2; dividend < number - 1; dividend++) {
            int remainder = number % dividend;
            if (remainder == 0) {
                return 0;
            }
        }
        return 1;

    }
}