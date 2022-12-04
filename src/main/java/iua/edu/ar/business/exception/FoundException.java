package iua.edu.ar.business.exception;

public class FoundException extends Exception{

	private static final long serialVersionUID = -7870086747971795613L;


	public FoundException() {
	
	}

	public FoundException(String message) {
		super(message);
		
	}

	public FoundException(Throwable cause) {
		super(cause);
		
	}

	public FoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
	
}
