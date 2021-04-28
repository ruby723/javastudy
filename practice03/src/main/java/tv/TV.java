package tv;

public class TV {
	private int channel;   //channel의 범위는 1-255
	private int volume;    //volume의 범위는 0-100
	private boolean power;
	
	public TV(int channel,int volume,boolean power) {
		this.channel=channel;
		this.volume=volume;
		this.power=power;
	}
	
	public void power(boolean on) {
		if(on==true) {
			power=true;
		}else {
			power=false;
		}
	}
	
	public void setChannel() {
		if(channel>255) {
			channel= 1;
		}
		else if(channel<1) {
			channel=255;
		}
	}
	
	public void channel(boolean up) {
		if(up==true) {
			channel++;
			setChannel();
		} else {
			channel--;
			setChannel();
		}
	}
	
	public void channel(int channel) {
		this.channel=channel;
		setChannel();
	}
	
	public void setVolume() {
		if(volume>100) {
			volume= 0;
		}
		else if(volume<0) {
			volume= 100;
		}
	}
	
	public void volume(boolean up) {
		if(up==true) {
			volume++;
			setVolume();
		} else {
			volume--;
			setVolume();
		}
	}
	
	public void volume(int volume) {
		this.volume=volume;
		setVolume();
	}

	public void status() {
		System.out.println("TV[power="+power+", channel="+channel+",volume="+volume);
	}
}
