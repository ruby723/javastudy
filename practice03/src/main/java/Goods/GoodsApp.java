package Goods;

import mypackage.Goods;

public class GoodsApp {

	public static void main(String[] args) {
		
		Goods goods1 = new Goods();
		goods1.name="camera";  //public 접근제한 없음
		//goods1.price=1000;     //protected 같은패키지 + 자식에서만 접근가능
		//goods1.countStock=50;  //디폴트 같은패키지만 접근가능(클래스에서 되도록이만 사용x)

		//private는 같은 클래스내에서만 접근가능
		//goods1.countSold=20;
		
		Goods goods2=new Goods();
		Goods goods3=new Goods();
		
		System.out.println(Goods.countOfGoods);
	}

}
