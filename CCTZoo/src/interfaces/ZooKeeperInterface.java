package interfaces;
import java.util.Map;
import java.util.Set;
import cctZoo.entities.Animal;
import cctZoo.enums.AnimalType;

public interface ZooKeeperInterface {

	void setQualificado(boolean answer);

	boolean getQualificado();

	String alocarAnimal(Animal animal);

	Animal desalocarAnimal(long id);

	boolean typesExceedSize(Set<AnimalType> animalTypes);

	int hashCode();

	boolean equals(Object obj);

	Map<Long, Animal> getAnimaisSobGuarda();

	Set<AnimalType> getTypes();

	String getName();

	int getId();

}
