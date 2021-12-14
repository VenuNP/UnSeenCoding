import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class StringMethodsTest {

    static Logger log = Logger.getLogger(StringComparisonTest.class.getName());
    StringMethods ref = null;
    public StringMethodsTest()
    {
        ref = new StringMethods();
    }


         @Test
    public void testLengthForNullString() {
            Assert.assertTrue(ref.length(null) == 0);
        }

    @Test
    public void testLengthForEmptyString() {
        Assert.assertTrue(ref.length("") == 0);
    }

    @Test
    public void testLength()
    {
        Assert.assertTrue(ref.length("Hi") == 2);
    }

    @Test
    public void testGetChar()
    {
        String s = "Hi";
        char output = ref.getChar(s,1);
        Assert.assertEquals('i',output);
    }

    @Test
    public void testGetCharForArrayIndexOutOfBoundsException()
    {
        String s = "Hi";
        boolean flag = false;
        try
        {
            ref.getChar(s,2);
        }catch (StringIndexOutOfBoundsException exception)
        {
            flag = true;
        }

        Assert.assertTrue(flag);
    }




}
