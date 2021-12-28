package OnQueue;

import java.util.Deque;
import java.util.LinkedList;

public class DeQueueEx {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.addFirst(20);
        queue.addFirst(30);
        queue.addLast(40);
        queue.add(50); // equals addLast()

        queue.stream().forEach(System.out::println); // [Last] -> 50 -> 40 -> 10 -> 20 -> 30 [First]
        System.out.println("getFirst() " + queue.getFirst() + "::: getLast() ~ " + queue.getLast());//Idempotent
        System.out.println("removeFirst() " + queue.removeFirst() + "::: removeLast() ~ " + queue.removeLast());//Idempotent
        System.out.println("getFirst() " + queue.getFirst() + "::: getLast() ~ " + queue.getLast());//Idempotent

    }
}
