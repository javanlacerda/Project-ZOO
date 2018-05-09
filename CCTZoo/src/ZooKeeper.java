import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZooKeeper {

	final private int maxTypes = 3;
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

			animaisSobGuarda.put(animal.getExhibitNumber(), animal);
			types.add(animal.getType());

		} else {

			throw new Exception();
		}

	}

}
