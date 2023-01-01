package analyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerTest {

    @Test
    public void testOne(){

        Assert.assertEquals(false, false);

    }

    @Test
    public void testTwo(){

        Assert.assertEquals(true, false);

    }

    @Test
    public void testThree(){

        Assert.assertEquals(false, false);

    }



}
