
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import exceptions.InexistentMedicationException;
import exceptions.InexistentVaccineException;
import exceptions.InvalidActivePrincipleException;
import exceptions.InvalidDosageException;
import exceptions.InvalidExhibitNumberException;
import exceptions.InvalidHeightException;
import exceptions.InvalidIdException;
import exceptions.InvalidLengthException;
import exceptions.InvalidNameException;
import exceptions.InvalidWeightException;

public class Animal {

	private Gender gender;
	private Offspring offSpring;
	private double height;
	private double weight;
	private double length;
	private LocalDate dateOfBirth;
	private LocalDate dateOfArrival;
	private Map<Long,Vaccine> vaccineMap;
	private Map<Long,Medication> medicationMap;
	private long exhibitNumber;
	private Set<AnimalType> typesSet;

	public Animal(Gender gender, Offspring offSpring, double height, double weigth, double length,
			LocalDate dateOfBirth, LocalDate dateOfArrival, long exhibitNumber, Set<AnimalType> typesSet)
			throws InvalidExhibitNumberException, InvalidHeightException, InvalidWeightException,
			InvalidLengthException {

		validateAtributes(exhibitNumber, height, weight, length);

		this.gender = gender;
		this.offSpring = offSpring;
		this.height = height;
		this.weight = weigth;
		this.length = length;
		this.dateOfBirth = dateOfBirth;
		this.dateOfArrival = dateOfArrival;
		this.vaccineMap = new HashMap<>();
		this.medicationMap = new HashMap<>();
		this.exhibitNumber = exhibitNumber;
		this.typesSet = typesSet;
	}

	public Animal(Gender gender, Offspring offSpring, double height, double weigth, double length,
			LocalDate dateOfBirth, LocalDate dateOfArrival, long exhibitNumber, String fligth)
			throws InvalidExhibitNumberException, InvalidHeightException, InvalidWeightException,
			InvalidLengthException {

		validateAtributes(exhibitNumber, height, weight, length);

		this.gender = gender;
		this.offSpring = offSpring;
		this.height = height;
		this.weight = weigth;
		this.length = length;
		this.dateOfBirth = dateOfBirth;
		this.dateOfArrival = dateOfArrival;
		this.vaccineMap = new HashMap<>();
		this.medicationMap = new HashMap<>();
		this.exhibitNumber = exhibitNumber;

		new Animal.Avian(fligth);

	}

	private void validateAtributes(long exhibitNumber, double height, double weight, double length)
			throws InvalidExhibitNumberException, InvalidHeightException, InvalidWeightException,
			InvalidLengthException {
		utils.Validate.validateExhibitNumber(exhibitNumber);
		utils.Validate.validateHeigh(height);
		utils.Validate.validateWeight(weight);
		utils.Validate.validateLength(length);
	}

	public static class Avian {

		public static String flight;

		public Avian(String flight) {

			Avian.flight = flight;
		}
	}

	public String getFlight() {
		try {
			if (Avian.flight != null) {

				return Avian.flight;

			} else {

				throw new NullPointerException("This animal isn't an Avian!");

			}
		} catch (NullPointerException exception) {

			return exception.getMessage();

		}
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeigth() {
		return this.weight;
	}

	public void setWeigth(double weigth) {
		this.weight = weigth;
	}

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Gender getGender() {
		return this.gender;
	}

	public Offspring getOffSpring() {
		return this.offSpring;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public LocalDate getDateOfArrival() {
		return this.dateOfArrival;
	}

	public long getExhibitNumber() {
		return this.exhibitNumber;
	}

	public Set<AnimalType> getTypes() {
		return this.typesSet;
	}

	public long addMedication(String name, long id, String activePrinciple, LocalDate aplicattionDate, int dosage) throws InvalidIdException, InvalidNameException, InvalidActivePrincipleException, InvalidDosageException {
		Medication medication = new Medication(name, id, activePrinciple, aplicattionDate, dosage);
		medicationMap.put(id,medication);
		return id;
	}

	public long addVacine(String name, long id, String activePrinciple, LocalDate aplicattionDate, int dosage) throws InvalidIdException, InvalidNameException, InvalidActivePrincipleException, InvalidDosageException {
		Vaccine vaccine = new Vaccine(name, id, activePrinciple, aplicattionDate, dosage);
		vaccineMap.put(id,vaccine);
		return id;
	}
	
	public void removeMedication (long id) throws InexistentMedicationException {
		if (!medicationMap.containsKey(id))
			throw new InexistentMedicationException();
		medicationMap.remove(id);
	}
	
	public void removeVaccine (long id) throws InexistentVaccineException {
		if(!vaccineMap.containsKey(id))
			throw new InexistentVaccineException();
		 vaccineMap.remove(id);
	}
	

	public String getListingOfMedications() {
		String listing = "";

		if (medicationMap.isEmpty())
			listing = "No medication registered!";
		else
			for (Medication medication : medicationMap.values())
				listing += medication.toString() + utils.Auxiliar.BREAK_LINE;

		return listing;

	}

	public String getListingOfVaccines() {
		String listing = "";

		if (vaccineMap.isEmpty())
			listing = "No Vaccine registered!";
		else
			for (Vaccine vaccine : vaccineMap.values())
				listing += vaccine.toString() + utils.Auxiliar.BREAK_LINE;

		return listing;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (exhibitNumber ^ (exhibitNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (exhibitNumber != other.exhibitNumber)
			return false;
		return true;
	}

}
