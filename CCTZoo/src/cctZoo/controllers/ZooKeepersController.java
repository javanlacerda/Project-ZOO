package cctZoo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cctZoo.entities.ZooKeeper;
import cctZoo.enums.AnimalType;
import exceptions.AnimalNotUnderGuardException;
import exceptions.InexistentKeeperException;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
import exceptions.NumberOfAnimalsExceededException;
import exceptions.NumberOfTypesExceededException;
import exceptions.UnqualifiedKeeperException;
import utils.Auxiliar;

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
		} catch (InvalidNameException e) {
			status = "Invalid Name!";

		} catch (InvalidIdException e) {

			status = "Invalid Id!";
		}

		return status;
	}

	public void allocateAnimal(int idKeeper, long animalExhibitId, Set<AnimalType> animalTypes) throws UnqualifiedKeeperException, NumberOfAnimalsExceededException, NumberOfTypesExceededException, InexistentKeeperException {
		

		if (hasKeeper(idKeeper)) {
			ZooKeeper keeper = zooKeepersMap.get(idKeeper);
			
			if (keeper.isQualified()) 
					keeper.alocateAnimal(animalExhibitId, animalTypes);
			else 
				throw new UnqualifiedKeeperException();
		}
		
		else
			throw new InexistentKeeperException();
				

		

	}

	public String deallocateAnimal(int idKeeper, int newKeeperId, long animalExhibitId, Set<AnimalType> animalTypes) {
		String status;

		if (hasKeeper(idKeeper)) {

			if (hasKeeper(newKeeperId)) {
				ZooKeeper keeper = zooKeepersMap.get(idKeeper);
				ZooKeeper newKeeper = zooKeepersMap.get(newKeeperId);

				try {
					if (keeper.containsAnimalAlocatted(animalExhibitId)) {
						newKeeper.alocateAnimal(animalExhibitId, animalTypes);
						keeper.deallocateAnimal(animalExhibitId);
						status = "Animal deallocated with Sucessfull!";
					}

					else
						throw new AnimalNotUnderGuardException();

				} catch (AnimalNotUnderGuardException e) {
					status = "Animal not Allocated in this Keeper!";
				} catch (NumberOfAnimalsExceededException e) {
					status = "Fail to Deallocated Animal, Number of Animals Exceeded in the new Keeper";
				} catch (NumberOfTypesExceededException e) {
					status = "Fail to Deallocated Animal, Number of Animals Types Exceeded in the new Keeper";
				}
			}

			else
				status = "New Keeper Unregistered!";

		} else
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

	public Set<Long> getAnimalsUnderGuard(int idKeeper) throws InexistentKeeperException {

		if (!hasKeeper(idKeeper))
			throw new InexistentKeeperException();

		ZooKeeper keeper = zooKeepersMap.get(idKeeper);

		return keeper.getAnimalsUnderGuard();

	}

	public String getInfo(int idKeeper) {
		String info;

		if (hasKeeper(idKeeper))
			info = zooKeepersMap.get(idKeeper).toString();

		else
			info = "Keeper Unregistered!";

		return info;

	}

	public String listKeepers() {
		String listing = "";

		if (zooKeepersMap.isEmpty())
			listing += "No Keepers Registered!";
		else {
			
			listing += "Listing of Zoo Keepers: " + Auxiliar.BREAK_LINE + Auxiliar.BREAK_LINE;
			for (ZooKeeper keeper : zooKeepersMap.values())
				listing += keeper.toString();
		}

		return listing;

	}
	
	public boolean canAlocateAnimal (int id, Set<AnimalType> animalTypes) throws InexistentKeeperException, NumberOfAnimalsExceededException, NumberOfTypesExceededException {
		if (!hasKeeper(id)) throw new InexistentKeeperException();
		else return zooKeepersMap.get(id).canAllocate(animalTypes);
	}

	public boolean hasKeeper(int id) {
		return zooKeepersMap.containsKey(id);
	}

}
