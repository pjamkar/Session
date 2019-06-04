package com.amboss.commonfunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// This class is to load the property file/s and read the property file values
public class ConfigProperties {

	private static Properties prop = new Properties();

	// This method is to load the property file
	public static void loadProperties() {
		try {
			prop.load(new FileInputStream("propertyFiles/config.properties"));
			System.out.println("Inside load property file method");
		} catch (FileNotFoundException e) {

			System.out.println("config.properties file not found");
		} catch (IOException e) {
			System.out.println("IO exception while accessing confif.properties file");
		}
	}

	// This method is to get the property value from properties file
	public static String getProperty(String keyValue) {
		return prop.getProperty(keyValue);

	}
}
