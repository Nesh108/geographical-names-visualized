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
		return ParsePlaces(null, null, Integer.MAX_VALUE);
	}

	public Continent[] ParsePlaces(ArrayList<String> allowedFeatures, String continentFilter, int filterCount)
			throws FileNotFoundException {
		File file = new File(filePath);
		Scanner input = new Scanner(file);

		ArrayList<Continent> continents = new ArrayList<Continent>();
		int elements = 0;

		while (input.hasNext() && elements < filterCount) {
			String line = input.nextLine();
			String[] currentLine = line.split("\t");

			if (allowedFeatures == null || allowedFeatures.contains(currentLine[6])) {
				Place p = new Place(currentLine[1], currentLine[2]);

				String[] region = currentLine[17].split("/");
				String continentName;

				if (region.length < 1 || region[0].trim().equals("")) {
					continentName = "N/A";
				} else {
					continentName = region[0];
				}

				if (continentFilter == null || continentName.equals(continentFilter)) {
					Continent c = new Continent(continentName);
					Country country = new Country(currentLine[8]);
					if (!continents.contains(c)) {
						continents.add(c);
					}

					int indexOfContinent = continents.indexOf(c);
					if (!continents.get(indexOfContinent).Countries.contains(country)) {
						continents.get(indexOfContinent).Countries.add(country);
					}

					int indexOfCountry = continents.get(indexOfContinent).Countries.indexOf(country);
					if (!continents.get(indexOfContinent).Countries.get(indexOfCountry).Places.contains(p)) {
						continents.get(indexOfContinent).Countries.get(indexOfCountry).Places.add(p);
					}
					elements++;
				}
			}
		}

		input.close();
		return continents.toArray(new Continent[continents.size()]);
	}
}
