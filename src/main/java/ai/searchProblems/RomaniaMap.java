package ai.searchProblems;

import static ai.searchProblems.City.ARAD;
import static ai.searchProblems.City.BUCAREST;
import static ai.searchProblems.City.CRAIOVA;
import static ai.searchProblems.City.DROBETA;
import static ai.searchProblems.City.FAGARAS;
import static ai.searchProblems.City.LUGOJ;
import static ai.searchProblems.City.MEHADIA;
import static ai.searchProblems.City.ORADEA;
import static ai.searchProblems.City.PITESTI;
import static ai.searchProblems.City.RIMNICU_VILCEA;
import static ai.searchProblems.City.SIBIU;
import static ai.searchProblems.City.TIMISOARA;
import static ai.searchProblems.City.ZERIND;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RomaniaMap {

	private Set<CityLink> links;
	
	public RomaniaMap() {
		links = new HashSet<>(Arrays.asList(//
				new CityLink(ARAD, ZERIND, 75), //
				new CityLink(ZERIND, ORADEA, 71), //
				new CityLink(ORADEA, SIBIU, 151), //
				new CityLink(SIBIU, FAGARAS, 99), //
				new CityLink(FAGARAS, BUCAREST, 211), //
				new CityLink(ARAD, SIBIU, 140), //
				new CityLink(SIBIU, RIMNICU_VILCEA, 80), //
				new CityLink(RIMNICU_VILCEA, PITESTI, 97), //
				new CityLink(PITESTI, BUCAREST, 101), //
				new CityLink(ARAD, TIMISOARA, 118), //
				new CityLink(TIMISOARA, LUGOJ, 111), //
				new CityLink(LUGOJ, MEHADIA, 70), //
				new CityLink(MEHADIA, DROBETA, 75), //
				new CityLink(DROBETA, CRAIOVA, 120), //
				new CityLink(CRAIOVA, PITESTI, 101), //
				new CityLink(CRAIOVA, RIMNICU_VILCEA, 146) //
		));
	}
	
	public List<City> getNeighborhood(City c) {
		return links.stream()//
				.filter(l -> l.hasLink(c).isPresent())//
				.map(l -> l.hasLink(c).get())
				.collect(Collectors.toList());
	}
	
	public CityLink getLink(City a, City b) {
		List<CityLink> link = links.stream().filter(l -> l.isLink(a, b)).collect(Collectors.toList());
		if(link.isEmpty()) {
			return null;
		}
		if(link.size()>1) {
			throw new IllegalStateException("Too mutch city link found for " + a + ", "  + b);
		}
		return link.get(0);
	}
	
}
