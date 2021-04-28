package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0;i<COUNT_GOODS;i++) {
			String name=scanner.next();
			int price=scanner.nextInt();
			int countOfGoods=scanner.nextInt();
			goods[i]=new Goods(name,price,countOfGoods);
		}
		// 상품 출
		for(int i=0;i<COUNT_GOODS;i++) {
			goods[i].show();
		}
		// 자원정리
		scanner.close();
	}
}
