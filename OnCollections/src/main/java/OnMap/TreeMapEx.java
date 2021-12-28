package OnMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();

        map.put(100, "Srinu Np");
        map.put(40, "Akash ");
        map.put(10, "Srinu");
        map.put(20, "Venu");
        map.put(30, "Sai Kalyan");
        map.put(10, "Srinu Np");
        map.put(30, "Sai Kalyan Siri Konda");


        System.out.println(" ~~~ Iteration through keySet");
        Set<Integer> keys = map.keySet();
        keys.stream().forEach(key -> System.out.println(key + " : " + map.get(key)));

        System.out.println(" ~~~ Iteration through Map.Entry Set");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.stream().forEach(me -> System.out.println(me.getKey() + " :: " + me.getValue()));
    }
}
