package week3.day1;

public class AxisBank extends BankInfo{
	
	public void deposit() {
		System.out.println("AxisBank Deposit");
	}
	public static void main(String[] args) {
		AxisBank ab = new AxisBank();
		ab.deposit();
		ab.saving();
		ab.fixed();
	}

}
