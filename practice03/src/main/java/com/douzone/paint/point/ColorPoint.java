package paint;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x,int y, String color) {
		super(x,y);
		this.color=color;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setColor(int x,int y,String color) {
		setX(x);
		setY(y);
		this.color = color;
	}
	@Override
	public void show() {
		System.out.println("["+getX()+","+getY()+", "+color+"]에 점을 그렸습니다.");
	}
	
	
}
