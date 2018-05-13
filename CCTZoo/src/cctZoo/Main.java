package cctZoo;


import java.util.Scanner;

import utils.Auxiliar;
import utils.CSVController;


public class Main {
	private static Scanner sc;
	private static String input;

	public static void main(String[] args) {

		CSVController reader = new CSVController();
		Facade facade = new Facade();
		sc = new Scanner (System.in);
		String input = sc.nextLine();

		reader.importFilesToSystem(facade);
		
		do {
			System.out.println(options());
			input = sc.nextLine();
			selectOption(input);
		}
		while (!input.equals("3"));
		
	}
	
	private static void selectOption(String input) {
		switch (input) {
		case "1":
			cadastrarAnimais();
			break;

		default:
			System.out.println("Opção Invalida");
			break;
		}
	}
	
	
	private  static String options() {
		 return "1 - CADASTRAR ANIMAIS" + Auxiliar.BREAK_LINE + "2 - CADASTRAR KEEPERS" + 
	"3 - SAIR" + Auxiliar.BREAK_LINE;
	}
	
	
	
	private void addAnimalMedication() {
		System.out.println("Add Animal Medication: " + Auxiliar.BREAK_LINE);
		System.out.print("Animal Exhibit Number: ");
		
		
		
	}

}
