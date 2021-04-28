package prob02;

public class Goods {
	public String name;
	public int price;
	public int countOfGoods;
	
	public Goods(String name,int price,int countOfGoods) {
		this.name=name;
		this.price=price;
		this.countOfGoods=countOfGoods;
	}
	
	public void show() {
		System.out.println(name+"(가격 : "+price+"원)이 "+countOfGoods+"개 입고되었습니다.");
	}
}
