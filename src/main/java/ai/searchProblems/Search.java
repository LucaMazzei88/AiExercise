package ai.searchProblems;

import java.util.Collection;

public interface Search <GOL, STATE>{
	
	public STATE search(GOL g);

	public STATE chooseNewState(Collection<STATE> border);
	
	public boolean isReachedGoal(GOL g,STATE s);
}
