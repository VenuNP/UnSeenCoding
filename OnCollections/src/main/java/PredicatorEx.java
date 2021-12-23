import java.util.function.Predicate;

public class PredicatorEx {

    public static void main(String[] args) {

        Sample s = new Sample();
       System.out.println( s.isEqual((a) ->
               {
                 System.out.println(" a [ "+a + " ]");
                   return a == 5;
               }
                ));
    }


}


class Sample
{
    public boolean isEqual(Predicate<Integer> predicate)
    {
        return predicate.test(3);
    }
}