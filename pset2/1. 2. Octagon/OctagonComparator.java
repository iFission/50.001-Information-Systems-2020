import java.util.Comparator;

public class OctagonComparator implements Comparator<Octagon> {
    @Override
    public int compare(Octagon ot, Octagon ot2) {
        if (ot.getSide() > ot2.getSide())
            return 1;
        else if (ot.getSide() == ot2.getSide())
            return 0;
        else
            return -1;
    }
}