import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        System.out.println("20221011 지성빈 배열");
        byte var0 = 1;
        Iterable range = (Iterable)(new IntRange(var0, 30));
        Collection destination = (Collection)(new ArrayList());
        Iterator iterator = range.iterator();

        while(iterator.hasNext()) {
            Object next = iterator.next();
            int p1 = ((Number)next).intValue();
            if (checkPrime(p1)) {
                destination.add(next);
            }
        }

        range = (Iterable)((List)destination);
        Iterator var2 = range.iterator();

        while(var2.hasNext()) {
            Object next = var2.next();
            int p1 = ((Number)next).intValue();
            System.out.println(p1);
        }
    }

    private static final boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            boolean flag = true;
            double var3 = (double) n;
            int root = (int) Math.sqrt(var3);
            byte var6 = 3;
            IntProgression step = RangesKt.step((IntProgression) (new IntRange(var6, root)), 2);
            int i = step.getFirst();
            int var4 = step.getLast();
            int var5 = step.getStep();
            if (var5 >= 0) {
                if (i > var4) {
                    return flag;
                }
            } else if (i < var4) {
                return flag;
            }

            while (true) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }

                if (i == var4) {
                    break;
                }

                i += var5;
            }

            return flag;
        }
    }
}