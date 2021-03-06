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
import exceptions.InexistentKeeperException;
import exceptions.InvalidExhibitNumberException;
import exceptions.InvalidHeightException;
import exceptions.InvalidLengthException;
import exceptions.InvalidSpecieNameException;
import exceptions.InvalidWeightException;
import exceptions.NumberOfAnimalsExceededException;
import exceptions.NumberOfTypesExceededException;
import exceptions.UndefinedOffspringException;
import exceptions.UnqualifiedKeeperException;
import utils.Auxiliar;

public class ZooManagement {

	private AnimalsController aController;
	private ZooKeepersController zKController;
	DateTimeFormatter dateFormate;

	public ZooManagement() {
		this.aController = new AnimalsController();
		this.zKController = new ZooKeepersController();
		this.dateFormate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	}

	public String addAnimal(int idKeeper, String specieName, Gender gender, long fatherExhibitNumber,
			long motherExhibitNumber, double height, double weigth, double length, String dateOfBirth,
			String dateOfArrival, Set<AnimalType> typesSet, boolean flight) {

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
		try {
			zKController.canAlocateAnimal(idKeeper, typesSet);
			long exhibitId = aController.addAnimal(specieName, gender, fatherExhibitNumber, motherExhibitNumber, height,
					weigth, length, dateOfBirthParse, dateOfArrivalParse, typesSet, flight);
			zKController.allocateAnimal(idKeeper, exhibitId, typesSet);
		} catch (InvalidExhibitNumberException e) {
			return "Invalid Exibit Number!";
		} catch (InvalidHeightException e) {
			return "Invalid Height!";
		} catch (InvalidWeightException e) {
			return "Invalid Weight!";
		} catch (InvalidLengthException e) {
			return "Invalid Length!";
		} catch (UnqualifiedKeeperException e) {
			return "Unqualified Keeper!";
		} catch (NumberOfAnimalsExceededException e) {
			return "Number Of Animals Exceeded at ZooKeeper";
		} catch (NumberOfTypesExceededException e) {
			return "Number Of Types Exceeded at ZooKeeper";
		} catch (InexistentKeeperException e) {
			return "Inexistent ZooKeeper";
		} catch (UndefinedOffspringException e) {
			return "Inexistent Father and/or Mother!";
		} catch (InvalidSpecieNameException e) {
			return "Invalid Specie Name";
		}

		return "Animal Registered with Sucessfull!";

	}

	public String addAnimal(int idKeeper, String specieName, Gender gender, double height, double weigth, double length,
			String dateOfBirth, String dateOfArrival, Set<AnimalType> typesSet, boolean flight) {

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

		try {
			zKController.canAlocateAnimal(idKeeper, typesSet);
			long exhibitId = aController.addAnimal(specieName, gender, height, weigth, length, dateOfBirthParse,
					dateOfArrivalParse, typesSet, flight);
			zKController.allocateAnimal(idKeeper, exhibitId, typesSet);
		} catch (InvalidExhibitNumberException e) {
			return "Invalid Exibit Number!";
		} catch (InvalidHeightException e) {
			return "Invalid Height!";
		} catch (InvalidWeightException e) {
			return "Invalid Weight!";
		} catch (InvalidLengthException e) {
			return "Invalid Length!";
		} catch (UnqualifiedKeeperException e) {
			return "Unqualified Keeper!";
		} catch (NumberOfAnimalsExceededException e) {
			return "Number Of Animals Exceeded at ZooKeeper";
		} catch (NumberOfTypesExceededException e) {
			return "Number Of Types Exceeded at ZooKeeper";
		} catch (InexistentKeeperException e) {
			return "Inexistent ZooKeeper";
		} catch (InvalidSpecieNameException e) {
			return "Invalid Specie Name";
		}

		return "Animal Registered with Sucessfull!";
	}

	public String addAnimalMedication(long animalExhibitNumber, String medicationName, long id, String activePrinciple,
			String aplicattionDate, int dosage) {

		LocalDate aplicattionDateParse;

		try {
			aplicattionDateParse = LocalDate.parse(aplicattionDate, dateFormate);
		} catch (DateTimeParseException e) {
			return "Invalid Aplicattion Date , please inform a valid date format dd/mm/yyyy";
		}

		return aController.addMedication(animalExhibitNumber, medicationName, id, activePrinciple, aplicattionDateParse,
				dosage);

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

	public String getAnimalParents(long animalExhibitNumber) {

		return aController.getFatherInfo(animalExhibitNumber) + " " + aController.getMotherInfo(animalExhibitNumber);
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

	public String zooKeeperReallocateAnimal(int idKeeper, int newKeeperId, long animalExhibitId) {
		Set<AnimalType> animalsType;
		try {
			animalsType = aController.getAnimalType(animalExhibitId);
		} catch (InexistentAnimalException e) {
			return "Unregistered Animal!";
		}
		return zKController.reallocateAnimal(idKeeper, newKeeperId, animalExhibitId, animalsType);

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

	public String setZooKeeperQualified(int idKeeper, boolean answer) {
		if (!zKController.hasKeeper(idKeeper))
			return "Unregistered Keeper";
		else {
			return zKController.setKeeperQualified(idKeeper, answer);
		}
	}

	public String getListingOfKeepers() {
		return zKController.listKeepers();
	}

	public String searchKeeper(int keeperId) {
		return zKController.getInfo(keeperId);
	}

	public String getAnimalsUnderKeepGuard(int keeperId) {
		String listing = "";
		Set<Long> animalsUnderGuard;

		try {
			animalsUnderGuard = zKController.getAnimalsUnderGuard(keeperId);
		} catch (InexistentKeeperException e) {
			return "Inexistent Keeper";
		}

		listing += "Animals Under Guard: " + Auxiliar.BREAK_LINE + Auxiliar.BREAK_LINE;

		for (Long animalExhibitNumber : animalsUnderGuard) {
			listing += aController.getInfo(animalExhibitNumber) + Auxiliar.BREAK_LINE;
		}

		return listing;
	}

}
