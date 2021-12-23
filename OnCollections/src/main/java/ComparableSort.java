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
import java.util.List;

public class ComparableSort {
    public static void main(String[] args) throws Exception {

        List<Person> personList = new ArrayList<>();
        FileReader fin = new FileReader("Persons.csv");
        BufferedReader reader = new BufferedReader(fin);
        String person = "";
        while ((person = reader.readLine()) != null) {
            String[] p = person.split(",");

            personList.add(
                    Person.builder()
                            .personId(Integer.valueOf(p[0]))
                            .peronName(p[1])
                            .build()
            );

        }

        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));

        Collections.sort(personList);
        System.out.println(" ~~ After Sort with comparable ID !!!");
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));


    }
}


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
class Person implements Comparable<Person> {
    private Integer personId;
    private String peronName;


    @Override
    public int compareTo(Person person) {
        return this.personId.compareTo(person.getPersonId());
    }
}



