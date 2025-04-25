package com.utad.ds.proyectoFinal;

public class Player implements Character 
{
	protected CharacterStats characterStats;
	protected CharacterState currentState;
	protected BaseState baseState;
	protected BleedingState bleedingState;
	protected ParalysisState paralysisState;
	protected SlowDownState slowDownState;
	protected DeadState deadState;
	public Player(String name) {
		this(new CharacterStats(name, 50, 50, 50, 50, 50, 100, 100));
	}
	
	public Player(CharacterStats characterStats) {
		this.characterStats = characterStats;
		
		this.baseState = new BaseState(this);
		this.bleedingState = new BleedingState(this);
		this.paralysisState = new ParalysisState(this);
		this.slowDownState = new SlowDownState(this);
		this.deadState = new DeadState(this);
		this.currentState = this.baseState;
	}
	@Override
	public void performAction(Character target) {
		/// ??? Strategy
	}

	@Override
	public CharacterStats getCharacterStats() {
		return this.characterStats;
	}

	@Override
	public void setCurrentState(CharacterState characterState) {
		this.currentState = characterState;
	}

	@Override
	public BaseState getBaseState() {
		return this.baseState;
	}

	@Override
	public BleedingState getBleedingState() {
		return this.bleedingState;
	}

	@Override
	public ParalysisState getParalysisState() {
		return this.paralysisState;
	}

	@Override
	public SlowDownState getSlowDownState() {
		return this.slowDownState;
	}

	@Override
	public void performEffect() {
		this.currentState.performEffect();
	}

	@Override
	public void removeSideEffect() {
		this.currentState.removeSideEffect();
	}

	@Override
	public void applyParalysis() {
		this.currentState.applyParalysis();
	}

	@Override
	public void applyBleeding() {
		this.currentState.applyBleeding();
	}

	@Override
	public void applySlowDown() {
		this.currentState.applySlowDown();
	}

	@Override
	public DeadState getDeadState() {
		return this.deadState;
	}

	@Override
	public void killCharacter() {
		this.currentState.killCharacter();
	}

	@Override
	public CharacterState getCurrentState() {
		return this.currentState;
	}

}
