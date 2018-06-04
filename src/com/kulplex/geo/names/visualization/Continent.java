package com.kulplex.geo.names.visualization;

import java.util.ArrayList;

public class Continent {

	public String Name;
	public ArrayList<Country> Countries;

	public Continent(String name) {
		this(name, new ArrayList<Country>());
	}

	public Continent(String name, ArrayList<Country> countries) {
		Name = name;
		Countries = countries;
	}

	@Override
	public String toString() {
		return "Continent [Name=" + Name + ", Countries=" + Countries + "]";
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
		Continent other = (Continent) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}

}
