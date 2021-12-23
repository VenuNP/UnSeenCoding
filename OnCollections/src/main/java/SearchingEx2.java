import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SearchingEx2 {
    public static void main(String[] args) throws Exception {

        List<PersonSearch> personList = new ArrayList<>();
        FileReader fin = new FileReader("Persons.csv");
        BufferedReader reader = new BufferedReader(fin);
        String person = "";
        while ((person = reader.readLine()) != null) {
            String[] p = person.split(",");

            personList.add(
                    PersonSearch.builder()
                            .personId(Integer.valueOf(p[0]))
                            .peronName(p[1])
                            .build()
            );

        }

        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));

        PersonSearch personSearch = new PersonSearch(4, "Krithika");
        System.out.println(" isPresent " + personSearch + " == " + personList.contains(personSearch));

        personList.removeIf(p -> p.getPersonId() == 2);

        /*

        for(int i = 0 ; i< personList.size()  ; i++)
        {
            if(personList.get(i).getPersonId() == 2)
            {
                personList.remove(i);
            }
        }

        */
        personList.stream().forEach(p -> System.out.println(p.getPersonId() + " -> " + p.getPeronName()));


    }
}


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
class PersonSearch {
    private Integer personId;
    private String peronName;

    @Override
    public boolean equals(Object o) {

        PersonSearch personSearch = (PersonSearch) o;
        return this.personId.equals(personSearch.personId);
    }


}



