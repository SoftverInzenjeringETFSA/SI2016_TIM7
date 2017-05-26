package ba.biblioteka.exceptions;

public class EntityNotFoundException extends RuntimeException {

	  private static final long serialVersionUID = -5597371741018039691L;

	  public EntityNotFoundException(String message) {
	    super(message);
	  }

	}