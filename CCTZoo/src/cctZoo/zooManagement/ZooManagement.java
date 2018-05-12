package cctZoo.zooManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;

import cctZoo.controllers.AnimalsController;
import cctZoo.controllers.ZooKeepersController;
import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
import exceptions.InexistentAnimalException;

public class ZooManagement {

	private AnimalsController aController;
	private ZooKeepersController zKController;
	DateTimeFormatter dateFormate;

	public ZooManagement() {
		this.aController = new AnimalsController();
		this.zKController = new ZooKeepersController();
		this.dateFormate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	}

	// Falta sobrecarregar o addAnimal para os casos que tenham flight
	// eu ja mudei la em controllerAnimal, da uma sacada lá

	public String addAnimal(Gender gender, long fatherExhibitNumber, long motherExhibitNumber, double height,
			double weigth, double length, String dateOfBirth, String dateOfArrival, Set<AnimalType> typesSet) {

		LocalDate dateOfBirthParse;
		LocalDate dateOfArrivalParse;

		try {
			dateOfBirthParse = LocalDate.parse(dateOfBirth, dateFormate);
		} catch (DateTimeParseException e) {
			return "Invalid Date of Birth, please inform a valid date format dd/mm/yyyy";
		}

		try {
			dateOfArrivalParse = LocalDate.parse(dateOfArrival, dateFormate);
		} catch (DateTimeParseException e) {
			return "Invalid Date of Arrival, please inform a valid date format dd/mm/yyyy";
		}

		return aController.addAnimal(gender, height, weigth, length, dateOfBirthParse, dateOfArrivalParse, typesSet);

	}

	public String addAnimal(Gender gender, double height, double weigth, double length, String dateOfBirth,
			String dateOfArrival, Set<AnimalType> typesSet) {

		LocalDate dateOfBirthParse;
		LocalDate dateOfArrivalParse;

		try {
			dateOfBirthParse = LocalDate.parse(dateOfBirth, dateFormate);
		} catch (DateTimeParseException e) {
			return "Invalid Date of Birth, please inform a valid date format dd/mm/yyyy";
		}

		try {
			dateOfArrivalParse = LocalDate.parse(dateOfArrival, dateFormate);
		} catch (DateTimeParseException e) {
			return "Invalid Date of Arrival, please inform a valid date format dd/mm/yyyy";
		}

		return aController.addAnimal(gender, height, weigth, length, dateOfBirthParse, dateOfArrivalParse, typesSet);

	}

	public String addAnimalMedication(long animalExhibitNumber, String name, long id, String activePrinciple,
			String aplicattionDate, int dosage) {

		LocalDate aplicattionDateParse;

		try {
			aplicattionDateParse = LocalDate.parse(aplicattionDate, dateFormate);
		} catch (DateTimeParseException e) {
			return "Invalid Aplicattion Date , please inform a valid date format dd/mm/yyyy";
		}

		return aController.addMedication(animalExhibitNumber, name, id, activePrinciple, aplicattionDateParse, dosage);

	}

	public String removeAnimalMedication(long animalExhibitNumber, long medicationId) {
		return aController.removeMedication(animalExhibitNumber, medicationId);
	}

	public String addVaccine(long animalExhibitNumber, String name, long id, String activePrinciple,
			String aplicattionDate, int dosage) {

		LocalDate aplicattionDateParse;

		try {
			aplicattionDateParse = LocalDate.parse(aplicattionDate, dateFormate);
		} catch (DateTimeParseException e) {
			return "Invalid Aplicattion Date , please inform a valid date format dd/mm/yyyy";
		}

		return aController.addVaccine(animalExhibitNumber, name, id, activePrinciple, aplicattionDateParse, dosage);
	}

	public String removeAnimalVaccine(long animalExhibitNumber, long vaccineId) {

		return aController.removeVaccine(animalExhibitNumber, vaccineId);
	}

	public String updateAnimal(long animalExibitNumber, String attributteToUpdate, String newValue) {

		switch (attributteToUpdate.toUpperCase()) {
		case "HEIGHT":
			if (!isDouble(newValue))
				return "Invalid HEIGHT, please input a valid number";
			double newHeight = Double.parseDouble(newValue);
			return aController.setHeight(animalExibitNumber, newHeight);
		case "WEIGHT":
			if (!isDouble(newValue))
				return "Invalid WEIGHT, please input a valid number";
			double newWeight = Double.parseDouble(newValue);
			return aController.setHeight(animalExibitNumber, newWeight);
		case "LENGTH":
			if (!isDouble(newValue))
				return "Invalid LENGTH, please input a valid number";
			double newLength = Double.parseDouble(newValue);
			return aController.setHeight(animalExibitNumber, newLength);
		default:
			return "Invalid Option, please select a valid option : HEIGHT|WEIGHT|LENGTH";

		}
	}

	public String searchAnimal(long animalExhibitNumber) {
		return aController.getInfo(animalExhibitNumber);
	}

	public String getAnimalFather(long animalExhibitNumber) {
		return aController.getFatherInfo(animalExhibitNumber);
	}

	public String getAnimalMother(long animalExhibitNumber) {
		return aController.getMotherInfo(animalExhibitNumber);
	}

	public String getAnimalListingOfMedications(long animalExhibitNumber) {
		return aController.getListingOfMedications(animalExhibitNumber);
	}

	public String getAnimalListingOfVaccines(long animalExhibitNumber) {
		return aController.getListingOfVaccines(animalExhibitNumber);
	}

	public String getListingOfAnimals() {
		return aController.listAnimals();
	}

	public String addZooKeeper(String qualified, String name) {

		switch (qualified.toUpperCase()) {
		case "YES":
			return zKController.addZooKeeper(true, name);
		case "NO":
			return zKController.addZooKeeper(false, name);

		default:
			return "Invalid Qualified Value, please input a valid Value : YES|NO";
		}
	}

	public String zooKeeperAlocatteAnimal(int idKeeper, long animalExhibitId, Set<AnimalType> animalTypes) {
		if (aController.hasAnimal(animalExhibitId))
			return zKController.allocateAnimal(idKeeper, animalExhibitId, animalTypes);
		else
			return "Unregistered Animal";
	}

	public String zooKeeperDeallocateAnimal(int idKeeper, int newKeeperId, long animalExhibitId) {
		Set<AnimalType> animalsType;
		try {
			animalsType = aController.getAnimalType(animalExhibitId);
		} catch (InexistentAnimalException e) {
			return "Unregistered Animal!";
		}
		return zKController.deallocateAnimal(idKeeper, newKeeperId, animalExhibitId, animalsType);

	}

	private boolean isDouble(String number) {

		try {
			Double.parseDouble(number);
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

}
