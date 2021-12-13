import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// debug -> info -> warn -> error -> fatal
public class ImmutabilityTest {

   static Logger log = Logger.getLogger(ImmutabilityTest.class.getName());
    Immutability ref = null;
    String sinput ="";
    StringBuffer sbinput = null;

    public  ImmutabilityTest()
    {
        ref = new Immutability();
    }

    @BeforeEach
    public void before()
    {
        sinput = "Hi";
        sbinput = new StringBuffer("Hi");
        log.info("before() invoked [ String :: "+sinput+"]");
        log.info("before() invoked [ StringBuffer ::"+sbinput+"]");
    }


    @Test
    public void testImmutabilityForString()
    {
        log.info("testImmutabilityForString Started ****");
        boolean output = ref.isImmutable(sinput);
        Assert.assertTrue("Expected True but Return False" , output);
        log.info(" testImmutabilityForString Completed ****");

    }

    @Test
    public void testImmutabilityForStringBuffer()
    {
        log.info("testImmutabilityForStringBuffer Started ****");

        boolean output = ref.isImmutable(sbinput);
        Assert.assertFalse("Expected False but Return True" , output);

        log.info("testImmutabilityForStringBuffer completed ****");


    }

    @AfterEach
    public void after()
    {
        log.info("after() invoked [ String :: "+sinput+"]");
        log.info("after() invoked [ StringBuffer ::"+sbinput+"]");
    }

}
