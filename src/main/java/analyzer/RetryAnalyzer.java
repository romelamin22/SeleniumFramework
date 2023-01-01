package analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 3;//set as many retry as you want
    @Override
    public boolean retry(ITestResult iTestResult) {

        if (counter < retryLimit){

            counter++;

            return true;

        }else {

            return false;
        }

    }
}
