package test;

import org.testng.Reporter;

public class BaseClass {
	public void driverwait(int timeToWaitInSec) throws InterruptedException {
		Reporter.log("waiting for " + timeToWaitInSec + " seconds...");
		Thread.sleep(timeToWaitInSec * 4000);
	}

}
