package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FileConstants;

public class ReportManager {
	

	private static ExtentReports report;
	
	public static ExtentReports getInstance() {
		if(report == null) {
			ReportManager.createInstance();
		}
		return report;
	}
	
	private static ExtentReports createInstance() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FileConstants.REPORT_PATH);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("SFDC");
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		return report;
	}

}
