import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZooKeeper {

	final private int MAX_TYPES = 3;
	final private int NUMBER_OF_ANIMALS = 10;

	private boolean qualificado;
	private Map<Long, Animal> animaisSobGuarda;
	private Set<AnimalType> types;
	private String name;
	private int id;

	public ZooKeeper(boolean qualificado, String name, int id) {
		this.animaisSobGuarda = new HashMap<>();
		this.types = new HashSet<>();
		this.qualificado = qualificado;
		this.name = name;
		this.id = id;
	}

	public void setQualificado(boolean answer) {

		this.qualificado = answer;

	}

	public boolean getQualificado() {

		return this.qualificado;
	}

	public void alocarAnimal(Animal animal) throws Exception {

		if ((types.size() < MAX_TYPES ||  containsTypesAnimal(animal.getTypes())) && !typesExceedSize(animal.getTypes())) {

			if (animaisSobGuarda.size() < NUMBER_OF_ANIMALS) {

				animaisSobGuarda.put(animal.getExhibitNumber(), animal);
				types.addAll(animal.getTypes());

			} else {

				throw new Exception("Number of animals exceded!");
			}
		} else {

			throw new Exception("Numeber of types exceded!");
		}

	}
	
	
	private boolean typesExceedSize(Set<AnimalType> animalTypes) {
		return (animalTypes.size() + this.types.size()) <= MAX_TYPES;
	}
	
	private boolean containsTypesAnimal(Set<AnimalType> animalTypes) {
		
		for(AnimalType type: animalTypes) {
			
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

	public Map<Long, Animal> getAnimaisSobGuarda() {
		return animaisSobGuarda;
	}

	public void setAnimaisSobGuarda(Map<Long, Animal> animaisSobGuarda) {
		this.animaisSobGuarda = animaisSobGuarda;
	}

	public Set<AnimalType> getTypes() {
		return types;
	}

	public void setTypes(Set<AnimalType> types) {
		this.types = types;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
