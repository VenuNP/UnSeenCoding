public class PrimitiveTypeHashCodes {
    public static void main(String[] args) {

    Integer a = Integer.valueOf(12);
    Integer b = Integer.valueOf(15);
    Integer c = Integer.valueOf(12);

    System.out.println(a.hashCode() +" :: "+b.hashCode());



    }
}

