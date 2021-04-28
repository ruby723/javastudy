package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo=accountNo;
		this.balance=0;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public int getBalance() {
		return balance;
	}
	
	public void save(int money) {
		balance+=money;
	}
	
	public void deposit(int money) {
		balance-=money;
	}
	
	
}
