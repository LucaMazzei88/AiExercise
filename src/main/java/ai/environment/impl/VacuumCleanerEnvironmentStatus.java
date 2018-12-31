package ai.environment.impl;

import ai.environment.EnvironmentStatus;

public class VacuumCleanerEnvironmentStatus implements EnvironmentStatus {

	public final int cellDirtyCount;

	public VacuumCleanerEnvironmentStatus(int cellDirtyCount) {
		super();
		this.cellDirtyCount = cellDirtyCount;
	}

	public int getCellDirtyCount() {
		return cellDirtyCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cellDirtyCount;
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
		VacuumCleanerEnvironmentStatus other = (VacuumCleanerEnvironmentStatus) obj;
		if (cellDirtyCount != other.cellDirtyCount)
			return false;
		return true;
	}

}
