package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	Socket echoSocket;
	BufferedReader in;
	PrintWriter out;
	BufferedReader stdIn;
	public void initialiseClient() throws Exception{
		echoSocket = new Socket("www.google.com",80);
	}
	
	public void read() throws Exception{
		in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		String inputString;
		while((inputString = in.readLine())!=null){
			System.out.println("Server: "+inputString);
		}
		in.close();
	}
	
	public void write() throws Exception{
		out = new PrintWriter(echoSocket.getOutputStream(),true);
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		while((userInput = stdIn.readLine())!=null){
			out.println(userInput);
//			System.out.println("Me: "+userInput);
			
		}
		stdIn.close();
		out.close();
	}
	
	public void closeClient() throws Exception{
		
		echoSocket.close();		
	}

}
