package com.kulplex.geo.names.visualization;

import java.util.ArrayList;
public class Country {
	
	public String Name;
	public ArrayList<Place> Places;

	public Country(String name) {
		this(name, new ArrayList<Place>());
	}
	
	public Country(String name, ArrayList<Place> places) {
		Name = name;
		Places = places;
	}
	
	@Override
	public String toString() {
		return "Country [Name=" + Name + ", Places=" + Places + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
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
		Country other = (Country) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}
	
	
}
