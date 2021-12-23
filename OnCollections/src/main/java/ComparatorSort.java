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

public class ComparatorSort {
    public static void main(String[] args) throws Exception {

        List<Person2> personList = new ArrayList<>();
        FileReader fin = new FileReader("Persons.csv");
        BufferedReader reader = new BufferedReader(fin);
        String person = "";
        while ((person = reader.readLine()) != null) {
            String[] p = person.split(",");

            personList.add(
                    Person2.builder()
                            .personId(Integer.valueOf(p[0]))
                            .peronName(p[1])
                            .build()
            );

        }

        System.out.println(" ~~~ Before Sort");
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));

        System.out.println(" ~~~  Sort On Name");
        Collections.sort(personList, (p1, p2) -> p1.getPeronName().compareTo(p2.getPeronName()));

        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));

        System.out.println(" ~~~  Sort On Id");
        Collections.sort(personList, (p1, p2) -> p1.getPersonId().compareTo(p2.getPersonId()));
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));


        System.out.println(" ~~~  Sort On Id & Name");
        Collections.sort(personList, (p1, p2) -> p1.getPersonId().
                compareTo(
                        p2.getPersonId().compareTo(p1.getPersonId().compareTo(p2.getPersonId()))
                ));
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));


    }
}


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
class Person2 {
    private Integer personId;
    private String peronName;
}



