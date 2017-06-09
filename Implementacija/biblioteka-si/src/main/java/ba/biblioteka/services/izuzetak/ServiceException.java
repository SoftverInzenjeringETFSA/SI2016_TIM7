package ba.biblioteka.services.izuzetak;

public class ServiceException extends Exception{
	
	 public ServiceException(String message) {
	        super(message);
	    }

	    public ServiceException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    @Override
	    public String toString() {
	        return getMessage();
	    }

}
