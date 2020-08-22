package exceptions;

public class NoAgeException extends Exception {
	public NoAgeException() {
		super("You cannot enter the store because you are a minor");
	}
}
