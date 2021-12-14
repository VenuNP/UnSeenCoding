public class StringMethods {
    public int length(String s)
    {
        return isEmpty(s) ? 0 : s.length();
    }

    public  char getChar(String s , int index)
    {
       return s.charAt(index);
    }

    public String charIn(String s, int startIndex, int endIndex)
    {
        if(startIndex > length(s))
        {
            return "";
        }
        return s.substring(startIndex,endIndex); // excludes endIndex, includes startIndex
    }

    public boolean isEmpty(String s)
    {
        return s == null ? false :s.isEmpty();
    }

    public boolean isEqualIgnoreCase(String s1, String s2)
    {
        if(isEmpty(s1) || isEmpty(s2))
        {
            return false;
        }
        return s1.toLowerCase().equals(s2.toLowerCase());
    }

    public boolean isContentEquals(String s1, String s2)
    {
        if(isEmpty(s1) || isEmpty(s2))
        {
            return false;
        }
        return s1.equals(s2);
    }

    public boolean canUseOfTrim(String s)
    {
        return isEmpty(s) ? false : s.trim().length() != s.length() ? true : false;
    }

    public boolean isStartWithAndEndsWith(String s ,String prefix, String suffix)
    {

        return isEmpty(s) ? false : s.startsWith(prefix) && s.endsWith(suffix);
    }

    // "10:20:30" => split(':') => {"10", "20", "30")
    public String[] split(String s , char c)
    {
        return s.indexOf(c) == -1 ?  new String[]{s} : s.split(String.valueOf(c));
    }

    // replace ("Hi  Sai", 'S' , 'R') => "Hi Rai"
    public String replace(String s , char c1, char c2)
    {

        return isEmpty(s) ? s : s.replace(c1,c2);
    }

    // replace ("Hi  Sai", "Sai" , "Rishitha") => "Hi Rishitha"
    public String replaceAll(String s , String c1, String c2)
    {
        return isEmpty(s) ? s : s.replace(c1,c2);
    }

    //  contains("Hi  Sai", "Sai" ,) => "true"
    public boolean contains(String s , String v)
    {
        return isEmpty(s) ? false : s.contains(v);
    }

    //  contains("Hi  Sai", "Sai" ,) => "true"
    public boolean intern()
    {

        String s1 = new String("Hi"); // "Hi in Heap"
        s1.intern(); // "Hi moved to StringConstantPool"
        String s2 = "Hi";
        return s1 == s2; // true
    }

    // Welcome Sai Kalyan
    //a is not unique ? a:3
    //S is unique ? S:1
    public boolean isCharUnique(String s, char c)
    {

        return isEmpty(s) ? false : s.indexOf(c) == s.lastIndexOf(c);
    }

    // "Hi" => HiHiHi
    public String repeat(String s, int count)
    {
       return s.repeat(3);
    }

    public static void main(String[] args) {
        StringMethods sm = new StringMethods();
        System.out.println(sm.repeat("Hi",3));
    }
}
