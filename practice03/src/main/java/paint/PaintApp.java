package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point(10,20);
		point1.show();
		point1.show(false);
		
		Point point2=new Point(100,200);
		//point2.show();
		drawPoint(point2);
		
		Point point3=new ColorPoint(50,100,"red");
//		point3.show();
//		point3.show(true);//boolean 메소드 수정을 안했음에도 불구하고 코드의 재사용덕분에 수정없음
		drawPoint(point3);
		
		Rect rect=new Rect();
		drawShape(rect);
		
		Triangle p=new Triangle();
//		Shape p=triangle;
		drawShape(p);
		
		Circle circle=new Circle();
		drawShape(circle);
	}
	
//	public static void drawColorPoint(ColorPoint pt) {
//		pt.show();
//	}
	public static void drawPoint(Point pt) {
		pt.show();
	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}

}