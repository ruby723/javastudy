package chapter03;

public class Goods2 {
	
	private int price;
	private String name;
	private int countSold;
	private int countStock;
	
	//기본생성자(오버로딩)
	public Goods2() {};
	
	public Goods2(String name,int price,int countSold,int countStock) {
		this.name=name;
		this.price=price;
		this.countSold=countSold;
		this.countStock=countStock;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price<0) {
			price=0;
		}
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public void showInfo() {
		System.out.println("name :"+name +", price : "+price+", countStock : "+countStock+", countSold : "+countSold);
		
	}
	
	public int calculateDiscountPrice(double rate) {
		int i=10;
		double d=i;
		int discountPrice=(int)(price * rate);
		return discountPrice;
	}
	
}
