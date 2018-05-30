package com.kulplex.geo.names.visualization;

import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) {
		
		FileParser fp = new FileParser("data/allCountries.txt");
		Continent[] continents = null;
		try {
			continents = fp.ParsePlaces();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found...");
		}
		
		for(Continent c : continents) {
			for(Country cc : c.Countries) {
				System.out.println(cc.Name);
			}
		}
		
	}
}
