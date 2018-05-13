package cctZoo;


import utils.CSVController;

public class Main {

	public static void main(String[] args) {

		CSVController reader = new CSVController();
		Facade facade = new Facade();

		reader.importFilesToSystem(facade);
		
		System.out.println(facade.listAllZooKeepers());
		
	}

}
