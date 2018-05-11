package cctZoo.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cctZoo.enums.AnimalType;
import interfaces.ZooKeeperInterface;
import utils.Auxiliar;

public class ZooKeeper implements ZooKeeperInterface {

	final private int MAX_TYPES = 3;
	final private int NUMBER_OF_ANIMALS = 10;

	private boolean qualificado;
	private Set<Long> animaisSobGuarda;
	private Set<AnimalType> types;
	private String name;
	private int id;

	public ZooKeeper(boolean qualificado, String name, int id) {
		this.animaisSobGuarda = new HashSet<>();
		this.types = new HashSet<>();
		this.qualificado = qualificado;
		this.name = name;
		this.id = id;
	}

	public void setQualificado(boolean answer) {

		this.qualificado = answer;

	}

	public String getQualificado() {

		if (this.qualificado)
			return "Yes";
		else
			return "No";
	}

	public String alocarAnimal(Animal animal) {

		try {

			if ((types.size() < MAX_TYPES || containsTypesAnimal(animal.getTypes()))
					&& !typesExceedSize(animal.getTypes())) {

				if (animaisSobGuarda.size() < NUMBER_OF_ANIMALS) {

					animaisSobGuarda.add(animal.getExhibitNumber());
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

	public boolean desalocarAnimal(long id) {

		boolean result = false;

		if (animaisSobGuarda.contains(id)) {

			result = animaisSobGuarda.remove(id);

		}
		if (!result) {

			throw new IllegalArgumentException("Unknown key!");

		} else {

			return result;
		}

	}

	@Override
	public boolean typesExceedSize(Set<AnimalType> animalTypes) {

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

	public Set<Long> getAnimaisSobGuarda() {
		return animaisSobGuarda;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + Auxiliar.BREAK_LINE + "ID: " + this.id + Auxiliar.BREAK_LINE + "Qualified: "
				+ getQualificado() + Auxiliar.BREAK_LINE + "Number of animals alocated: " + getNumberOfAnimalsAlocated();

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

		return animaisSobGuarda.size();

	}

}
