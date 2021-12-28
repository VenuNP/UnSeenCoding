package OnList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
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
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(null);
        System.out.println(" numbers " + numbers);
        System.out.println(" Size :: " + numbers.size()); // O(1)
        System.out.println(" isEmpty :: " + numbers.isEmpty()); // O(1)
        System.out.println(" contains(9) :: " + numbers.contains(9)); // O(n)
        System.out.println(" remove(8) :: " + numbers.remove(8)); // O(n) removes value 9 as the index number 8
        System.out.println(" contains(9) :: " + numbers.contains(9)); // O(n)
        System.out.println(" removeIf(3) :: " + numbers.removeIf((e) -> e != null && e == 3)); //O(n) removeIf element 3 present in the collection.

        List<Integer> primes = new LinkedList<>();
        primes.add(2);
        primes.add(5);
        primes.add(7);
        primes.add(11);

        System.out.println("primes " + primes);
        System.out.println("Before allAll(primes) " + numbers);

        numbers.addAll(primes); // O(primes.size())

        System.out.println("After allAll(primes) " + numbers);

        numbers.removeAll(primes); // O(primes.size() * numbers.size()) O(mn)

        System.out.println("After removeAll(primes) " + numbers);

        System.out.println(" \n ~ Load Elements through Iterator !!!");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(" \n ~ Load Elements through enhanced For Loop !!!");
        for (Integer element : numbers) {
            System.out.println(element);
        }

        System.out.println(" \n ~ Load Elements through Streaming API ");

        numbers.stream().forEach(e -> System.out.println(e));

        System.out.println(" \n ~ Load Elements through Streaming API 2 :: Method Reference");
        numbers.stream().forEach(System.out::println);
    }
}
