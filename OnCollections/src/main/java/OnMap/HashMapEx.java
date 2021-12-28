package OnMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "Srinu");
        map.put(20, "Venu");
        map.put(30, "Sai Kalyan");
        map.put(40, "Akash ");
        map.put(10, "Srinu Np");
        map.put(30, "Sai Kalyan Siri Konda");
        map.put(100, "Srinu Np");

        System.out.println(" ~~~ Iteration through keySet");
        Set<Integer> keys = map.keySet();
        keys.stream().forEach(key -> System.out.println(key + " : " + map.get(key)));

        System.out.println(" ~~~ Iteration through Map.Entry Set");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.stream().forEach(me -> System.out.println(me.getKey() + " :: " + me.getValue()));
    }
}
