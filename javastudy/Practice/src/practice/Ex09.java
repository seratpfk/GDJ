package practice;

public class Ex09 {
	
	// 필드
	private String accNo;
	private long balance;
	
	// 생성자
	public Ex09(String accNo, long balance) {  //Bank b = new BankAccount("1234, 50000);
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 메소드
	// 1. 입금(마이너스 입금 불가)
	public void deposit(long money) {  // 입금하려는 금액을 외부에서 받아오는 형식. b.deposit(50000); (=b 계좌에 50000원 입금)
		if(money < 0)
			return;  // 반환타입이 void인 메소드를 종료하는 코드
		balance += money;
	}
	
	// 2. 출금(마이너스 출금, 잔액보다 큰 출금 불가)
	// 실제로 출금된 금액을 반환
	public long withdraw(long money) {  // long 출금액 = b.withdrawal(50000);
		if(money < 0 || money > balance)
			return 0;  // void가 아닌 long이기 때문에 return 뒤에 0이 붙음.
		balance -= money;
		return money; // 출금 금액을 리턴
	}
	
	// 3. 이체(출금 -> 입금)
	public void transfer(Ex09 other, long money) {
		// 내 통장에서 출금된 금액만큼 상대 계좌에 입금한다.
		//long withdrawalMoney = withdraw(money);
		//	other.deposit(withdrawalMoney);
			other.deposit(withdraw(money));
	}
	
	// 4. 계좌 정보 확인
	public void accInfo() {
		System.out.println("계좌번호: " + accNo + ", 잔고: " + balance + "원");
	}
	
	// 5. 메인
	public static void main(String[] args) {
		
		Ex09 me = new Ex09("1234", 50000);
		Ex09 mom = new Ex09("4567", 100000);
		
		mom.transfer(me, 50000);  // 엄마가 나에게 50000원 이체
		
		me.accInfo();
		mom.accInfo();
		
	}

}
