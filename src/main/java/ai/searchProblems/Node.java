package ai.searchProblems;

public interface Node <STATE,ACTION,COST> {

	public STATE getCurrentNode();
	
	public STATE getLastNode();
	
	public ACTION getAction();
	
	public COST getCost();
	
}
