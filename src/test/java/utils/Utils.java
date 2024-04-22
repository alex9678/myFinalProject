package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

	public static String getValue(String key) {
		// Create a Properties object
		Properties prop = new Properties();

		// Get the file name
		String fileName = "./src/test/resources/data/settings.properties";

		// Load the properties file from the classpath
		try (InputStream inputStream = new FileInputStream(fileName)) {
		  if (inputStream != null) {
		    prop.load(inputStream);
		  } 
		} catch (IOException e) {
		  e.printStackTrace();
		}

		// Access the properties
		String value = prop.getProperty(key);
		return value;
	}
}


