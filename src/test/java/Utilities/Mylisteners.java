package Utilities;



import org.testng.ITestListener;
import org.testng.ITestResult;

public class Mylisteners implements ITestListener {

    private static final int MAX_RETRY_COUNT = 3;
    private int retryCount = 0;

    @Override
    public void onTestFailure(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            result.setStatus(ITestResult.SKIP);
        } else {
            result.setStatus(ITestResult.FAILURE);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Reset retry count on test start
        retryCount = 0;
    }
}

    // ... other methods of ITestListener ...