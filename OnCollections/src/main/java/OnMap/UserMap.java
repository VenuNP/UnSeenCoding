package OnMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
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
public class UserMap {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        Map<User, String> userMap = new LinkedHashMap();
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] user = line.split(",");

            userMap.put(
                    User.builder()
                            .id(Integer.valueOf(user[0]))
                            .name(user[1])
                            .location(user[2]).build(), "TG");
        }

        LinkedHashSet<User> usersSet = userMap
                .keySet()
                .stream()
                .filter(user -> !user.getLocation().equals("Chm"))
                .sorted(Comparator.comparing(User::getName)).collect(Collectors.toCollection(LinkedHashSet::new));

        usersSet.stream().forEach(user -> System.out.println(user + " ::-> " + userMap.get(user)));

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