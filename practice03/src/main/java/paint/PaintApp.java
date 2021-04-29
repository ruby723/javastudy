package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point(10,20);
		point1.show();
		point1.show(false);
		
		Point point2=new Point(100,200);
		//point2.show();
		draw(point2);
		
		Point point3=new ColorPoint(50,100,"red");
//		point3.show();
//		point3.show(true);//boolean 메소드 수정을 안했음에도 불구하고 코드의 재사용덕분에 수정없음
		draw(point3);
		
		Rect rect=new Rect();
		draw(rect);
		
		Triangle p=new Triangle();
//		Shape p=triangle;
		draw(p);
		
		Circle circle=new Circle();
		draw(circle);
		
		draw(new GraphicText("hello~~"));
		
		//instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		//오류 : class는 hierachy 상위와 하위만 instanceof
		//연산자를 사용할 수 있다.
		//System.out.println(circle instanceof Rect);
		
		Shape s=new Circle();
		
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
		//interface는 hierachy와 상관없이
		//instanceof 연산자를 사용할 수 있다.
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);
	}
	
//	public static void drawColorPoint(ColorPoint pt) {
//		pt.show();
//	}
	public static void draw(Drawable drawable) {
	drawable.draw();
	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}

}