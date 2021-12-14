public class ImmutableApp {

    public static void main(String[] args)  throws  CloneNotSupportedException{
        Address addr = new Address("Hyd");
        Person person = new Person("Srinu",addr);

        System.out.println("[Before Update Person = "+person+"]");

        person.getAddress().setCity("VYD");
        System.out.println("[After Update Person = "+person+"]");

    }
}
