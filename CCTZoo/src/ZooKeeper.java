import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZooKeeper {

	final private int maxTypes = 3;
	final private int numberOfAnimals = 10;

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

		if (types.size() < maxTypes || types.contains(animal.getType())) {

			if (animaisSobGuarda.size() < 10) {

				animaisSobGuarda.put(animal.getExhibitNumber(), animal);
				types.add(animal.getType());

			} else {

				throw new Exception("Number of animals exceded!");
			}
		} else {

			throw new Exception("Numeber of types exceded!");
		}

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

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
