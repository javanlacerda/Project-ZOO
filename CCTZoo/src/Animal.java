import java.time.LocalDate;
import java.util.Set;

public abstract class Animal {

	private String nome;
	private Gender GENDER;
	private double height;
	private double weigth;
	private double length;
	private LocalDate dateOfBirth;
	private LocalDate dateOfArrival;
	private Set vaccineSet;
	
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


