package ai.environment.impl;

import ai.agent.Agent;
import ai.environment.EnvironmentObject;

public class EnvironmentCell implements EnvironmentObject {

	private EnvironmentCell nord;
	private EnvironmentCell est;
	private EnvironmentCell ovest;
	private EnvironmentCell sud;
	private boolean dirty;
	private int cleaned;
	private Agent onCell;

	public EnvironmentCell(boolean dirty) {
		this.dirty = dirty;
		this.cleaned = 0;
	}

	public boolean setNord(EnvironmentCell nord) {
		if (canSetNord() && nord.canSetSud()) {
			this.nord = nord;
			return true;
		}
		return false;
	}

	private boolean canSetNord() {
		return null != this.nord;
	}

	public boolean setEst(EnvironmentCell est) {
		if (canSetEst() && est.canSetOvest()) {
			this.est = est;
			return true;
		}
		return false;
	}

	private boolean canSetEst() {
		return null != this.est;
	}

	public boolean setOvest(EnvironmentCell ovest) {
		if (canSetOvest() && ovest.canSetEst()) {
			this.ovest = ovest;
			return true;
		}
		return false;
	}

	private boolean canSetOvest() {
		return null != this.ovest;
	}

	public boolean setSud(EnvironmentCell sud) {
		if (canSetSud() && sud.canSetNord()) {
			this.sud = sud;
			return true;
		}
		return false;
	}

	private boolean canSetSud() {
		return null != this.sud;
	}

	private void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public EnvironmentCell getNord() {
		return nord;
	}

	public EnvironmentCell getEst() {
		return est;
	}

	public EnvironmentCell getOvest() {
		return ovest;
	}

	public EnvironmentCell getSud() {
		return sud;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void clean(Agent agent) {
		if (isOnCell(agent)) {
			setDirty(false);
			cleaned++;
		}
	}
	
	public int cleanedTime() {
		return cleaned;
	}

	public void moveOnCell(Agent agent) {
		this.onCell = agent;
	}
	
	public boolean isOnCell(Agent agent) {
		return onCell == agent;
	}

}
