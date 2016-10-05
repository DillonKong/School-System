package Kong;

public class IvalidInputException extends Exception {

	public IvalidInputException() {
	}

	public IvalidInputException(String arg0) {
		super(arg0);
	}

	public IvalidInputException(Throwable arg0) {
		super(arg0);
	}

	public IvalidInputException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IvalidInputException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	} 

}
