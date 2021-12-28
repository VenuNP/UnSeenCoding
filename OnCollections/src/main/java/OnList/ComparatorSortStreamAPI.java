package OnList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSortStreamAPI {
    public static void main(String[] args) throws Exception {

        List<Person3> personList = new ArrayList<>();
        FileReader fin = new FileReader("Persons.csv");
        BufferedReader reader = new BufferedReader(fin);
        String person = "";
        while ((person = reader.readLine()) != null) {
            String[] p = person.split(",");

            personList.add(
                    Person3.builder()
                            .personId(Integer.valueOf(p[0]))
                            .peronName(p[1])
                            .build()
            );

        }

        System.out.println(" ~~~ Before Sort");
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));

        System.out.println(" ~~~  Sort On Name");
        Collections.sort(personList, Comparator.comparing(Person3::getPeronName));

        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));

        System.out.println(" ~~~  Sort On Id");
        Collections.sort(personList, Comparator.comparing(Person3::getPersonId));
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));


        System.out.println(" ~~~  Sort On Id & Name");
        Collections.sort(personList, Comparator.comparing(Person3::getPersonId).thenComparing(Person3::getPeronName));
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));


    }
}


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
class Person3 {
    private Integer personId;
    private String peronName;
}



