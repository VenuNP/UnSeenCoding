package OnStack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Stack;

public class MinStackEx {
    public static void main(String[] args) {
        Stack<ElementData> stack = new Stack<>();
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        String data = "11,13,14,20,6,14,12,10,4,5,19";
        for (String element : data.split(",")) {
            Integer e = Integer.valueOf(element);
            if (e < min) {
                min = e;
            } else if (e > max) {
                max = e;
            }

            if (max == Integer.MIN_VALUE) {
                max = e;
            }

            stack.push(ElementData.builder()
                    .min(min)
                    .max(max)
                    .data(e)
                    .build());
        }

        stack.stream().forEach(System.out::println);

        System.out.println("Min & Max " + stack.peek());
        System.out.println("POP " + stack.pop());
        System.out.println("Min & Max " + stack.peek());


    }

}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
class ElementData {
    private Integer data;
    private Integer min;
    private Integer max;
}
