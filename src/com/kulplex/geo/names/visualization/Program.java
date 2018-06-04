package com.kulplex.geo.names.visualization;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Program {

	static String filePath = "data/allCountries.txt";
	static ArrayList<String> allowedFeatures = new ArrayList<String>(Arrays.asList("A", "P"));
	static String continentFilter = "Oceania";
	static int delimitCount = 3;
	static int elementsCountFilter = 100000;

	public static void main(String[] args) {
		FileParser fp = new FileParser(filePath);
		try {
			Continent[] continents = fp.ParsePlaces(allowedFeatures, continentFilter, elementsCountFilter);

			// Statistics Processing
			String longestName = StatisticsMaker.GetLongestPlaceName(continents, continentFilter);
			String shortestName = StatisticsMaker.GetShortestPlaceName(continents, continentFilter);
			String[] mostCommonEnding = StatisticsMaker.GetMostCommonPlaceNameEnding(continents, delimitCount,
					continentFilter);
			String[] mostCommonBeginning = StatisticsMaker.GetMostCommonPlaceNameBeginning(continents, delimitCount,
					continentFilter);

			// Printing
			System.out.println(
					"Longest Name: " + longestName + " with " + longestName.split(",")[0].length() + " characters");
			System.out.println(
					"Shortest Name: " + shortestName + " with " + shortestName.split(",")[0].length() + " characters");
			System.out.println("Most Common Beginning (" + delimitCount + "): " + mostCommonBeginning[0] + " found "
					+ mostCommonBeginning[1] + " times");
			System.out.println("Most Common Ending (" + delimitCount + "): " + mostCommonEnding[0] + " found "
					+ mostCommonEnding[1] + " times");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found...");
		}
	}
}
