package cctZoo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Set;

import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
import cctZoo.zooManagement.ZooManagement;

public class Facade {

	ZooManagement manager = new ZooManagement();

	/**
	 * Search for an animal in the management system
	 * 
	 * @param animalExhibitNumber
	 *            Exhibit number of the animal to be searched for
	 * @return String corresponding to the animal or message if it does not find the
	 *         animal
	 */

	public String searchForAnimal(long animalExhibitNumber) {

		return manager.searchAnimal(animalExhibitNumber);

	}

	/**
	 * Search for a keeper in management system
	 * 
	 * @param keeperId
	 *            Keeper's id
	 * @return Keeper or Exception message
	 */

	public String searchForKeeper(int keeperId) {

		return manager.searchKeeper(keeperId);

	}

	/**
	 * Adds a new animal in the management system according to these parameters.
	 * 
	 * @param gender
	 *            Gender of the animal
	 * @param fatherExhibitNumber
	 *            Exhibit Number of father
	 * @param motherExhibitNumber
	 *            Exhibit Number of mother
	 * @param height
	 *            Height of animal
	 * @param weigth
	 *            Weight of animal
	 * @param length
	 *            Length of animal
	 * @param dateOfBirth
	 *            Date of birth of animal
	 * @param dateOfArrival
	 *            Date of Arrival of animal
	 * @param typesSet
	 *            Collection of types which the animal belongs to
	 * @return a string that resulted in the attempt to add
	 */

	public String addNewAnimal(int idKeeper, String specieName, Gender gender, long fatherExhibitNumber,
			long motherExhibitNumber, double height, double weight, double length, String dateOfBirth,
			String dateOfArrival, Set<AnimalType> typesSet, boolean flight) {

		return manager.addAnimal(idKeeper, specieName, gender, fatherExhibitNumber, motherExhibitNumber, height, weight,
				length, dateOfBirth, dateOfArrival, typesSet, flight);

	}

	/**
	 * Adds a new animal in the management system according to these parameters.
	 * 
	 * @param gender
	 *            Gender of the animal
	 * @param height
	 *            Height of animal
	 * @param weigth
	 *            Weight of animal
	 * @param length
	 *            Length of animal
	 * @param dateOfBirth
	 *            Date of birth of animal
	 * @param dateOfArrival
	 *            Date of Arrival of animal
	 * @param typesSet
	 *            Collection of types which the animal belongs to
	 * @return a string that resulted in the attempt to add
	 */

	public String addNewAnimal(int idKeeper, String specieName, Gender gender, double height, double weigth,
			double length, String dateOfBirth, String dateOfArrival, Set<AnimalType> typesSet, boolean flight) {

		return manager.addAnimal(idKeeper, specieName, gender, height, weigth, length, dateOfBirth, dateOfArrival,
				typesSet, flight);
	}

	/**
	 * Adds a Zoo Keeper in the management system
	 * 
	 * @param qualified
	 *            String that defines whether the keeper is qualified or not
	 * @param name
	 *            String with keeper name
	 * @return String that resulted in the attempt to add
	 */

	public String addNewKeeper(String qualified, String name) {

		return manager.addZooKeeper(qualified, name);

	}

	/**
	 * Updates attributes of an animal
	 * 
	 * @param animalExhibitNumber
	 *            Exhibit Number of the animal
	 * @param attributteToUpdate
	 *            attribute to update
	 * @param newValue
	 *            new value of the attribute
	 * @return String with result of attempted update
	 */

	public String updateAnimal(long animalExhibitNumber, String attributteToUpdate, String newValue) {

		return manager.updateAnimal(animalExhibitNumber, attributteToUpdate, newValue);

	}

	/**
	 * Updates the "qualified" attribute of a keeper
	 * 
	 * @param idKeeper
	 *            Keepers id
	 * @param answer
	 *            answer about the qualification of the keeper
	 * @return a message reporting whether it worked or not
	 */

	public String updateKeeperQualified(int idKeeper, boolean answer) {

		return manager.setZooKeeperQualified(idKeeper, answer);
	}

	/**
	 * List all animals registered in the system
	 * 
	 * @return list of all animals
	 */
	public String listAllAnimals() {

		return manager.getListingOfAnimals();
	}

	/**
	 * List all zoo keepers registered in the system
	 * 
	 * @return list of all animals
	 */
	public String listAllZooKeepers() {

		return manager.getListingOfKeepers();
	}

	/**
	 * Assigns a medication to an animal
	 * 
	 * @param animalExhibitNumber
	 *            Animal's exhibit number
	 * @param specieName
	 *            Animal's species name
	 * @param id
	 *            Medication's id
	 * @param activePrinciple
	 *            Active principle of medication
	 * @param aplicattionDate
	 *            Aplicattion date of medication
	 * @param dosage
	 *            Dosage of medication
	 * 
	 * @return a message reporting whether it worked or not
	 * 
	 */

	public String addAnimalMedication(long animalExhibitNumber, String specieName, long id, String activePrinciple,
			String aplicattionDate, int dosage) {

		return manager.addAnimalMedication(animalExhibitNumber, specieName, id, activePrinciple, aplicattionDate,
				dosage);
	}

	/**
	 * Removes a medication of an animal
	 * 
	 * @param animalExhibitNumber
	 *            Animal's exhibit number
	 * @param medicationId
	 *            Medication's id
	 * @return a message reporting whether it worked or not
	 */

	public String removeAnimalMedication(long animalExhibitNumber, long medicationId) {
		return manager.removeAnimalMedication(animalExhibitNumber, medicationId);
	}

	/**
	 * Assigns a vaccine to an animal
	 * 
	 * @param animalExhibitNumber
	 *            Animal's exhibit number that will be vaccined
	 * @param name
	 *            Vaccine's name
	 * @param id
	 *            Vaccine's ID
	 * @param activePrinciple
	 *            Active Principle of vaccine
	 * @param aplicattionDate
	 *            Aplicattions date of vaccine
	 * @param dosage
	 *            Dosage of vaccine
	 * @return a message reporting whether it worked or not
	 */
	public String addAnimalVaccine(long animalExhibitNumber, String name, long id, String activePrinciple,
			String aplicattionDate, int dosage) {

		return manager.addVaccine(animalExhibitNumber, name, id, activePrinciple, aplicattionDate, dosage);
	}

	/**
	 * Search for parents of an animal
	 * 
	 * @param animalExhibitNumber
	 *            Animal's exhibit number
	 * 
	 * @return a description of the animal's parents or an error message if they are
	 *         not found
	 */

	public String getAnimalParents(long animalExhibitNumber) {

		return manager.getAnimalParents(animalExhibitNumber);
	}

	/**
	 * 
	 * list all medications attributed to an animal
	 * 
	 * @param animalExhibitNumber
	 *            Animal's exhibit number
	 * 
	 * @return returns the list with the medications of an animal
	 */

	public String getAnimalListingOfMedications(long animalExhibitNumber) {

		return manager.getAnimalListingOfMedications(animalExhibitNumber);
	}

	/**
	 * list all vaccines attributed to an animal
	 * 
	 * @param animalExhibitNumber
	 *            Animal's exhibit number
	 * 
	 * @return returns the list with the vaccines of an animal
	 */
	public String getAnimalListingOfVaccines(long animalExhibitNumber) {

		return manager.getAnimalListingOfVaccines(animalExhibitNumber);
	}

	/**
	 * 
	 * relocate an animal to another zoo keeper
	 * 
	 * @param idKeeper
	 *            current keeper id
	 * @param newKeeperId
	 * 
	 *            id of the new keeper
	 * @param animalExhibitNumber
	 *            Animal's exhibit number that will be reallocated
	 * @return a message reporting whether it worked or not
	 */
	public String zooKeeperReallocateAnimal(int idKeeper, int newKeeperId, long animalExhibitId) {

		return manager.zooKeeperReallocateAnimal(idKeeper, newKeeperId, animalExhibitId);

	}

	/**
	 * lists all animals allocated to a specific keeper
	 * 
	 * @param keeperId
	 *            Keeper's Id
	 * @return a list with the animals under keeper guard
	 */
	public String getAnimalsUnderKeepGuard(int keeperId) {

		return manager.getAnimalsUnderKeepGuard(keeperId);
	}
}
