package booking.website.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ConfigurationProperties {

	static String filename = "config.properties";
	static Properties propInfo = new Properties();
	static InputStream fileStream = null;

	public static String getPropertyValueByKey(String inputkey) {
		String value = null;
		try {
			if (!inputkey.equals(null) && !inputkey.equals("")) {
				fileStream = new Object() {
				}.getClass().getClassLoader().getResourceAsStream(filename);
				if (fileStream == null) {
					throw new FileNotFoundException("Unable to find config file " + filename);
				}

				propInfo.load(fileStream);
				Enumeration<?> e = propInfo.propertyNames();
				if (!e.equals(null)) {
					while (e.hasMoreElements()) {
						String keyName = (String) e.nextElement();
						if (inputkey.equals(keyName)) {
							value = propInfo.getProperty(keyName);
							break;
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
