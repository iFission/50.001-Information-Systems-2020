import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterator1 {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);

		int sum = generate(intList);
		System.out.println(sum);
	}

	public static int generate(List<Integer> intList) {
		int sum = 0;
		Iterator<Integer> intLisIterator = intList.iterator();
		while (intLisIterator.hasNext()) {
			sum += intLisIterator.next();
		}
		return sum;

	}
}