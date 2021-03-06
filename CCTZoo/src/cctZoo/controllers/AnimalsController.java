package cctZoo.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cctZoo.entities.Animal;
import cctZoo.entities.Offspring;
import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
import exceptions.InexistentAnimalException;
import exceptions.InexistentMedicationException;
import exceptions.InvalidActivePrincipleException;
import exceptions.InvalidDosageException;
import exceptions.InvalidExhibitNumberException;
import exceptions.InvalidHeightException;
import exceptions.InvalidIdException;
import exceptions.InvalidLengthException;
import exceptions.InvalidNameException;
import exceptions.InvalidSpecieNameException;
import exceptions.InvalidWeightException;
import exceptions.UndefinedOffspringException;
import utils.Auxiliar;

public class AnimalsController {

	private Map<Long, Animal> animalsMap;
	private long exhibitNumber;

	public AnimalsController() {
		this.animalsMap = new HashMap<>();
		this.exhibitNumber = 0;
	}

	public long addAnimal(String specieName, Gender gender, long fatherExhibitNumber, long motherExhibitNumber,
			double height, double weigth, double length, LocalDate dateOfBirth, LocalDate dateOfArrival,
			Set<AnimalType> typesSet, boolean fligth) throws UndefinedOffspringException, InvalidExhibitNumberException,
			InvalidHeightException, InvalidWeightException, InvalidLengthException, InvalidSpecieNameException {

		if (hasAnimal(motherExhibitNumber) && hasAnimal(fatherExhibitNumber)) {

			Offspring offSpring = new Offspring(fatherExhibitNumber, motherExhibitNumber);

			Animal animal = new Animal(specieName, gender, offSpring, height, weigth, length, dateOfBirth,
					dateOfArrival, exhibitNumber++, typesSet, fligth);
			animalsMap.put(animal.getExhibitNumber(), animal);
			return animal.getExhibitNumber();

		}

		else
			throw new UndefinedOffspringException();

	}

	public long addAnimal(String specieName, Gender gender, double height, double weigth, double length,
			LocalDate dateOfBirth, LocalDate dateOfArrival, Set<AnimalType> typesSet, boolean fligth)
			throws InvalidExhibitNumberException, InvalidHeightException, InvalidWeightException,
			InvalidLengthException, InvalidSpecieNameException {

		Offspring offSpring = new Offspring();

		Animal animal = new Animal(specieName, gender, offSpring, height, weigth, length, dateOfBirth, dateOfArrival, exhibitNumber++, typesSet, fligth);
		animalsMap.put(animal.getExhibitNumber(), animal);
		return animal.getExhibitNumber();

	}

	public String addMedication(long animalExhibitNumber, String name, long id, String activePrinciple,
			LocalDate aplicattionDate, int dosage) {
		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);

			try {

				animal.addMedication(name, id, activePrinciple, aplicattionDate, dosage);
				status = "Medication added with Sucessfull!";

			} catch (InvalidIdException e) {
				status = "Invalid ID!";

			} catch (InvalidNameException e) {
				status = "Invalid Name!";
			} catch (InvalidActivePrincipleException e) {
				status = "Invalid Active Principle!";
			} catch (InvalidDosageException e) {
				status = "Invalid Dosage!";
			}
		}

		else {
			status = "Inexistent Animal!";
		}
		return status;

	}

	public String removeMedication(long animalExhibitNumber, long medicationId) {
		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);

			try {
				animal.removeMedication(medicationId);
				status = "Medication removed with Sucessfull!";
			} catch (InexistentMedicationException e) {
				status = "Inexistent Medication!";
			}
		}

		else {
			status = "Inexistent Animal!";
		}
		return status;

	}

	

	public String addVaccine(long animalExhibitNumber, String name, long id, String activePrinciple,
			LocalDate aplicattionDate, int dosage) {
		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);

			try {

				animal.addVacine(name, id, activePrinciple, aplicattionDate, dosage);
				status = "Vaccine added with Sucessfull!";
			} catch (InvalidIdException e) {
				status = "Invalid ID!";
			} catch (InvalidNameException e) {
				status = "Invalid Name!";
			} catch (InvalidActivePrincipleException e) {
				status = "Invalid Active Principle!";
			} catch (InvalidDosageException e) {
				status = "Invalid Dosage!";
			}
		}

		else {
			status = "Inexistent Animal!";
		}
		return status;
	}

	public String setHeight(long animalExhibitNumber, double newHeight) {

		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			try {
				animal.setHeight(newHeight);
				status = "Height updated with Sucessfull!";
			} catch (InvalidHeightException e) {
				status = "Invalid Height!";
			}

		}

		else
			status = "Inexistent Animal!";

		return status;

	}

	public String setWeight(long animalExhibitNumber, double newWeight) {

		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			try {
				animal.setWeight(newWeight);
				status = "Weight updated with Sucessfull!";
			} catch (InvalidWeightException e) {
				status = "Invalid Weight!";
			}

		}

		else
			status = "Inexistent Animal!";

		return status;

	}

	public String setLength(long animalExhibitNumber, double newLength) {

		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			try {
				animal.setLength(newLength);
				status = "Length updated with Sucessfull!";
			} catch (InvalidLengthException e) {
				status = "Invalid Length!";
			}

		}

		else
			status = "Inexistent Animal!";

		return status;

	}

	public String getInfo(long animalExhibitNumber) {
		String info;

		if (hasAnimal(animalExhibitNumber)) {
			info = animalsMap.get(animalExhibitNumber).toString();
		} else
			info = "Inexistent Animal!";

		return info;
	}

	public String getFatherInfo(long animalExhibitNumber) {
		String fatherInfo;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			Animal father;
			try {
				father = animalsMap.get(animal.getFatherExhibitiNumber());
				fatherInfo = father.toString();
			} catch (UndefinedOffspringException e) {
				fatherInfo = "Undefined Offspring";
			}

		} else
			fatherInfo = "Inexistent Animal!";

		return fatherInfo;
	}

	public String getMotherInfo(long animalExhibitNumber) {
		String fatherInfo;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			Animal mother;
			try {
				mother = animalsMap.get(animal.getMotherExhibitiNumber());
				fatherInfo = mother.toString();
			} catch (UndefinedOffspringException e) {
				fatherInfo = "Undefined Offspring";
			}

		} else
			fatherInfo = "Inexistent Animal!";

		return fatherInfo;
	}

	public boolean hasAnimal(long exhibitNumber) {
		return animalsMap.containsKey(exhibitNumber);
	}

	public String getListingOfMedications(long animalExhibitNumber) {
		String listing;
		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			listing = animal.getListingOfMedications();
		} else {
			listing = "Inexistent Animal!";
		}

		return listing;
	}

	public String getListingOfVaccines(long animalExhibitNumber) {
		String listing;
		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			listing = animal.getListingOfVaccines();
		} else {
			listing = "Inexistent Animal!";
		}

		return listing;
	}

	public Set<AnimalType> getAnimalType(long animalExhibitNumber) throws InexistentAnimalException {
		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);
			return animal.getTypes();
		}

		else
			throw new InexistentAnimalException();
	}

	public String listAnimals() {
		String listing = "";

		if (animalsMap.isEmpty())
			listing += "No Animals Registered!";
		else {
			listing += Auxiliar.BREAK_LINE + "Listing of Animals: " + Auxiliar.BREAK_LINE + Auxiliar.BREAK_LINE;
			for (Animal animal : animalsMap.values())
				listing += animal.toString() + Auxiliar.BREAK_LINE;
		}

		return listing;
	}

}
