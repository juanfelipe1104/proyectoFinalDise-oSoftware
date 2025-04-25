package com.utad.ds.proyectoFinal;

//Define el comportamiento de los personajes
public interface Character 
{
	public abstract void performAction();
	public abstract CharacterStats getCharacterStats();
	public abstract void setCurrentState(CharacterState characterState);
	public abstract CharacterState getCurrentState();
	public abstract BaseState getBaseState();
	public abstract BleedingState getBleedingState();
	public abstract ParalysisState getParalysisState();
	public abstract SlowDownState getSlowDownState();
	public abstract DeadState getDeadState();
	public abstract void performEffect();
	public abstract void removeSideEffect();
	public abstract void applyParalysis();
	public abstract void applyBleeding();
	public abstract void applySlowDown();
	public abstract void killCharacter();
}
