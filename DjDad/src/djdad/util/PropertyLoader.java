package djdad.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	
	public static String get(String tag) {
		
		//InputStream in = this.getClass().getResourceAsStream("");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("/djdad/util/djdadprops.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(tag);
		
		
	} 
	
	public static void main(String[] args) {
		System.out.println(PropertyLoader.get("dbuser"));
	}
	

}
