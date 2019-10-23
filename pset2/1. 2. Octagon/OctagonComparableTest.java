import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class OctagonComparableTest {
    @Test
    public void testArrayOne() {
        ArrayList<Octagon> l = new ArrayList<Octagon>();
        l.add(new Octagon(2));
        l.add(new Octagon(3));
        l.add(new Octagon(1));
        Collections.sort(l);
        String output = new String();
        for (Octagon o : l) {
            output += o.getSide();
            output += " ";
        }
        String expected = "1.0 2.0 3.0 ";
        System.out.println(output);
        System.out.println(expected);
        assertEquals(output, expected);
    }
}