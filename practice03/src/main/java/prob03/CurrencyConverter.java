package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		double dollar=won/rate;
		return dollar;
	}
	public static double toKRW(double dollar) {
		double won= dollar*rate;
		return won;
	}
	public static void setRate(double r) {
		rate=r;
	}
}
