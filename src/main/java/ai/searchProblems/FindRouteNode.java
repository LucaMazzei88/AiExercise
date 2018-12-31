package ai.searchProblems;

public class FindRouteNode implements Node<City, CityLink, Integer>{
	
	private City currentCity;
	private City lastCity;
	private CityLink action;
	
	
	
	public FindRouteNode(City currentCity, City lastCity, CityLink action) {
		super();
		this.currentCity = currentCity;
		this.lastCity = lastCity;
		this.action = action;
	}

	@Override
	public City getCurrentNode() {
		return currentCity;
	}

	@Override
	public City getLastNode() {
		return lastCity;
	}

	@Override
	public CityLink getAction() {
		// TODO Auto-generated method stub
		return action;
	}

	@Override
	public Integer getCost() {
		// TODO Auto-generated method stub
		return null;
	}

}
