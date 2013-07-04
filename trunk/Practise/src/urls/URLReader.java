package urls;

import java.net.*;
import java.io.*;

public class URLReader {
	public static void main(String[] args) throws Exception {
		//readURLDirectly();
		readURLFromConnection();
	}


	/*call the URL's openStream() method to get a stream from which you can read the contents of the URL.
The openStream() method returns a java.io.InputStream object, so reading from a URL is as easy as
reading from an input stream.   */ 
	public static void readURLDirectly()throws MalformedURLException,IOException{

		URL url = new URL("http://www.oracle.com/");//create url object
		BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openStream())); // initiate input stream using url object

		String inputLine; //take input in input string object
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}

	/*rather than getting an input stream directly from the URL, this program explicitly 
retrieves a URLConnection object and gets an input stream from the connection. The 
connection is opened implicitly by calling getInputStream. Then, like URLReader, this
program creates a BufferedReader on the input stream and reads from it.*/ 
	public static void readURLFromConnection() throws MalformedURLException,IOException{
		URL url = new URL("http://www.oracle.com/");
		URLConnection urlConnection = url.openConnection();
		BufferedReader bis = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		String inputString;
		while((inputString = bis.readLine())!=null){
			System.out.println(inputString);
		}
		bis.close();
	}
}