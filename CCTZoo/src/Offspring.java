
public class Offspring {
	
	private Animal father;
	private Animal mother;
	
	
	public Offspring(Animal father,Animal mother) {
		this.father = father;
		this.mother = mother;
	}


	public Animal getFather() {
		return father;
	}


	public Animal getMother() {
		return mother;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + ((mother == null) ? 0 : mother.hashCode());
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
		if (father == null) {
			if (other.father != null)
				return false;
		} else if (!father.equals(other.father))
			return false;
		if (mother == null) {
			if (other.mother != null)
				return false;
		} else if (!mother.equals(other.mother))
			return false;
		return true;
	}
	
	
	

}
