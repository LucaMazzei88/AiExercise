package ai.searchProblems;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeSearch implements Search<Itinerary, City>{

	private RomaniaMap romania;

	private City pos;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public TreeSearch(RomaniaMap romania) {
		this.romania = romania;
	}

	public City search(Itinerary itinerary) {

		List<City> cities = new LinkedList<>();
		
		pos = itinerary.getFrom();
		
		Set<City> border = new LinkedHashSet<>();
		border.addAll(romania.getNeighborhood(pos));

		while(true) {
			logger.info("Borders {}", border);
			if(border.isEmpty()) {
				return null;
			}
			City newPos = chooseNewState(border);
			border.remove(newPos);
			pos = newPos;
			cities.add(pos);
			logger.info("New position {}", pos);
			if(isReachedGoal(itinerary, pos)) {
				logger.info("Cities visited {}", cities);
				return pos;
			}
			border.addAll(romania.getNeighborhood(pos));
		}
	}

	public City chooseNewState(Collection<City> border) {
		return border.toArray(new City[border.size()])[(int)(Math.random() % border.size())];
	}

	public boolean isReachedGoal(Itinerary itinerary, City pos) {
		return pos.equals(itinerary.getTo());
	}

}
