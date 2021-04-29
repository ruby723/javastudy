package paint;

public class Point implements Drawable{
	private int x;
	private int y;
	
	public Point() {}
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void show() {
		System.out.println("["+x+","+y+"]에 점을 그렸습니다.");
	}
	
	public void show(boolean visible) {
		if(visible) {
//			System.out.println("["+x+","+y+"]에 점을 그렸습니다.");
			show();//코드 복붙x, 코드 재사용
		}else {
			System.out.println("["+x+","+y+"]에 점을 지웠습니다.");
			
		}
	}
	
	@Override
	public void draw() {
		show();
	}
	//메소드 오버로딩
//	void disappear() {
//		System.out.println("["+x+","+y+"]에 점을 지웠습니다.");
//	}
}
