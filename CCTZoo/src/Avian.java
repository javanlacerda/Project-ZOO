import java.time.LocalDate;
import java.util.Set;

public class Avian extends Animal {

	public Avian(String nome, Gender GENDER, double height, double weigth, double length, LocalDate dateOfBirth,
			LocalDate dateOfArrival, Set vaccineSet) {

		super(nome, GENDER, length, length, length, dateOfArrival, dateOfArrival, vaccineSet);

	}

}
