package ai.searchProblems;

import java.util.Optional;

public class CityLink {

	City a;
	City b;
	int distance;

	public CityLink(City a, City b, int distance) {
		super();
		this.a = a;
		this.b = b;
		this.distance = distance;
	}

	public City getA() {
		return a;
	}

	public City getB() {
		return b;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + distance;
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
		CityLink other = (CityLink) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (distance != other.distance)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CityLink [a=" + a + ", b=" + b + ", distance=" + distance + "]";
	}

	public Optional<City> hasLink(City city) {
		if (city.equals(a)) {
			return Optional.of(b);
		}
		if (city.equals(b)) {
			return Optional.of(a);
		}
		return Optional.empty();
	}

	public boolean isLink(City a, City b) {
		return (this.a.equals(a) && this.b.equals(b)) || (this.a.equals(b) && this.b.equals(a));
	}

}
