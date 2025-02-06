package seleniumUtlis;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite/test is starting: " + context.getName());
		// You can use context to access suite/test details like context.getName(), etc.
	}

	// This method is called after all tests in the suite/test have finished
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite/test has finished: " + context.getName());
		System.out.println("Total tests run: " + context.getPassedTests().size());
		System.out.println("Total tests failed: " + context.getFailedTests().size());
		System.out.println("Total tests skipped: " + context.getSkippedTests().size());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
		System.out.println("Reason: " + result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test failed but within success percentage: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}

}
