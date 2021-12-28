package OnList;

import java.util.LinkedList;
import java.util.List;

public class SearchingInList {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        numbers.add(11);
        numbers.add(12);
        numbers.add(1);
        numbers.add(7);
        numbers.add(6);
        numbers.add(17);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(11);
        numbers.add(19);
        numbers.add(99);
        numbers.add(20);

        System.out.println("99 " + numbers.contains(99));
        System.out.println("199 " + numbers.contains(199));


    }
}
