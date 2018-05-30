package com.kulplex.geo.names.visualization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

	private String filePath;

	public FileParser(String filePath) {
		this.filePath = filePath;
	}

	public Continent[] ParsePlaces() throws FileNotFoundException {
		File file = new File(filePath);
		Scanner input = new Scanner(file);

		ArrayList<Continent> continents = new ArrayList<Continent>();

		while (input.hasNext()) {
			String line = input.nextLine();
			String[] currentLine = line.split("\t");
			Place p = new Place(currentLine[1], currentLine[2]);

			String[] region = currentLine[17].split("/");
			if (region.length == 2) {
				Continent c = new Continent(region[0]);
				Country country = new Country(currentLine[8]);
				if (!continents.contains(c)) {
					continents.add(c);
				}

				int indexOfContinent = continents.indexOf(c);
				if (!continents.get(indexOfContinent).Countries.contains(country)) {
					continents.get(indexOfContinent).Countries.add(country);
					indexOfContinent = continents.size() - 1;
				}

				int indexOfCountry = continents.get(indexOfContinent).Countries.indexOf(country);
				if (!continents.get(indexOfContinent).Countries.get(indexOfCountry).Places.contains(p)) {
					continents.get(indexOfContinent).Countries.get(indexOfCountry).Places.add(p);
				}
			} else {
				System.out.println("Non-comform line found: " + line);
			}
		}

		input.close();
		return continents.toArray(new Continent[continents.size()]);
	}
}
