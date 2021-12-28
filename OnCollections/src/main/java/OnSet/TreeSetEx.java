package OnSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(12);
        set.add(20);
        set.add(21);
        set.add(22);
        set.add(20);
        set.add(21);
        set.add(13);
        set.add(14);
        set.add(15);

        set.add(22);

        set.forEach(System.out::println);


    }
}
