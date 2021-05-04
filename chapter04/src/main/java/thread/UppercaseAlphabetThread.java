package thread;

public class UppercaseAlphabetThread {
	
	public void print() {
		for(char c='A';c<='Z';c++) {
			System.out.println(c);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
