package OnStreamingAPI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


/*
11,Srinu,Hyd
8,Akash,USA
17,Sai Kalyan,Hyd LB-Nagar
5,Srinu NP,Hyderabad
1,Venu,Buddaram
2,Umesh,Chm
5,Srinu NP, Hyderabad
1,Venu NP,Khammam
3, Pranay, Chm
17,Sai Kalyan  Konda,KGM


Output :
Sort by Name,
Avoid duplicates based on ID -> should have latest data
Remove  users belongs to Chm

8,Akash,USA
17,Sai Kalyan Konda,KGM
5,Srinu NP, Hyderabad
1,Venu NP,Khammam

 */
public class UserOnCollectEx {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        Set<User> userSet = new LinkedHashSet<>();

        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] user = line.split(",");

            userSet.add(
                    User.builder()
                            .id(Integer.valueOf(user[0]))
                            .name(user[1])
                            .location(user[2]).build());
        }

        userSet.stream().forEach(System.out::println);

        Map<String, Set<User>> locationUsers = userSet.stream().
                collect(Collectors.groupingBy(User::getLocation, Collectors.toSet()));

        System.out.println(locationUsers);

        Map<Integer, String> idNameMap =
                userSet.stream().collect(Collectors.toMap(User::getId, User::getName));
        System.out.println(idNameMap);


        Map<Integer, User> idUserMap =
                userSet.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(idUserMap);

        Optional<User> user = userSet.stream().collect(
                Collectors.reducing(
                        (u1, u2) -> u1.getName().length() > u2.getName().length() ? u1 : u2)
        );
        if (user.isPresent()) {
            System.out.println(" Longest name User " + user.get());
        }

        userSet.stream().peek(u -> System.out.println(u.getName())).collect(Collectors.toList());

        userSet.stream().mapToInt(User::getId).forEach(System.out::println);
        System.out.println("skip(3)");
        userSet.stream().mapToInt(User::getId).skip(3).forEach(System.out::println);

        String message = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20";
        List<Integer> list = new LinkedList<>();
        for (String m : message.split(",")) {
            list.add(Integer.valueOf(m));
        }

        System.out.println("Sequential");
        list.stream().forEach(e -> System.out.println(Thread.currentThread().getName() + " :: " + e));


        System.out.println("Parallel ");
        list.parallelStream().forEach(e -> System.out.println(Thread.currentThread().getName() + " :: " + e));
        
    }
}

