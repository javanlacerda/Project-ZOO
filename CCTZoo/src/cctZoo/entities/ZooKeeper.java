package cctZoo.entities;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cctZoo.enums.AnimalType;
import interfaces.ZooKeeperInterface;

public class ZooKeeper implements ZooKeeperInterface {

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

	public String alocarAnimal(Animal animal) {

		try {
			
		if ((types.size() < MAX_TYPES || containsTypesAnimal(animal.getTypes())) && !typesExceedSize(animal.getTypes())) {

			if (animaisSobGuarda.size() < NUMBER_OF_ANIMALS) {

				animaisSobGuarda.put(animal.getExhibitNumber(), animal);
				types.addAll(animal.getTypes());

			} else {

				throw new RuntimeException("Number of animals exceded!");
			}
		} else {

			throw new RuntimeException("Numeber of types exceded!");
		}
		} catch (RuntimeException exception) {
			
			return exception.getMessage();
		}
		
		return "Animal cadastrado!";
	}
	

	public Animal desalocarAnimal(long id) {
		
		Animal animal = null;
		
		if (animaisSobGuarda.containsKey(id)) {
			
			animal = animaisSobGuarda.get(id);
			
		} if (animal == null) {
			
			throw new IllegalArgumentException("Unknown key!");
		
		} else {
			
			return animal;
		}
		 
	}
	
	@Override
	public boolean typesExceedSize(Set<AnimalType> animalTypes) {
		
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

	public Set<AnimalType> getTypes() {
		return types;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}


}
