package constants;

import utils.CommonUtils;

	public class FileConstants {

		public static final String ROOT_PATH = System.getProperty("user.dir");
		public static final String LOGIN_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/login.properties";
		public static final String HOME_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/homepage.properties";
		public static final String SCREENSHOT_PATH = ROOT_PATH + "/src/main/resources/reports/" + CommonUtils.getTimeStamp()
				+ ".PNG";
		public static final String TEST_FILE_UPLOAD_PATH = "/Users/user/Desktop/CSS.png";
		public static final String REPORT_PATH = ROOT_PATH + "/src/main/resources/reports/" + CommonUtils.getTimeStamp()
				+ ".html";

}
