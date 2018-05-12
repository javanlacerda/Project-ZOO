package interfaces;

import java.util.Set;
import cctZoo.enums.AnimalType;
import exceptions.AnimalNotUnderGuardException;
import exceptions.NumberOfAnimalsExceededException;
import exceptions.NumberOfTypesExceededException;

public interface ZooKeeperInterface {

	void setQualified(boolean answer);

	boolean isQualified();

	String alocateAnimal(long animalExhibitId, Set<AnimalType> animalTypes)
			throws NumberOfAnimalsExceededException, NumberOfTypesExceededException;

	void deallocateAnimal(long id) throws AnimalNotUnderGuardException;

	int hashCode();

	boolean equals(Object obj);

	Set<Long> getAnimalsUnderGuard();



	String getName();

	int getId();

}
