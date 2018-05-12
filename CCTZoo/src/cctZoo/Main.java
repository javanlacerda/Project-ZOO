package cctZoo;


import java.util.HashSet;

import java.util.Set;

import cctZoo.controllers.ZooKeepersController;

import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
import cctZoo.zooManagement.ZooManagement;
import utils.CSVReader;

public class Main {

	public static void main(String[] args) {

		CSVReader reader = new CSVReader();
		ZooKeepersController zKController = new ZooKeepersController();
		ZooManagement zManagement = new ZooManagement();

		for (String[] keeper : reader.run("keepers.csv")) {

			zKController.addZooKeeper(Boolean.parseBoolean(keeper[0].trim()), keeper[1]);
		}

		for (String[] animal : reader.run("animals.csv")) {
			
			boolean flight = Boolean.parseBoolean(animal[9].trim());
			int idKeeper = Integer.parseInt(animal[0]);
			String species = animal[1].trim(); 
			Gender gender = Gender.valueOf(animal[2].trim());
			double height = Double.parseDouble(animal[3].trim());
			double weight = Double.parseDouble(animal[4].trim());
			double length = Double.parseDouble(animal[5].trim());
			String dateOfBirth = animal[6].trim();	
			String dateOfArrival = animal[7].trim();	

			Set<AnimalType> typesSet = new HashSet<AnimalType>();
			typesSet.add(AnimalType.valueOf(animal[8].trim()));
			
			
		zManagement.addAnimal(idKeeper,species, gender, height, weight, length, dateOfBirth, dateOfArrival, typesSet, flight);

		}
		
		
		System.out.println(zManagement.getListingOfAnimals());
		
		

	}

}
