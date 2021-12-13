public class StringComparison {

    public boolean addressComparison1()
    {
        String s1 = "Hi";
        String s2 = "Hi";

        return s1 == s2;
    }

    public boolean addressComparison2()
    {
        String s1 = "Hi";
        String s2 = new String("Hi");

        return s1 == s2;
    }


    public boolean contentComparison1()
    {
        String s1 = "Hi";
        String s2 = "Hi";

        return s1 .equals( s2);
    }

    public boolean contentComparison2()
    {
        String s1 = "Hi";
        String s2 = new String("Hi");

        return s1.equals( s2);
    }

    public boolean contentComparison3()
    {
        String s1 = "Hi";
        String s2 = "Hi";

        return s1.compareTo( s2) == 0;
    }

    public boolean contentComparison4()
    {
        String s1 = "Hi";
        String s2 = new String("Hi");

        return s1.compareTo( s2) == 0;
    }

    public static void main(String[] args) {
        StringComparison sc = new StringComparison();
        System.out.println(sc.addressComparison1());
        System.out.println(sc.addressComparison2());
        System.out.println(sc.contentComparison1());
        System.out.println(sc.contentComparison2());
        System.out.println(sc.contentComparison3());
        System.out.println(sc.contentComparison4());


    }
}
