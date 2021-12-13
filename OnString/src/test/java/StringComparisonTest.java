import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// debug -> info -> warn -> error -> fatal
public class StringComparisonTest {

   static Logger log = Logger.getLogger(StringComparisonTest.class.getName());
   StringComparison ref = null;
    public StringComparisonTest()
    {
        ref = new StringComparison();
    }

    @BeforeAll
    public static void init()
    {
        log.info(" From init() :: Junit Started");
    }

    @Test
    public void testAddressComparison1()
    {
        Assert.assertTrue(ref.addressComparison1());
    }

    @Test
    public void testAddressComparison2()
    {
        Assert.assertFalse(ref.addressComparison2());
    }


    @Test
    public void contentComparison1()
    {
        Assert.assertTrue(ref.contentComparison1());
    }


    @Test
    public void contentComparison2()
    {
        Assert.assertTrue(ref.contentComparison2());
    }@Test
    public void contentComparison3()
    {
        Assert.assertTrue(ref.contentComparison3());
    }@Test
    public void contentComparison4()
    {
        Assert.assertTrue(ref.contentComparison4());
    }



    @AfterAll
    public static void destroy()
    {
        log.info(" From destroy() :: Junit Ended");
    }




}
