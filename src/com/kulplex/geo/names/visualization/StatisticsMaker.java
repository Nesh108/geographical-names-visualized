package com.kulplex.geo.names.visualization;

import java.util.HashMap;

public class StatisticsMaker {

	static public String GetLongestPlaceName(Continent[] conts) {
		return GetLongestPlaceName(conts, null);
	}

	static public String GetLongestPlaceName(Continent[] conts, String continentFilter) {
		String longestName = "";
		for (Continent c : conts) {
			if (continentFilter == null || c.Name.equals(continentFilter)) {
				for (Country cc : c.Countries) {
					for (Place p : cc.Places) {
						longestName = longestName.length() < p.AsciiName.length()
								? (p.AsciiName + ", " + cc.Name + ", " + c.Name)
								: longestName;
					}
				}
			}
		}
		return longestName;
	}

	static public String GetShortestPlaceName(Continent[] conts, String continentFilter) {
		String shortestName = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		for (Continent c : conts) {
			if (continentFilter == null || c.Name.equals(continentFilter)) {
				for (Country cc : c.Countries) {
					for (Place p : cc.Places) {
						shortestName = shortestName.length() > p.AsciiName.length() && p.AsciiName.length() > 0
								? (p.AsciiName + ", " + cc.Name + ", " + c.Name)
								: shortestName;
					}
				}
			}
		}
		return shortestName;
	}

	static public String[] GetMostCommonPlaceNameEnding(Continent[] conts, int endingLength) {
		return GetMostCommonPlaceNameEnding(conts, endingLength, null);
	}

	static public String[] GetMostCommonPlaceNameEnding(Continent[] conts, int endingLength, String continentFilter) {
		HashMap<String, Integer> endings = new HashMap<>();
		for (Continent c : conts) {
			if (continentFilter == null || c.Name.equals(continentFilter)) {
				for (Country cc : c.Countries) {
					for (Place p : cc.Places) {
						if (p.AsciiName.length() >= endingLength) {
							String ending = p.AsciiName.substring(p.AsciiName.length() - endingLength);
							if (endings.containsKey(ending)) {
								endings.put(ending, endings.get(ending) + 1);
							} else {
								endings.put(ending, 1);
							}
						}
					}
				}
			}
		}
		return RetrieveMostCommonElementSet(endings);
	}

	static public String[] GetMostCommonPlaceNameBeginning(Continent[] conts, int beginningLength) {
		return GetMostCommonPlaceNameBeginning(conts, beginningLength, null);
	}

	static public String[] GetMostCommonPlaceNameBeginning(Continent[] conts, int beginningLength,
			String continentFilter) {
		HashMap<String, Integer> beginnings = new HashMap<>();
		for (Continent c : conts) {
			if (continentFilter == null || c.Name.equals(continentFilter)) {
				for (Country cc : c.Countries) {
					for (Place p : cc.Places) {
						if (p.AsciiName.length() >= beginningLength) {
							String beginning = p.AsciiName.substring(0, beginningLength);
							if (beginnings.containsKey(beginning)) {
								beginnings.put(beginning, beginnings.get(beginning) + 1);
							} else {
								beginnings.put(beginning, 1);
							}
						}
					}
				}
			}
		}
		return RetrieveMostCommonElementSet(beginnings);
	}

	static private String[] RetrieveMostCommonElementSet(HashMap<String, Integer> map) {
		int longest = 0;
		String ending = "";
		for (String k : map.keySet()) {
			if (map.get(k) > longest) {
				longest = map.get(k);
				ending = k;
			}
		}
		return new String[] { ending, longest + "" };
	}
}
