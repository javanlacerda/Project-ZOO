package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cctZoo.Facade;
import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;

public class CSVController {

	

	private ArrayList<String[]> run(String csvFile) {

		ArrayList<String[]> out = new ArrayList<String[]>();

		BufferedReader br = null;
		String line = "";
		String csvDivisor = ",";
		try {

			br = new BufferedReader(new FileReader(csvFile));

			while ((line = br.readLine()) != null) {

				String[] lineSplited = line.split(csvDivisor);

				out.add(lineSplited);

			}

			return out;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return out;

	}

	public void importFilesToSystem(Facade facade) {
		
		for (String[] keeper : run("keepers.csv")) {

			facade.addNewKeeper(keeper[0], keeper[1]);
		}

		for (String[] animal : run("animals.csv")) {

			boolean flight = Boolean.parseBoolean(animal[9].trim());
			int idKeeper = Integer.parseInt(animal[0]);
			String species = animal[1].trim();
			Gender gender = Gender.valueOf(animal[2].trim());
			double height = Double.parseDouble(animal[3].trim());
			double weight = Double.parseDouble(animal[4].trim());
			double length = Double.parseDouble(animal[5].trim() + "");
			String dateOfBirth = animal[6].trim();
			String dateOfArrival = animal[7].trim();

			Set<AnimalType> typesSet = new HashSet<AnimalType>();
			typesSet.add(AnimalType.valueOf(animal[8].trim()));

			facade.addNewAnimal(idKeeper, species, gender, height, weight, length, dateOfBirth, dateOfArrival, typesSet,
					flight);

		}
	}

}