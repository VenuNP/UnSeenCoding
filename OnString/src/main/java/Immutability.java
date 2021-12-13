public class Immutability {

    // input : Hi
    //  input.concat(" Welcome")   : output = Hi Welcome
    //  input = "Hi"
    public boolean isImmutable(String input)
    {
        String output = input.concat(" Welcome");

        return  !input.equals(output);
    }


        // input : Hi
        //  input.append(" Welcome")
        //  input = "Hi Welcome"
        // output  = "Hi Welcome"
    public boolean isImmutable(StringBuffer input)
    {
        String output = input.append(" Welcome").toString();

        return  !input.toString().equals(output);
    }

    public static void main(String[] args) {

        Immutability ref = new Immutability();
        System.out.println(ref.isImmutable("Hi"));
        StringBuffer sb = new StringBuffer("Hi");
        System.out.println(ref.isImmutable(sb));


    }
}
