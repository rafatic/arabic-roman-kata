package com.main;

import com.test.RomanStringBuilderTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * Created by raphael on 12/01/2018.
 *
 * Main class to use as startup class
 */

public class Main {

    public static void main(String[] args)
    {
        // Runs the test
        Result testResult = JUnitCore.runClasses(RomanStringBuilderTest.class);


        for(Failure failure : testResult.getFailures())
        {
            System.out.println(failure.toString());
        }

        System.out.println(testResult.wasSuccessful());
    }
}
