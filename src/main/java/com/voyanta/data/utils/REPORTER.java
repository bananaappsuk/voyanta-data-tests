package com.voyanta.data.utils;


import com.voyanta.data.utils.testReporter.testReporter;
import org.junit.Assert;


public class REPORTER {

    static testReporter Report;
    static String Iteration;

    public static void startReporter() {
        Report = new testReporter("SampleTest");
        Report.addNewIteration("test");
    }

    public static void setIteration(String Iteration)
    {
        Report.addNewIteration(Iteration);
        REPORTER.Iteration = Iteration;
    }
    public String getIteration()
    {
        return Iteration;
    }


    public static void equals(Object exp, Object act, String message) {

//        setIteration(Thread.currentThread().getStackTrace()[3].getMethodName());
        String testStepName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (exp.toString().equals(act.toString())) {
            Report.reportPass(testStepName, exp.toString(), act.toString(), message);
        } else {
            Report.reportFail(testStepName, exp.toString(), act.toString(), message);
            //	SystemLibrary.captureScreen(testcaseName);
        }
    }

    public static void isTrue(boolean value, String message) {
//        setIteration(Thread.currentThread().getStackTrace()[3].getMethodName());
        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (value) {
            Report.reportPass(testcaseName, String.valueOf(value), "true", message);
        } else {
            Report.reportFail(testcaseName, String.valueOf(value), "true", message);
            //SystemLibrary.captureScreen(testcaseName);
        }
    }
    public static void equalsAndExit(Object exp, Object act, String message)throws Exception{

//        setIteration(Thread.currentThread().getStackTrace()[3].getMethodName());
        String testStepName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (exp.toString().equals(act.toString())) {
            Report.reportPass(testStepName, exp.toString(), act.toString(), message);
        } else {
            Report.reportFailAndExitTest(testStepName, exp.toString(), act.toString(), message);
            //	SystemLibrary.captureScreen(testcaseName);
        }
    }

    public static void isTrueAndExit(boolean value, String message) throws Exception
    {
//        setIteration(Thread.currentThread().getStackTrace()[3].getMethodName());
        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (value) {
            Report.reportPass(testcaseName, String.valueOf(value), "true", message);
        } else {
            Report.reportFailAndExitTest(testcaseName, String.valueOf(value), "true", message);
            //SystemLibrary.captureScreen(testcaseName);
        }
    }

    public static void isTrue(boolean value) {
        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();

        if (value) {
            Report.reportPass(testcaseName, String.valueOf(value), "true", "");
        } else {
            Report.reportFail(testcaseName, String.valueOf(value), "true", "");
            //SystemLibrary.captureScreen(testcaseName);
        }
    }

    public static void pass(String message) {
        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Report.reportPass(testcaseName, "", "", message);

    }

//    public static void fail(String message) {
//        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
//        Report.reportFail(testcaseName, "", "", message);
//        SystemLibrary.captureScreen(testcaseName);
//    }
//
//    public static void failAndExit(String message) throws Exception
//    {
//        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
//        Report.reportFailAndExitTest(testcaseName, "", "", message);
//        SystemLibrary.captureScreen(testcaseName);
//    }

    public static void equals(Object exp, Object act) {

        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (exp.toString().equals(act.toString())) {
            Report.reportPass(testcaseName, exp.toString(), act.toString(), "");
        } else {
            Report.reportFail(testcaseName, exp.toString(), act.toString(), "");
            
        }
    }

    public static void warning(String message) {
        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Report.reportInfo(testcaseName + message);
    }

    public static void Log(String message) {
        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Report.reportInfo(testcaseName + message);
    }

    public static void Exception(String message) {
        String testcaseName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Report.reportInfo(testcaseName + message);
        Assert.fail(message);
//        SystemLibrary.captureScreen(testcaseName);

    }

    public static void closeReports() {
        Report.stopReporter();
    }


}
