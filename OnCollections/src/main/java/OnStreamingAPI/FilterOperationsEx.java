package OnStreamingAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterOperationsEx {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String numbers = "10,22,3,4,5,6,7,8,16,17,18,27,36,45,40,15,11,16,17,18,27,36,45,40,15,57,11,18,9,90,11,12,13,14,15,16,17,18,27,36,45,40,15,11";

        for (String no : numbers.split(",")) {
            list.add(Integer.valueOf(no));
        }

        List<Integer> evenNumbers = list.stream().filter(no -> no % 2 == 0 && no % 9 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);
        System.out.println(" How May Odd Numbers " + list.stream().filter(e -> e % 2 == 1).count());

        System.out.println(" anyMatch " + list.stream().anyMatch(e -> e == 11));
        Optional<Integer> value = list.stream().filter(e -> e % 19 == 0).findFirst();

        if (value.isPresent()) {
            System.out.println(" findFirst " + value.get());
        }
        System.out.println(" findAny " + list.stream().filter(e -> e % 9 == 0).findAny());
        System.out.println(" allMatch " + list.stream().allMatch(e -> e % 1 == 0));
        System.out.println(" noneMath " + list.stream().noneMatch(e -> e % 199 == 0));

        System.out.println("Before Sort " + list);
        System.out.println("sorted " + list.stream().sorted().collect(Collectors.toList()));

        System.out.println("distinct() " + list.stream().distinct().count() + "  Actual Size " + list.size());


        //dropWhile() drops the data till the condition matches
        String dropWhileData = "16,24,40,56,14,32,8,40,48,56";
        System.out.println("dropWhile() " +
                Arrays.stream(dropWhileData.split(","))
                        .dropWhile(e -> Integer.valueOf(e) % 8 == 0).collect(Collectors.toList()));

        //takeWhile() takes the data till the condition matches
        String takeWhileData = "16,24,40,56,14,32,8,40,48,56";
        System.out.println("takeWhile() " +
                Arrays.stream(takeWhileData.split(","))
                        .takeWhile(e -> Integer.valueOf(e) % 8 == 0).collect(Collectors.toList()));

        System.out.println("Max " + list.stream().max(Integer::compareTo).get());
        System.out.println("Min " + list.stream().min(Integer::compareTo).get());

        System.out.println("Limit " + list.stream().limit(3).collect(Collectors.toList()));
    }
}
