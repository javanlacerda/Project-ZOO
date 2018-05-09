import java.time.LocalDate;

public class Vaccine {
	
	private String name;
	private long id;
	private String activePrinciple;
	private LocalDate aplicattionDate;
	
	public Vaccine(String name, long id, String activePrinciple, LocalDate aplicattionDate) {
		this.name = name;
		this.id = id;
		this.activePrinciple = activePrinciple;
		this.aplicattionDate = aplicattionDate;
	}

}
