package ai.environment.impl;

import java.util.LinkedList;
import java.util.List;

import ai.agent.Agent;
import ai.environment.Environment;
import ai.environment.EnvironmentObject;
import ai.environment.EnvironmentStatus;

public class VacuumCleanerEnvironment implements Environment {
	
	private List<Agent> agents;
	private List<EnvironmentCell> cells;
	
	public VacuumCleanerEnvironment() {
		agents = new LinkedList<>();
		cells = new LinkedList<>();
	}

	@Override
	public void addAgent(Agent agent) {
		if(null != agent)
			agents.add(agent);
	}

	@Override
	public void removeAgent(Agent agent) {
		agents.remove(agent);
	}

	@Override
	public void addEnvironmentObject(EnvironmentObject object) {
		if(null != object && object instanceof EnvironmentCell)
			cells.add((EnvironmentCell) object);
	}

	@Override
	public void removeEnvironmentObject(EnvironmentObject object) {
		cells.remove(object);
	}

	@Override
	public EnvironmentStatus getStatus() {
		long cellDirtyCount = cells.stream().filter(c -> c.isDirty()).count();
		return new VacuumCleanerEnvironmentStatus((int) cellDirtyCount);
	}
	
	public int cleanedTime() {
		return cells.stream().mapToInt(c -> c.cleanedTime()).sum();
	}

}
