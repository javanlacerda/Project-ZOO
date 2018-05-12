package interfaces;

import java.time.LocalDate;
import java.util.Set;

import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
import exceptions.InexistentMedicationException;
import exceptions.InexistentVaccineException;
import exceptions.InvalidActivePrincipleException;
import exceptions.InvalidDosageException;
import exceptions.InvalidHeightException;
import exceptions.InvalidIdException;
import exceptions.InvalidLengthException;
import exceptions.InvalidNameException;
import exceptions.InvalidWeightException;
import exceptions.UndefinedOffspringException;

public interface AnimalInterface {

	double getHeight();

	void setHeight(double height) throws InvalidHeightException;

	double getWeight();

	void setWeight(double weigth) throws InvalidWeightException;

	double getLength();

	void setLength(double length) throws InvalidLengthException;

	Gender getGender();

	long getFatherExhibitiNumber() throws UndefinedOffspringException;

	long getMotherExhibitiNumber() throws UndefinedOffspringException;

	LocalDate getDateOfBirth();

	LocalDate getDateOfArrival();

	long getExhibitNumber();

	Set<AnimalType> getTypes();

	long addMedication(String name, long id, String activePrinciple, LocalDate aplicattionDate, int dosage)
			throws InvalidIdException, InvalidNameException, InvalidActivePrincipleException, InvalidDosageException;

	long addVacine(String name, long id, String activePrinciple, LocalDate aplicattionDate, int dosage)
			throws InvalidIdException, InvalidNameException, InvalidActivePrincipleException, InvalidDosageException;

	void removeMedication(long id) throws InexistentMedicationException;

	void removeVaccine(long id) throws InexistentVaccineException;

	String getListingOfMedications();

	String getListingOfVaccines();

	int hashCode();

	boolean equals(Object obj);

}
