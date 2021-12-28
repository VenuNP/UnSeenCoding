package OnQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.add(20);
        queue.offer(30);
        queue.add(40);
        queue.offer(50);

        queue.stream().forEach(System.out::println);
        System.out.println("peek() " + queue.peek() + "::: element() ~ " + queue.element());//Idempotent
        System.out.println("poll() " + queue.poll() + ":::remove() ~ " + queue.remove()); // Non-Idempotent
        System.out.println("peek() " + queue.peek() + "::: element() ~ " + queue.element());//Idempotent


    }
}
