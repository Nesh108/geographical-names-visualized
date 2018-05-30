package com.kulplex.geo.names.visualization;

public class Place {

	public String AsciiName;
	public String LocalName;

	public Place(String asciiName, String localName) {
		AsciiName = asciiName;
		LocalName = localName;
	}

	@Override
	public String toString() {
		return "Place [AsciiName=" + AsciiName + ", LocalName=" + LocalName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AsciiName == null) ? 0 : AsciiName.hashCode());
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
		Place other = (Place) obj;
		if (AsciiName == null) {
			if (other.AsciiName != null)
				return false;
		} else if (!AsciiName.equals(other.AsciiName))
			return false;
		return true;
	}
	
	
}
