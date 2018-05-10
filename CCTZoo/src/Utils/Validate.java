package Utils;

import Exceptions.Animal.InvalidExhibitNumberException;
import Exceptions.Animal.InvalidHeightException;
import Exceptions.Animal.InvalidLengthException;
import Exceptions.Animal.InvalidWeightException;

public class Validate {

	public static void validateExhibitNumber(long number) throws InvalidExhibitNumberException {
		if (number < 0)
			throw new InvalidExhibitNumberException();
	}

	public static void validateHeigh(double height) throws InvalidHeightException {
		if (height <= 0)
			throw new InvalidHeightException();
	}

	public static void validateWeight(double weight) throws InvalidWeightException {
		if (weight <= 0)
			throw new InvalidWeightException();
	}

	public static void validateLength(double length) throws InvalidLengthException {
		if (length <= 0)
			throw new InvalidLengthException();
	}

}
