package threading;

public class RunnableDemo implements Runnable{
	Thread t;
	public RunnableDemo() {
		t = new Thread(this,"demoThread"); // creating a thread using the instance of runnable type class with name
		System.out.println(t.getName()+" created");
		t.start();
	}
	public void run(){
		for (int i = 0; i < t.getName().length(); i++) {
			System.out.println(t.getName().charAt(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	

}
