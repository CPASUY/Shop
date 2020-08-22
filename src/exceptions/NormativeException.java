package exceptions;

public class NormativeException extends Exception {
	public NormativeException() {
		super("You cannot enter the store because your identification number does not correspond to the day assigned by government regulations");
	}

}
