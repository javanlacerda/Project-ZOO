
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Animal {

	private Gender gender;
	private Offspring offSpring;
	private double height;
	private double weigth;
	private double length;
	private LocalDate dateOfBirth;
	private LocalDate dateOfArrival;
	private Set<Vaccine> vaccineSet;
	private Set<Medication> medicationSet;
	private long exhibitNumber;
	private Set<AnimalType> typesSet;

	public Animal(Gender gender, Offspring offSpring, double height, double weigth, double length,
			LocalDate dateOfBirth, LocalDate dateOfArrival, long exhibitNumber, Set<AnimalType> typesSet) {

		this.gender = gender;
		this.offSpring = offSpring;
		this.height = height;
		this.weigth = weigth;
		this.length = length;
		this.dateOfBirth = dateOfBirth;
		this.dateOfArrival = dateOfArrival;
		this.vaccineSet = new HashSet<>();
		this.medicationSet = new HashSet<>();
		this.exhibitNumber = exhibitNumber;
		this.typesSet = typesSet;
	}

	public Animal(Gender gender, Offspring offSpring, double height, double weigth, double length,
			LocalDate dateOfBirth, LocalDate dateOfArrival, long exhibitNumber, String fligth) {

		this.gender = gender;
		this.offSpring = offSpring;
		this.height = height;
		this.weigth = weigth;
		this.length = length;
		this.dateOfBirth = dateOfBirth;
		this.dateOfArrival = dateOfArrival;
		this.vaccineSet = new HashSet<>();
		this.medicationSet = new HashSet<>();
		this.exhibitNumber = exhibitNumber;

		new Animal.Avian(fligth);

	}

	public static class Avian {

		public static String flight;

		public Avian(String flight) {

			Avian.flight = flight;
		}
	}

	public String getFlight() {
		try {
			if (Avian.flight != null) {

				return Avian.flight;

			} else {

				throw new NullPointerException("This animal isn't an Avian!");

			}
		} catch (NullPointerException exception) {

			return exception.getMessage();

		}
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeigth() {
		return this.weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Gender getGender() {
		return this.gender;
	}

	public Offspring getOffSpring() {
		return this.offSpring;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public LocalDate getDateOfArrival() {
		return this.dateOfArrival;
	}

	public long getExhibitNumber() {
		return this.exhibitNumber;
	}

	public Set<AnimalType> getTypes() {
		return this.typesSet;
	}

	public Set<Medication> getMedicationSet() {
		return this.medicationSet;
	}

	public Set<Vaccine> getVaccineSet() {
		return this.vaccineSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (exhibitNumber ^ (exhibitNumber >>> 32));
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
		Animal other = (Animal) obj;
		if (exhibitNumber != other.exhibitNumber)
			return false;
		return true;
	}

}
