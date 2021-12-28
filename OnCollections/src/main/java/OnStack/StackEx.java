package OnStack;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(5);
        stack.push(30);
        stack.push(40);
        stack.push(50); // O(1)

        System.out.println(" Top :: " + stack.peek()); // O(1)
        System.out.println(" pop :: " + stack.pop()); // O(1)
        System.out.println(" Top :: " + stack.peek());

        System.out.println("Elements in Stack are !!!!");
        stack.stream().forEach(System.out::println); // O(n)


    }
}
