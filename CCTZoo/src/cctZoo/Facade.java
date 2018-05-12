package cctZoo;

import java.time.LocalDate;
import java.util.Set;

import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
import cctZoo.zooManagement.ZooManagement;

public class Facade {

	ZooManagement manager = new ZooManagement();
	
	/**
	 * Search for an animal in the management system
	 * @param animalExhibitNumber Exhibit number of the animal to be searched for 
	 * @return String corresponding to the animal or message if it does not find the animal
	 */
	
	public String searchForAnimal(long animalExhibitNumber) {

		return manager.searchAnimal(animalExhibitNumber);

	}

	public String searchForKeeper() {

		// falta implementar no manager
		return null;

	}

	/**
	 * Adds a new animal in the management system according to these parameters.
	 * @param gender Gender of the animal
	 * @param fatherExhibitNumber Exhibit Number of father
	 * @param motherExhibitNumber Exhibit Number of mother
	 * @param height Height of animal
	 * @param weigth Weight of animal
	 * @param length Length of animal
	 * @param dateOfBirth Date of birth of animal
	 * @param dateOfArrival Date of Arrival of animal
	 * @param typesSet Collection of types which the animal belongs to
	 * @return a string that resulted in the attempt to add
	 */
	
//	public String addNewAnimal(Gender gender, long fatherExhibitNumber, long motherExhibitNumber, double height,
//			double weight, double length, String dateOfBirth, String dateOfArrival, Set<AnimalType> typesSet) {
//
//		 return manager.addAnimal(gender, fatherExhibitNumber, motherExhibitNumber, height,
//					weight, length, dateOfBirth, dateOfArrival, typesSet);
//		
//	}
	
	/**
	 * Adds a new animal in the management system according to these parameters.
	 * @param gender Gender of the animal
	 * @param height Height of animal
	 * @param weight Weight of animal
	 * @param length Length of animal
	 * @param dateOfBirth Date of birth of animal
	 * @param dateOfArrival Date of Arrival of animal
	 * @param typesSet Collection of types which the animal belongs to
	 * @return a string that resulted in the attempt to add
	 */
	
//	public String addNewAnimal(Gender gender, double height, double weight, double length, String dateOfBirth,
//			String dateOfArrival, Set<AnimalType> typesSet) {
//
//		return manager.addAnimal(gender, height, weight, length, dateOfBirth,
//				dateOfArrival, typesSet);
//
//	}
//	
	/**
	 * Adds a new animal in the management system according to these parameters.
	 * @param gender Gender of the animal
	 * @param fatherExhibitNumber Exhibit Number of father
	 * @param motherExhibitNumber Exhibit Number of mother
	 * @param height Height of animal
	 * @param weight Weight of animal
	 * @param length Length of animal
	 * @param dateOfBirth Date of birth of animal
	 * @param dateOfArrival Date of Arrival of animal
	 * @param typesSet Collection of types which the animal belongs to
	 * @param flight Boolean that says whether the animal is capable of flying
	 * @return a string that resulted in the attempt to add
	 */
	
	public String addNewAnimal(Gender gender, long fatherExhibitNumber, long motherExhibitNumber, double height,
			double weight, double length, String dateOfBirth, String dateOfArrival, Set<AnimalType> typesSet, boolean flight) {

//		falta implementar no manager
//		
//		return manager.addAnimal(gender, fatherExhibitNumber, motherExhibitNumber, height,
//				weight, length, dateOfBirth, dateOfArrival, typesSet, flight);
		
		return null;

	}
	
	/**
	 * Adds a new animal in the management system according to these parameters.
	 * @param gender Gender of the animal
	 * @param height Height of animal
	 * @param weigth Weight of animal
	 * @param length Length of animal
	 * @param dateOfBirth Date of birth of animal
	 * @param dateOfArrival Date of Arrival of animal
	 * @param typesSet Collection of types which the animal belongs to
	 * @param flight Boolean that says whether the animal is capable of flying 
	 * @return a string that resulted in the attempt to add
	 */
	
	public String addNewAnimal(Gender gender, double height, double weight, double length, String dateOfBirth,
			String dateOfArrival, Set<AnimalType> typesSet, boolean flight) {

//		falta implementar no manager 
//		
//		return manager.addAnimal(gender, height, weight, length, dateOfBirth,
//				dateOfArrival, typesSet, flight);
		
		return null;

	}
	
	/**
	 * Adds a Zoo Keeper in the management system
	 * @param qualified String that defines whether the keeper is qualified or not
	 * @param name String with keeper name
	 * @return String that resulted in the attempt to add
	 */
	
	public String addNewKeeper(String qualified, String name) {

		return manager.addZooKeeper(qualified, name);

	}
	
	
	/**
	 * Updates attributes of an animal
	 * @param animalExhibitNumber Exhibit Number of the animal
	 * @param attributteToUpdate attribute to update
	 * @param newValue new value of the attribute
	 * @return String with result of attempted update
	 */
	
	public String updateAnimal(long animalExhibitNumber, String attributteToUpdate, String newValue) {

		return manager.updateAnimal(animalExhibitNumber, attributteToUpdate, newValue);

	}
	
	public String updateKeeper() {

		// falta implementar no manager
		return null;

	}

}
