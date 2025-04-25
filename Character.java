package com.utad.ds.proyectoFinal;

//Define el comportamiento de los personajes
public interface Character 
{
	public abstract void performAction();
	public abstract CharacterStats getCharacterStats();
	public abstract void setCharacterState(CharacterState characterState);
	public abstract BaseState getBaseState();
	public abstract BleedingState getBleedingState();
	public abstract ParalysisState getParalysisState();
	public abstract SlowDownState getSlowDownState();
}
