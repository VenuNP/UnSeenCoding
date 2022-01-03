package OnStreamingAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {

    public static void main(String[] args) {

        List<List<Integer>> allNumbers = new ArrayList<>();

        String even = "2,4,6,8,10";
        String odd = "1,3,5,7,9";
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        String[] evenArray = even.split(",");
        String[] oddArray = odd.split(",");

        for (int i = 0; i < 5; i++) {
            evenList.add(Integer.valueOf(evenArray[i]));
            oddList.add(Integer.valueOf(oddArray[i]));
        }

        allNumbers.add(evenList);
        allNumbers.add(oddList);

        System.out.println("[ allNumbers =  " + allNumbers + " ]");

        //[ [2,4],[1,3] ] => allNumbers.streams().[1,2] .flatMap(1 ->

        List<Integer> numbers = allNumbers.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(numbers);
        System.out.println("anyMatch with FlatMap " + allNumbers.stream().flatMap(List::stream).anyMatch(e -> e == 12));

    }
}
