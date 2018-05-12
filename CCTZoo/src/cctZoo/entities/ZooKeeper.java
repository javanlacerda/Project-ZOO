package cctZoo.entities;

import java.util.HashSet;
import java.util.Set;

import cctZoo.enums.AnimalType;
import exceptions.AnimalNotUnderGuardException;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
import exceptions.NumberOfAnimalsExceededException;
import exceptions.NumberOfTypesExceededException;
import interfaces.ZooKeeperInterface;
import utils.Auxiliar;

public class ZooKeeper implements ZooKeeperInterface {

	final private int MAX_TYPES = 3;
	final private int NUMBER_OF_ANIMALS = 10;

	private boolean qualified;
	private Set<Long> animalsUnderGuard;
	private Set<AnimalType> types;
	private String name;
	private int id;

	public ZooKeeper(boolean qualified, String name, int id) throws InvalidNameException, InvalidIdException {
		validateAtributes(name, id);
		this.animalsUnderGuard = new HashSet<>();
		this.types = new HashSet<>();
		this.qualified = qualified;
		this.name = name;
		this.id = id;
	}

	private void validateAtributes(String name, int id) throws InvalidNameException, InvalidIdException {
		utils.Validate.validateName(name);
		utils.Validate.validateId(id);
	}

	public void setQualified(boolean answer) {

		this.qualified = answer;

	}

	public boolean isQualified() {

		return this.qualified;
	}

	public String alocateAnimal(long animalExhibitId, Set<AnimalType> animalTypes)
			throws NumberOfAnimalsExceededException, NumberOfTypesExceededException {

		if ((types.size() < MAX_TYPES || containsTypesAnimal(animalTypes)) && !typesExceedSize(animalTypes)) {

			if (animalsUnderGuard.size() < NUMBER_OF_ANIMALS) {

				animalsUnderGuard.add(animalExhibitId);
				types.addAll(animalTypes);

			} else

				throw new NumberOfAnimalsExceededException();

		}

		else
			throw new NumberOfTypesExceededException();

		return "Animal Registered!";
	}

	public void deallocateAnimal(long animalExhibitId) throws AnimalNotUnderGuardException {

		if (animalsUnderGuard.contains(animalExhibitId)) {

			animalsUnderGuard.remove(animalExhibitId);

		} else
			throw new AnimalNotUnderGuardException();

	}

	private boolean typesExceedSize(Set<AnimalType> animalTypes) {

		return (animalTypes.size() + this.types.size()) <= MAX_TYPES;

	}

	private boolean containsTypesAnimal(Set<AnimalType> animalTypes) {

		for (AnimalType type : animalTypes) {

			if (!types.contains(type))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZooKeeper other = (ZooKeeper) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Set<Long> getAnimalsUnderGuard() {
		return animalsUnderGuard;
	}

	public Set<AnimalType> getTypes() {
		return types;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getNumberOfAnimalsAlocated() {

		return animalsUnderGuard.size();

	}

	@Override
	public String toString() {
		String qualified;

		if (isQualified())
			qualified = "Yes";
		else
			qualified = "No";

		return "Name: " + this.name + Auxiliar.BREAK_LINE + "ID: " + this.id + Auxiliar.BREAK_LINE + "Qualified: "
				+ qualified + Auxiliar.BREAK_LINE + "Number of animals alocated: " + getNumberOfAnimalsAlocated();

	}

}
