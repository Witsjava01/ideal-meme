package life4fun.exception;

public class LoginFailedException extends VGBException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginFailedException() {
		super();		
	}

	public LoginFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginFailedException(String message) {
		super(message);
	}

}
