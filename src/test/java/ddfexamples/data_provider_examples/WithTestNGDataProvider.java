package ddfexamples.data_provider_examples;

import org.testng.annotations.Test;

public class WithTestNGDataProvider {

    @Test(dataProvider = "dataP", dataProviderClass = DPOne.class)
    public void test(String user, int pass){

        System.out.println(user + "     " + pass);

    }



}
