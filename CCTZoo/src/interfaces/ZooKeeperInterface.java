package interfaces;
import java.util.Map;
import java.util.Set;
import cctZoo.entities.Animal;
import cctZoo.enums.AnimalType;

public interface ZooKeeperInterface {

	void setQualificado(boolean answer);

	String getQualificado();

	String alocarAnimal(Animal animal);

	boolean desalocarAnimal(long id);

	boolean typesExceedSize(Set<AnimalType> animalTypes);

	int hashCode();

	boolean equals(Object obj);

	Set<Long> getAnimaisSobGuarda();

	Set<AnimalType> getTypes();

	String getName();

	int getId();

}
