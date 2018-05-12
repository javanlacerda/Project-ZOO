package utils;

import exceptions.InvalidActivePrincipleException;
import exceptions.InvalidDosageException;
import exceptions.InvalidExhibitNumberException;
import exceptions.InvalidHeightException;
import exceptions.InvalidIdException;
import exceptions.InvalidLengthException;
import exceptions.InvalidNameException;
import exceptions.InvalidSpecieNameException;
import exceptions.InvalidWeightException;

public final class Validate {

	public static void validateExhibitNumber(long number) throws InvalidExhibitNumberException {
		if (number < 0)
			throw new InvalidExhibitNumberException();
	}

	public static void validateHeigh(double height) throws InvalidHeightException {
		if (height < 0)
			throw new InvalidHeightException();
	}

	public static void validateWeight(double weight) throws InvalidWeightException {
		if (weight < 0.0)
			throw new InvalidWeightException();
	}

	public static void validateLength(double length) throws InvalidLengthException {
		if (length < 0)
			throw new InvalidLengthException();
	}

	public static void validateName(String name) throws InvalidNameException {
		if (name.trim().equals("") || name == null)
			throw new InvalidNameException();
	}
	
	public static void validateSpecieName(String specieName) throws InvalidSpecieNameException {
		if (specieName.trim().equals("") || specieName == null)
			throw new InvalidSpecieNameException();
	}

	public static void validateDosage(int dosage) throws InvalidDosageException {
		if (dosage < 0)
			throw new InvalidDosageException();

	}

	public static void validateId(long id) throws InvalidIdException {
		if (id < 0)
			throw new InvalidIdException();
	}

	public static void validateActivePrinciple(String activePrinciple) throws InvalidActivePrincipleException {
		if (activePrinciple.trim().equals("") || activePrinciple == null)
			throw new InvalidActivePrincipleException();
	}

}
