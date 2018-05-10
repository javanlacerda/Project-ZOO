package cctZoo.entities;

public class Offspring {

	private long fatherExhibitNumber;
	private long motherExhibitNumber;

	public Offspring(long fatherExhibitNumber, long motherExhibitNumber) {
		this.fatherExhibitNumber = fatherExhibitNumber;
		this.motherExhibitNumber = motherExhibitNumber;
	}

	public Offspring() {
		this.fatherExhibitNumber = -1;
		this.motherExhibitNumber = -1;
	}

	public long getFatherExhibitNumber() {
		return fatherExhibitNumber;
	}

	public void setFatherExhibitNumber(long fatherExhibitNumber) {
		this.fatherExhibitNumber = fatherExhibitNumber;
	}

	public long getMotherExhibitNumber() {
		return motherExhibitNumber;
	}

	public void setMotherExhibitNumber(long motherExhibitNumber) {
		this.motherExhibitNumber = motherExhibitNumber;
	}

	public boolean isEmpty() {
		return this.motherExhibitNumber == -1 && this.fatherExhibitNumber == -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (fatherExhibitNumber ^ (fatherExhibitNumber >>> 32));
		result = prime * result + (int) (motherExhibitNumber ^ (motherExhibitNumber >>> 32));
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
		Offspring other = (Offspring) obj;
		if (fatherExhibitNumber != other.fatherExhibitNumber)
			return false;
		if (motherExhibitNumber != other.motherExhibitNumber)
			return false;
		return true;
	}

}
