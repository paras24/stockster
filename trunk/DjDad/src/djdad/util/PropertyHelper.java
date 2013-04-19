package djdad.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class PropertyHelper {

	private static Properties queryProperties = null;
	private static final Logger LOGGER = Logger.getLogger(PropertyHelper.class);
	static {
		InputStream inputStream = null;
		queryProperties = new Properties();
		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			inputStream = classLoader.getResourceAsStream("Queries.properties");
			queryProperties.load(inputStream);
		} catch (SecurityException e) {
			LOGGER.error("error occurrrred in loading properties"
					+ e.getMessage());
		} catch (IOException e) {
			LOGGER.error("error occurrrred in loading properties"
					+ e.getMessage());
		}
	}

	/**
	 * This method fetches the query from the property file and then returns it
	 * as a string.
	 * 
	 * @param propertyName
	 * @return String
	 */
	public static String getProperty(String propertyName) {
		if (queryProperties != null) {
			return queryProperties.getProperty(propertyName);
		}
		return null;
	}
}
