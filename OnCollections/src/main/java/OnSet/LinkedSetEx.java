package OnSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedSetEx {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(10);
        set.add(12);
        set.add(21);
        set.add(22);
        set.add(20);
        set.add(21);
        set.add(22);
        set.add(13);
        set.add(14);
        set.add(15);
        set.add(20);


        set.forEach(System.out::println);


    }
}
