package cctZoo.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cctZoo.entities.Animal;
import cctZoo.entities.Offspring;
import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
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
import exceptions.UndefinedOffspringException;

public class AnimalsController {

	private Map<Long, Animal> animalsMap;
	private long exhibitNumber;

	public AnimalsController() {
		this.animalsMap = new HashMap<>();
		this.exhibitNumber = 0;
	}

	public String addAnimal(Gender gender, long fatherExhibitNumber, long motherExhibitNumber, double height,
			double weigth, double length, LocalDate dateOfBirth, LocalDate dateOfArrival, Set<AnimalType> typesSet) {

		String status = "Inexistent Father or Mother!";

		if (hasAnimal(motherExhibitNumber) && hasAnimal(fatherExhibitNumber)) {

			Offspring offSpring = new Offspring(fatherExhibitNumber, motherExhibitNumber);

			Animal animal;

			try {
				animal = new Animal(gender, offSpring, height, weigth, length, dateOfBirth, dateOfArrival,
						exhibitNumber++, typesSet);
				animalsMap.put(animal.getExhibitNumber(), animal);
				status = "Animal added with sucessfull!";
			} catch (InvalidExhibitNumberException | InvalidHeightException | InvalidWeightException
					| InvalidLengthException e) {
				status = e.getMessage();
			}
		}

		return status;

	}

	public String addAnimal(Gender gender, double height, double weigth, double length, LocalDate dateOfBirth,
			LocalDate dateOfArrival, Set<AnimalType> typesSet) {

		String status = "Animal added with sucessfull!";
		Offspring offSpring = new Offspring();

		Animal animal;
		try {
			animal = new Animal(gender, offSpring, height, weigth, length, dateOfBirth, dateOfArrival, exhibitNumber++,
					typesSet);
			animalsMap.put(animal.getExhibitNumber(), animal);
		} catch (InvalidExhibitNumberException | InvalidHeightException | InvalidWeightException
				| InvalidLengthException e) {
			status = e.toString();
		}

		return status;

	}

	public String addMedication(long animalExhibitNumber, String name, long id, String activePrinciple,
			LocalDate aplicattionDate, int dosage) {
		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);

			try {

				animal.addMedication(name, id, activePrinciple, aplicattionDate, dosage);

				status = "Medication added with Sucessfull!";
			} catch (InvalidIdException | InvalidNameException | InvalidActivePrincipleException
					| InvalidDosageException e) {
				status = e.toString();
			}
		}

		else {
			status = "Inexistent Animal!";
		}
		return status;

	}

	public String removeMedication(long animalExhibitNumber, String name, long id) {
		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);

			try {
				animal.removeMedication(id);
				status = "Medication removed with Sucessfull!";
			} catch (InexistentMedicationException e) {
				status = e.toString();
			}
		}

		else {
			status = "Inexistent Animal!";
		}
		return status;

	}

	public String removeVaccine(long animalExhibitNumber, String name, long id) {
		String status;

		if (hasAnimal(animalExhibitNumber)) {
			Animal animal = animalsMap.get(animalExhibitNumber);

			try {
				animal.removeVaccine(id);
				status = "Medication removed with Sucessfull!";
			} catch (InexistentVaccineException e) {
				status = e.toString();
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
			} catch (InvalidIdException | InvalidNameException | InvalidActivePrincipleException
					| InvalidDosageException e) {
				status = e.toString();
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
				status = e.toString();
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
				status = e.toString();
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
				status = e.toString();
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
				fatherInfo = e.toString();
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
				fatherInfo = e.toString();
			}

		} else
			fatherInfo = "Inexistent Animal!";

		return fatherInfo;
	}

	private boolean hasAnimal(long exhibitNumber) {
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
	
	
	public String listAnimals() {
		String listing = "No Animals registered!";
		
		
		
		return listing;
	}

}
