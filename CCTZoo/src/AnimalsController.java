import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Exceptions.Animal.InvalidExhibitNumberException;
import Exceptions.Animal.InvalidHeightException;
import Exceptions.Animal.InvalidLengthException;
import Exceptions.Animal.InvalidWeightException;

public class AnimalsController {

	private Map<Long, Animal> animalsMap;
	private long exhibitNumber;

	public AnimalsController() {
		this.animalsMap = new HashMap<>();
		this.exhibitNumber = 0;
	}

	public String addAnimal(Gender gender, Animal father,Animal mother, double height, double weigth, double length,
			LocalDate dateOfBirth, LocalDate dateOfArrival, Set<AnimalType> typesSet) {

		String status = "Animal added with sucessfull!";
		Offspring offSpring = new Offspring(father, mother);

		Animal animal;
		try {
			animal = new Animal(gender, offSpring, height, weigth, length, dateOfBirth, dateOfArrival, exhibitNumber++,
					typesSet);
			animalsMap.put(animal.getExhibitNumber(), animal);
		} catch (InvalidExhibitNumberException | InvalidHeightException | InvalidWeightException
				| InvalidLengthException e) {
			status = e.getMessage();
		}

		return status;

	}

}
