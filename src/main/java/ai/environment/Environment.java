package ai.environment;

import ai.agent.Agent;

public interface Environment{
	
	public void addAgent(Agent agent);
	
	public void removeAgent(Agent agent);
	
	public void addEnvironmentObject(EnvironmentObject object);
	
	public void removeEnvironmentObject(EnvironmentObject object);
	
	public EnvironmentStatus getStatus();
	
}
