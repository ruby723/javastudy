package tv;

public class TV {
	private int channel;   //channel의 범위는 1-255
	private int volume;    //volume의 범위는 0-100
	private boolean power;
	
	public void power(boolean on) {
		if(on==true) {
			this.power=true;
		}else {
			this.power=false;
		}
	}
	
	public void channel(boolean up) {
		if(up==true) {
			channel++;
		} else {
			channel--;
		}
	}
	
	public void channel(int channel) {
		
	}
	
	public void volume(boolean up) {
		
	}
	
	public void volume(int volume) {
		
	}

	public void status() {
		System.out.println("TV[power="+power+", channel="+channel+",volume="+volume);
	}
}
