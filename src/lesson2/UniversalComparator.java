package lesson2;

import java.time.LocalTime;
import java.util.Comparator;

public class UniversalComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1.getClass().getName().equals("java.lang.Integer"))
            return Integer.compare((Integer) o1, (Integer) o2);
        else if (o1.getClass().getName().equals("java.lang.Double"))
            return Double.compare((Double) o1, (Double) o2);
        else if (o1.getClass().getName().equals("java.lang.Float"))
            return Float.compare((Float) o1, (Float) o2);
        else if (o1.getClass().getName().equals("java.lang.Character"))
            return Character.compare((Character) o1, (Character) o2);
        else if (o1.getClass().getName().equals("java.lang.Long"))
            return Long.compare((Long) o1, (Long) o2);
        else
            return 0;
    }

}
