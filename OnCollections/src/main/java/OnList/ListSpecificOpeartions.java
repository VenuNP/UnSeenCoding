package OnList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListSpecificOpeartions {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        System.out.println("Before *** " + numbers);
        numbers.set(8, 99); // O(1)
        numbers.add(3, 44); // O(n) add data on specific Index
        System.out.println("After *** " + numbers);

        System.out.println("Sub List" + numbers.subList(0, 5));

        ListIterator<Integer> listIterator = numbers.listIterator();
        System.out.println("~~~ Forward ");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("~~~ Backward ");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

    }
}
