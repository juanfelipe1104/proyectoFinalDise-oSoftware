package com.utad.ds.proyectoFinal;

public abstract class Enemy implements Character{
	protected CharacterStats characterStats;
	protected CharacterState currentState;
	protected BaseState baseState;
	protected BleedingState bleedingState;
	protected ParalysisState paralysisState;
	protected SlowDownState slowDownState;
	public Enemy(CharacterStats characterStats) {
		this.characterStats = characterStats;
		
		this.baseState = new BaseState(this);
		this.bleedingState = new BleedingState(this);
		this.paralysisState = new ParalysisState(this);
		this.slowDownState = new SlowDownState(this);
		this.currentState = this.baseState;
	}
	public void playTurn() {
		this.performAction();
		this.useSkill();
	}
	public void performEffect() {
		this.currentState.performEffect();
	}
	public void removeSideEffect() {
		this.currentState.removeSideEffect();
	}
	public void applyParalysis() {
		this.currentState.applyParalysis();
	}
	public void applyBleeding() {
		this.currentState.applyBleeding();
	}
	public void applySlowDown() {
		this.currentState.applySlowDown();
	}
	public abstract void useSkill();
	public abstract void increaseStats();
	public void performAction() {
		// ??? Strategy
	}
	public CharacterStats getCharacterStats() {
		return this.characterStats;
	}
	public void setCurrentState(CharacterState characterState) {
		this.currentState = characterState;
	}
	public BaseState getBaseState() {
		return this.baseState;
	}
	public BleedingState getBleedingState() {
		return this.bleedingState;
	}
	public ParalysisState getParalysisState() {
		return this.paralysisState;
	}
	public SlowDownState getSlowDownState() {
		return this.slowDownState;
	}
}
