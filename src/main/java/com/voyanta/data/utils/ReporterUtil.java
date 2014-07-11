package com.voyanta.data.utils;



import org.apache.log4j.Logger;

public class ReporterUtil {

    private static Logger LOGGER = Logger.getLogger(ReporterUtil.class)   ;
	public static void ReportInfo(String message)
	{
		LOGGER.info("Action happening "+message);
        REPORTER.Log(message);

    }
	public static void ReportAssertCondition(boolean condition)
	{
		LOGGER.info("Verifying the condition");
        REPORTER.isTrue(condition);
	}
	public static void ReportAssertEquals(String expected, String actual)
	{
		LOGGER.info("Verifying the expected "+expected+" actual "+actual);
        REPORTER.equals(expected,actual);
	}
	public void ReportVerifyCondition(boolean condition)
	{
		LOGGER.info("Verifying the condition");
		REPORTER.isTrue(condition);
	}
	public void ReportVerifyEquals(String expected, String actual)
	{
		LOGGER.info("Verifying the expected "+expected+" actual "+actual);
		REPORTER.equals(expected,actual);
	}
}
