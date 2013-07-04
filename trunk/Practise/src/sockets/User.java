package sockets;

public class User{
	public static void main(String[] args) {
		EchoClient client = null;
		try {
			client = new EchoClient();
			client.initialiseClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Ask(client);
		new Reply(client);
	}

}
