package cctZoo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import cctZoo.enums.AnimalType;
import cctZoo.enums.Gender;
import utils.Auxiliar;
import utils.CSVController;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {

		CSVController reader = new CSVController();
		Facade facade = new Facade();
		sc = new Scanner(System.in);
		String input;

		reader.importFilesToSystem(facade);

		do {
			System.out.println(options());
			System.out.print("Option: ");
			input = sc.nextLine();
			selectOption(input, facade);
		}

		while (!input.equals("17"));

	}

	private static void selectOption(String input, Facade facade) {
		switch (input) {
		case "1":
			addNewAnimal(facade);
			return;
		case "2":

			addNewKeeper(facade);

			return;
		case "3":
			searchForKeeper(facade);

			return;
		case "4":
			searchForAnimal(facade);
			return;
		case "5":
			updateAnimal(facade);
			return;
		case "6":
			// cadastrarAnimais(facade);
			return;
		case "7":
			listAllAnimals(facade);
			return;
		case "8":
			// cadastrarAnimais(facade);
			return;
		case "9":
			addAnimalMedication(facade);
			return;
		case "10":
			removeAnimalMedication(facade);
			return;
		case "11":
			addAnimalVaccine(facade);
			return;
		case "12":
			getAnimalParents(facade);
			return;
		case "13":
			getListingOfMedications(facade);
			return;
		case "14":
			getAnimalListingOfVaccines(facade);
			return;
		case "15":
			zooKeeperRealocateAnimal(facade);
			return;
		case "16":
			getAnimalUnderKeepGuard(facade);
			return;
		case "17":
			return;

		default:
			System.out.println("Invalid Option!");
			return;
		}
	}

	private static String options() {
		return Auxiliar.BREAK_LINE + "Options: " + Auxiliar.BREAK_LINE + "(2) - Add New ZooKeeper" + Auxiliar.BREAK_LINE
				+ "(9) - Add Animal Medication" + Auxiliar.BREAK_LINE + "(10) - Remove Animal Medication"
				+ Auxiliar.BREAK_LINE + "(11) - Add Animal Vaccine" + Auxiliar.BREAK_LINE + "(12) - Get Animal Parents"
				+ Auxiliar.BREAK_LINE + "(13) - Get Listing Of Medications" + Auxiliar.BREAK_LINE
				+ "(14) - Get Listing Of Vaccines" + Auxiliar.BREAK_LINE + "(15) - Zoo Keeper Realocate Animal"
				+ Auxiliar.BREAK_LINE + "(16) - Get Animal Under Keep Guard" + Auxiliar.BREAK_LINE + "(17) - Exit"
				+ Auxiliar.BREAK_LINE;
	}

	private static void addNewAnimal(Facade facade) {

		long fatherExhibitNumber = -1;
		long motherExhibitNumber = -1;
		int idKeeperInt;
		Gender genderG;
		double heightH;
		double weightW;
		double lengthL;

		boolean flight = false;
		System.out.print("Id of the keeper who will be responsible for the animal: ");
		String idKeeper = sc.nextLine();

		try {
			idKeeperInt = Integer.parseInt(idKeeper);
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid ID Keeper!");
			return;
		}

		System.out.print("Specie of the animal: ");
		String specie = sc.nextLine();
		System.out.print("Gender (MALE or FEMALE): ");
		String gender = sc.nextLine();

		try {
			genderG = Gender.valueOf(gender);
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Gender!");
			return;
		}

		System.out.print("Height: ");
		String height = sc.nextLine();

		try {
			heightH = Double.parseDouble(height);
		}

		catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Height!");
			return;
		}

		System.out.print("Weight: ");
		String weight = sc.nextLine();

		try {
			weightW = Double.parseDouble(weight);
		}

		catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Weight!");
			return;
		}

		System.out.print("Length: ");
		String length = sc.nextLine();

		try {
			lengthL = Double.parseDouble(length);
		}

		catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Length!");
			return;
		}

		System.out.print("Date of birth (dd/mm/yyyy): ");
		String dateOfBirth = sc.nextLine();

		System.out.print("Date of arrival (dd/mm/yyyy): ");
		String dateOfArrival = sc.nextLine();

		System.out.print("Does the animal have parents registered? (YES or NO) ");

		String answer = sc.nextLine();

		switch (answer.toUpperCase()) {

		case "YES":
			System.out.print("Father's exhibit number: ");
			String fExhibitNumber = sc.nextLine();

			try {
				fatherExhibitNumber = Long.parseLong(fExhibitNumber);
			} catch (Exception e) {
				System.out.println(Auxiliar.BREAK_LINE + "Invalid Father Exhibit Number!");
				return;
			}

			System.out.print("Mother's exhibit number: ");
			String mExhibitNumber = sc.nextLine();
			try {
				motherExhibitNumber = Long.parseLong(mExhibitNumber);
			} catch (Exception e) {
				System.out.println(Auxiliar.BREAK_LINE + "Invalid Mother Exhibit Number!");
				return;
			}
			break;

		case "NO":
			break;

		default:
			System.out.println("Invalid, will be considered as NOT!");
			answer = "NO";
			break;
		}

		Set<AnimalType> types = new HashSet<AnimalType>();
		System.out.println("Select the type(s) of animal: ");
		System.out.println("1-MAMMAL/ 2-AVIAN/ 3-AQUATIC/ 4-INSECT/ 5-REPTILE/ 6-OUT");

		String type = "";

		do {

			System.out.print("Select one option: ");
			type = sc.nextLine();

			switch (type) {

			case "1":
				types.add(AnimalType.valueOf("MAMMAL"));
				break;

			case "2":
				types.add(AnimalType.valueOf("AVIAN"));
				System.out.println("the animal flies?(YES or NO)");
				String ans = sc.nextLine();

				switch (ans.toUpperCase()) {

				case "YES":
					flight = true;
					break;

				default:
					break;

				}
				break;

			case "3":
				types.add(AnimalType.valueOf("AQUATIC"));
				break;

			case "4":
				types.add(AnimalType.valueOf("INSECT"));
				break;

			case "5":
				types.add(AnimalType.valueOf("REPTILE"));
				break;
			case "6":
				break;

			default:
				System.out.println("Invalid option!");
				break;

			}
		} while (!type.equals("6"));

		switch (answer) {
		case "YES":
			System.out.println(facade.addNewAnimal(idKeeperInt, specie, genderG, fatherExhibitNumber,
					motherExhibitNumber, heightH, weightW, lengthL, dateOfBirth, dateOfArrival, types, flight));
			break;
		case "NO":
			System.out.println(facade.addNewAnimal(idKeeperInt, specie, genderG, heightH, weightW, lengthL, dateOfBirth,
					dateOfArrival, types, flight));
			break;
		}
	}

	private static void searchForKeeper(Facade facade) {

		System.out.println("Type the ID of ZOO KEEPER you are looking for: ");
		int id;
		try {
			String idK = sc.nextLine();
			id = Integer.parseInt(idK);

		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Keeper ID");
			return;
		}
		System.out.println(facade.searchForKeeper(id) + Auxiliar.BREAK_LINE);

	}

	private static void searchForAnimal(Facade facade) {

		System.out.println("Type the EXHIBIT NUMBER of animal you are looking for: ");
		long exhibitNumber = sc.nextLong();
		System.out.println(facade.searchForAnimal(exhibitNumber));

	}

	private static void addNewKeeper(Facade facade) {

		try {
			System.out.print("Name of the ZooKeeper: ");

			String name = sc.nextLine();

			if (name.trim().equals(""))
				throw new IllegalArgumentException("Invalid name!");
			else {
				System.out.println("Is the zoo keeper qualified? (YES or NO)");

				String qualified = sc.nextLine();

				if (!qualified.toUpperCase().equals("YES") && !qualified.toUpperCase().equals("NO")) {

					throw new IllegalArgumentException("Qualified invalid!");
				} else {

					facade.addNewKeeper(qualified, name);
				}

			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());
		}
	}

	private static void updateAnimal(Facade facade) {

		// public String updateAnimal(long animalExibitNumber, String
		// attributteToUpdate, String newValue) {

		System.out.print("Animal exhibit number: ");
		String numEhxibit = sc.nextLine();

		// if (numEhxibit.trim().equals())

		try {
			System.out.print("Animal exhibit number: ");
			long animalExhibitNumber = sc.nextLong();

			System.out.print("Attributte to update: ");
			String attributteToUpdate = sc.nextLine();

			System.out.print("New value: ");
			String newValue = sc.nextLine();

			facade.updateAnimal(animalExhibitNumber, attributteToUpdate, newValue);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	private static void addAnimalMedication(Facade facade) {
		long animalExhibitNumber;
		long medicationID;
		int dosageInt;

		System.out.println("Add Animal Medication: " + Auxiliar.BREAK_LINE);
		System.out.print("Animal Exhibit Number: ");
		String exhibitNumber = sc.nextLine();
		System.out.print("Medication Name: ");
		String medicationName = sc.nextLine();
		System.out.print("Medication ID: ");
		String medicationId = sc.nextLine();
		System.out.print("Active Principle: ");
		String activePrinciple = sc.nextLine();
		System.out.print("Aplicattion Datte: ");
		String aplicattionDate = sc.nextLine();
		System.out.print("Dosage: ");
		String dosage = sc.nextLine();

		try {
			animalExhibitNumber = Long.parseLong(exhibitNumber.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Animal Exhibit Number!");
			return;
		}

		try {
			medicationID = Long.parseLong(medicationId.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Medication ID!");
			return;
		}

		try {
			dosageInt = Integer.parseInt(dosage.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Dosage!");
			return;
		}

		System.out.println(facade.addAnimalMedication(animalExhibitNumber, medicationName, medicationID,
				activePrinciple, aplicattionDate, dosageInt));

	}

	private static void removeAnimalMedication(Facade facade) {
		long animalExhibitNumber;
		long medicationID;

		System.out.println("Remove Animal Medication: " + Auxiliar.BREAK_LINE);
		System.out.print("Animal Exhibit Number: ");
		String exhibitNumber = sc.nextLine();
		System.out.print("Medication ID: ");
		String medicationId = sc.nextLine();

		try {
			animalExhibitNumber = Long.parseLong(exhibitNumber.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Animal Exhibit Number!");
			return;
		}

		try {
			medicationID = Long.parseLong(medicationId.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Medication ID!");
			return;
		}

		System.out.println(facade.removeAnimalMedication(animalExhibitNumber, medicationID));
	}

	private static void addAnimalVaccine(Facade facade) {
		long animalExhibitNumber;
		long vaccineID;
		int dosageInt;

		System.out.println("Add Animal Vaccine: " + Auxiliar.BREAK_LINE);

		System.out.print("Animal Exhibit Number: ");
		String exhibitNumber = sc.nextLine();
		System.out.print("Vaccine Name: ");
		String vaccineName = sc.nextLine();
		System.out.print("Vaccine ID: ");
		String vaccineId = sc.nextLine();
		System.out.print("Active Principle: ");
		String activePrinciple = sc.nextLine();
		System.out.print("Aplicattion Datte: ");
		String aplicattionDate = sc.nextLine();
		System.out.print("Dosage: ");
		String dosage = sc.nextLine();

		try {
			animalExhibitNumber = Long.parseLong(exhibitNumber.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Animal Exhibit Number!");
			return;
		}

		try {
			vaccineID = Long.parseLong(vaccineId.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Medication ID!");
			return;
		}

		try {
			dosageInt = Integer.parseInt(dosage.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Dosage!");
			return;
		}

		System.out.println(facade.addAnimalVaccine(animalExhibitNumber, vaccineName, vaccineID, activePrinciple,
				aplicattionDate, dosageInt));
	}

	private static void getAnimalParents(Facade facade) {
		long animalExhibitNumber;

		System.out.println("Get Animal Parents: " + Auxiliar.BREAK_LINE);

		System.out.print("Animal Exhibit Number: ");
		String exhibitNumber = sc.nextLine();

		try {
			animalExhibitNumber = Long.parseLong(exhibitNumber.trim());
		} catch (Exception e) {
			System.out.println("Invalid Animal Exhibit Number!");
			return;
		}

		System.out.println(facade.getAnimalParents(animalExhibitNumber));
	}

	private static void getListingOfMedications(Facade facade) {
		long animalExhibitNumber;
		System.out.println("Get Listing of Animal Medications: " + Auxiliar.BREAK_LINE);

		System.out.print("Animal Exhibit Number: ");
		String exhibitNumber = sc.nextLine();

		try {
			animalExhibitNumber = Long.parseLong(exhibitNumber.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Animal Exhibit Number!");
			return;
		}

		System.out.print(facade.getAnimalListingOfMedications(animalExhibitNumber));
	}

	private static void getAnimalListingOfVaccines(Facade facade) {
		long animalExhibitNumber;
		System.out.println("Get Listing of Animal Vaccines: " + Auxiliar.BREAK_LINE);

		System.out.print("Animal Exhibit Number: ");
		String exhibitNumber = sc.nextLine();

		try {
			animalExhibitNumber = Long.parseLong(exhibitNumber.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Animal Exhibit Number!");
			return;
		}

		System.out.print(facade.getAnimalListingOfVaccines(animalExhibitNumber));
	}

	private static void zooKeeperRealocateAnimal(Facade facade) {
		int idKeeper;
		int newIdKeeper;
		long animalExhibitNumber;
		int numberOfTypesInt;
		String type;
		AnimalType animalType;
		Set<AnimalType> animalTypes = new HashSet<>();

		System.out.println("Zoo Keeper Realocate Animal: " + Auxiliar.BREAK_LINE);

		System.out.print("Keeper ID: ");
		String keeperId = sc.nextLine();
		System.out.print("New Keeper ID: ");
		String newKeeperId = sc.nextLine();
		System.out.print("Animal Exhibit Number: ");
		String exhibitNumber = sc.nextLine();
		System.out.print("Number of Types: ");
		String numberOfTypes = sc.nextLine();

		try {
			numberOfTypesInt = Integer.parseInt(numberOfTypes);
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Number Of Types!");
			return;
		}

		for (int i = 1; i <= numberOfTypesInt; i++) {
			type = sc.nextLine().trim();

			try {
				animalType = AnimalType.valueOf(type);
				animalTypes.add(animalType);

			} catch (Exception e) {
				System.out.println(Auxiliar.BREAK_LINE + "Invalid Type!");
				return;
			}

		}

		try {
			idKeeper = Integer.parseInt(keeperId);
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Keeper ID");
			return;
		}

		try {
			newIdKeeper = Integer.parseInt(newKeeperId);
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid New Keeper ID");
			return;
		}

		try {
			animalExhibitNumber = Long.parseLong(exhibitNumber.trim());
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Animal Exhibit Number!");
			return;
		}

		System.out.println(facade.zooKeeperReallocateAnimal(idKeeper, newIdKeeper, animalExhibitNumber));
	}

	private static void getAnimalUnderKeepGuard(Facade facade) {
		int keeperId;

		System.out.println("Get Animals Under Keep Guard: " + Auxiliar.BREAK_LINE);

		System.out.print("Keeper ID: ");
		String idKeeper = sc.nextLine();

		try {
			keeperId = Integer.parseInt(idKeeper);
		} catch (Exception e) {
			System.out.println(Auxiliar.BREAK_LINE + "Invalid Keeper ID");
			return;
		}

		System.out.println(facade.getAnimalsUnderKeepGuard(keeperId));
	}

	private static void updateKeeperQualified(Facade facade) {
		System.out.println(Auxiliar.BREAK_LINE + "Update Keeper Qualified: " + Auxiliar.BREAK_LINE);
		System.out.print("Keeper ID: ");
		String keeperId = sc.nextLine();
		System.out.print("Answer: [YES|NO]");
		String answer = sc.nextLine();

		int idKeeper;
		try {
			idKeeper = Integer.parseInt(keeperId);
		} catch (Exception e) {
			System.out.println("Invalid Keeper ID!");
			return;
		}

		boolean answerB;

		switch (answer.toUpperCase()) {
		case "YES":
			answerB = true;
			break;
		case "NO":
			answerB = false;
			break;

		default:
			System.out.println("Invalid Answer!");
			return;
		}

		System.out.println(facade.updateKeeperQualified(idKeeper, answerB));
	}

	private static void listAllAnimals(Facade facade) {

		System.out.println(facade.listAllAnimals());

	}

	private static void listAllZooKeepers(Facade facade) {

		System.out.println(facade.listAllZooKeepers());
	}

}
