import java.time.LocalDate;
import java.util.Set;

public abstract class Animal {

	private String name;
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
	
	public Animal(String name, Gender gender, Offspring offSpring, double height, double weigth, double length,
			LocalDate dateOfBirth, LocalDate dateOfArrival, Set<Vaccine> vaccineSet, Set<Medication> medicationSet, long exhibitNumber) {
		
		this.name = name;
		this.gender = gender;
		this.offSpring = offSpring;
		this.height = height;
		this.weigth = weigth;
		this.length = length;
		this.dateOfBirth = dateOfBirth;
		this.dateOfArrival = dateOfArrival;
		this.vaccineSet = vaccineSet;
		this.medicationSet = medicationSet;
		this.exhibitNumber = exhibitNumber;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Offspring getOffSpring() {
		return offSpring;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public LocalDate getDateOfArrival() {
		return dateOfArrival;
	}

	public long getExhibitNumber() {
		return exhibitNumber;
	}
	
	
	public Animal(String nome, Gender gENDER, double height, double weigth, double length, LocalDate dateOfBirth,
			LocalDate dateOfArrival, Set vaccineSet) {
		super();
		this.nome = nome;
		GENDER = gENDER;
		this.height = height;
		this.weigth = weigth;
		this.length = length;
		this.dateOfBirth = dateOfBirth;
		this.dateOfArrival = dateOfArrival;
		this.vaccineSet = vaccineSet;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}


