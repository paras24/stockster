package sockets;

public class Ask implements Runnable{
	Thread t;
	EchoClient client;
	public Ask(EchoClient client) {
		this.client = client;
		// TODO Auto-generated constructor stub
		t = new Thread(this, "Ask");
		t.start();
	}

	public void run(){
		try {
			while (true) {
				System.out.println("ask");
				client.write();
				System.out.println("asked");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error while asking :"+e.getMessage());
		}
	}
}
