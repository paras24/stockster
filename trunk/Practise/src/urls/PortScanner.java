package urls;

import java.net.Socket;

public class PortScanner {
	
	public static void portScanner(int from,int to,String address){
		System.out.println("Scanner start");
		for (int i = from; i < to; i++) {
			try {
				Socket socket = new Socket(address,i);
				System.out.println("Port in use: "+i+"=>"+socket.toString());
				
				socket.close();
			} catch (Exception e) {
				// do nothing
				System.out.println("Port "+i+" "+e.getLocalizedMessage());
			}
		}
		System.out.println("Scanning finish");
	}
	public static void portScanner(int port,String address){
		portScanner(port, port+1, address);
	}
	public static void main(String[] args) {
		portScanner(8080,"localhost");
	}

}
