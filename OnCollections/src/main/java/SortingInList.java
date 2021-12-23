import java.util.*;

public class SortingInList {
    public static void main(String[] args) {
        List<Integer> numbers =new LinkedList<>();
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
        System.out.println(numbers);
        Collections.sort(numbers); // nlog(n)
        System.out.println(numbers);


    }
}
