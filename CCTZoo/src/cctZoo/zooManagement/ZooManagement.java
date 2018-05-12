package cctZoo.zooManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;

import cctZoo.controllers.AnimalsController;
import cctZoo.controllers.ZooKeepersController;
import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;

public class ZooManagement {

	private AnimalsController aController;
	private ZooKeepersController zKController;
	DateTimeFormatter dateFormate;

	public ZooManagement() {
		this.aController = new AnimalsController();
		this.zKController = new ZooKeepersController();
		this.dateFormate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	}

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

}
