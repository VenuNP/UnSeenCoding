package OnStreamingAPI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.CharBuffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
public class MapEx {
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

        Set<String> names = userSet.stream().map(user -> user.getName()).collect(Collectors.toSet());
        Set<String> locations = userSet.stream().map(User::getLocation).collect(Collectors.toSet());

        System.out.println(names + " ::\n " + locations);

        List<char[]> allChars = names.stream().map(n -> n.toCharArray()).collect(Collectors.toList());

        Set<Character> set = new LinkedHashSet<>();
        allChars.stream().flatMapToInt(chars -> CharBuffer.wrap(chars).chars()).forEach(e -> set.add(((char) e)));
        System.out.println(set);

        System.out.println("Max :: " + userSet.stream().mapToInt(User::getId).max().getAsInt());

    }
}


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
class User {
    private Integer id;
    private String name;
    private String location;


    @Override
    public boolean equals(Object o) {

        User user = (User) o;
        if (this.id.equals(user.getId())) {
            user.name = this.name;
            user.location = this.location;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}