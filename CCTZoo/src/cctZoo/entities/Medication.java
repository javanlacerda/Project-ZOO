package cctZoo.entities;
import java.time.LocalDate;

import exceptions.InvalidActivePrincipleException;
import exceptions.InvalidDosageException;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;

public class Medication {

	private String name;
	private long id;
	private String activePrinciple;
	private LocalDate aplicattionDate;
	private int dosage;

	public Medication(String name, long id, String activePrinciple, LocalDate aplicattionDate, int dosage)
			throws InvalidIdException, InvalidNameException, InvalidActivePrincipleException, InvalidDosageException {
		validateAtributes(name, id, activePrinciple, dosage);
		this.name = name;
		this.id = id;
		this.activePrinciple = activePrinciple;
		this.aplicattionDate = aplicattionDate;
		this.dosage = dosage;
	}

	private void validateAtributes(String name, long id, String activePrinciple, int dosage)
			throws InvalidIdException, InvalidNameException, InvalidActivePrincipleException, InvalidDosageException {
		utils.Validate.validateId(id);
		utils.Validate.validateName(name);
		utils.Validate.validateActivePrinciple(activePrinciple);
		utils.Validate.validateDosage(dosage);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivePrinciple() {
		return this.activePrinciple;
	}

	public void setActivePrinciple(String activePrinciple) {
		this.activePrinciple = activePrinciple;
	}

	public long getId() {
		return this.id;
	}

	public LocalDate getAplicattionDate() {
		return this.aplicattionDate;
	}

	public int getDosage() {
		return this.dosage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Medication other = (Medication) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + utils.Auxiliar.BREAK_LINE + "ID: " + this.id + utils.Auxiliar.BREAK_LINE
				+ "Active Principle: " + this.activePrinciple + utils.Auxiliar.BREAK_LINE + "Aplicattion Date: "
				+ this.aplicattionDate.toString() + utils.Auxiliar.BREAK_LINE + "Dosage: " + this.dosage
				+ utils.Auxiliar.BREAK_LINE;
	}

}
