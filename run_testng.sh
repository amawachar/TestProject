#!/bin/bash
# Shell script to run TestNG XML file using Maven

# Navigate to your project directory (change to your project folder path)
cd /home/apmosys/eclipse-workspace/TestProject


java -cp "bin:lib/*" org.testng.TestNG testng.xml


