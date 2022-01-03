package OnStreamingAPI;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OnCollectEx {
    public static void main(String[] args) {
        String names = "Srinu,Venu,Akash,Sai,Srinu,Kiran,Ramu,Venu,Aaryan,Shanvi,Krithika,Shanvi,Siri, sIri";
        List<String> list = new LinkedList<>();
        for (String name : names.split(",")) {
            list.add(name);
        }

        Map<String, Long> map = list.stream().map(name -> name.trim().toUpperCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        Map<Boolean, List<String>> map2 = list.stream().collect(Collectors.partitioningBy(e -> e.startsWith("S")));

        System.out.println(map2);
    }
}
