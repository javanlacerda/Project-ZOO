package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	public ArrayList<String[]> run(String csvFile) {

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
}