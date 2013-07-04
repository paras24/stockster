package sockets;

public class Reply implements Runnable{
	Thread t;
	EchoClient client;
	public Reply(EchoClient client) {
		this.client = client;
		// TODO Auto-generated constructor stub
		t = new Thread(this,"Answer");
		t.start();
	}

	public void run(){
		try {
			while (true) {
				System.out.println("reply");
				client.write();
				System.out.println("replied");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error in reply :"+e.getMessage());
		}
	}
}
