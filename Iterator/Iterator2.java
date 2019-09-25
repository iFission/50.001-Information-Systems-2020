import java.util.ArrayList;
import java.util.List;

public class Iterator2 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.add(9);
        intList.add(10);

        int sum = generate(intList);
        System.out.println(sum);
    }

    public static int generate(List<Integer> intList) {
        int sum = 0;
        for (int i = 0; i < intList.size(); i++) {
            sum += intList.get(i);
        }
        return sum;

    }
}