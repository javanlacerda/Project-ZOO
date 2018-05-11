package interfaces;

import java.util.Set;
import cctZoo.enums.AnimalType;
import exceptions.NumberOfAnimalsExceededException;
import exceptions.NumberOfTypesExceededException;

public interface ZooKeeperInterface {

	void setQualified(boolean answer);

	boolean isQualified();

	String alocateAnimal(long animalExhibitId, Set<AnimalType> animalTypes)
			throws NumberOfAnimalsExceededException, NumberOfTypesExceededException;

	boolean deallocateAnimal(long id);

	int hashCode();

	boolean equals(Object obj);

	Set<Long> getAnimalsUnderGuard();

	Set<AnimalType> getTypes();

	String getName();

	int getId();

}