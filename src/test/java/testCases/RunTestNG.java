package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RunTestNG {	
	public static void main(String[] args) {
		// Create an instance of TestNG
		TestNG testng = new TestNG();

		// Create a list to hold the path of the XML file
		List<String> suiteFiles = new ArrayList<>();

		// Add the path of your testng.xml file here
		suiteFiles.add("/home/apmosys/eclipse-workspace/TestProject/Sanity.xml");

		// Set the XML file for execution
		testng.setTestSuites(suiteFiles);

		// Execute the tests
		testng.run();
	}
}
