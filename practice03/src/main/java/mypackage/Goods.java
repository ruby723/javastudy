package mypackage;

public class Goods {
	static public int countOfGoods;
	
	public Goods() {
		Goods.countOfGoods++;
	}
	public String name;           //public : 모든 접근가능
	protected int price;          //같은 패키지 + *자식 접근가능
	int countStock;               //디폴트접근지정자, 같은패키지만 접근가능
	private int countSold;        //클래스 내부에서만 접근가능
	
	
	void m() {
		countSold=100;
	}
}
