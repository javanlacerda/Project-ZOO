package cctZoo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cctZoo.entities.ZooKeeper;
import cctZoo.enums.AnimalType;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
import exceptions.NumberOfAnimalsExceededException;
import exceptions.NumberOfTypesExceededException;

public class ZooKeepersController {

	private Map<Integer, ZooKeeper> zooKeepersMap;
	private int serialId;

	public ZooKeepersController() {
		this.zooKeepersMap = new HashMap<>();
		this.serialId = 0;
	}

	public String addZooKeeper(boolean qualified, String name) {

		String status;
		ZooKeeper zKeeper;

		try {
			zKeeper = new ZooKeeper(qualified, name, serialId++);
			zooKeepersMap.put(zKeeper.getId(), zKeeper);
			status = "Kepper registered with Sucessfull!";
		} catch (InvalidNameException | InvalidIdException e) {
			status = e.toString();
		}

		return status;
	}

	public String allocateAnimal(int idKeeper, long animalExhibitId, Set<AnimalType> animalTypes) {
		String status;

		if (hasKeeper(idKeeper)) {
			ZooKeeper keeper = zooKeepersMap.get(idKeeper);

			if (keeper.isQualified()) {

				try {
					status = keeper.alocateAnimal(animalExhibitId, animalTypes);
				} catch (NumberOfAnimalsExceededException | NumberOfTypesExceededException e) {
					status = e.toString();
				}
			} else
				status = "Keeper Unqualified!";

		}

		else
			status = "Keeper Unregistered!";

		return status;

	}
	
	
	public String deallocateAnimal(int idKeeper, long animalExhibitId) {
		String status;

		if (hasKeeper(idKeeper)) {
			ZooKeeper keeper = zooKeepersMap.get(idKeeper);
			
			if(keeper.deallocateAnimal(animalExhibitId))
				status = "Animal deallocated with Sucessfull!";
			else
				status = "Animal not Allocated in this Keeper!";
		}
		else
			status = "Keeper Unregistered!";

		return status;
		
	}

	public String setKeeperQualified(int idKeeper, boolean answer) {
		String status;

		if (hasKeeper(idKeeper)) {
			ZooKeeper keeper = zooKeepersMap.get(idKeeper);
			keeper.setQualified(answer);
			status = "Keeper Qualified updated!";

		} else
			status = "Keeper Unregistered!";

		return status;

	}

	public boolean hasKeeper(int id) {
		return zooKeepersMap.containsKey(id);
	}

}
