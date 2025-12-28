package com.example.demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestResultListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
        Reporter.log("Test started: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        Reporter.log("Test passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        Reporter.log("Test failed: " + result.getName());
        if (result.getThrowable() != null) {
            result.getThrowable().printStackTrace();
        }
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        Reporter.log("Test skipped: " + result.getName());
    }
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test partially failed: " + result.getName());
        Reporter.log("Test partially failed: " + result.getName());
    }
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
        Reporter.log("Test suite started: " + context.getName());
    }
    
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
        Reporter.log("Test suite finished: " + context.getName());
        System.out.println("Total tests: " + context.getAllTestMethods().length);
        System.out.println("Passed tests: " + context.getPassedTests().size());
        System.out.println("Failed tests: " + context.getFailedTests().size());
        System.out.println("Skipped tests: " + context.getSkippedTests().size());
    }
}