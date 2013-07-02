package threading;

public class runDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RunnableDemo();
		for (int i = 0; i < Thread.currentThread().getName().length(); i++) {
			System.out.println(Thread.currentThread().getName().charAt(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
