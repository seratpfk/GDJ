package quiz03;

public class BankException extends Exception {

	
	private static final long serialVersionUID = -3990936769640382913L;
	private int errorCode;
	
	public BankException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	

}
