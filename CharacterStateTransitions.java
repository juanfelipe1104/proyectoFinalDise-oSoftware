package com.utad.ds.proyectoFinal;

public interface CharacterStateTransitions extends CharacterState{
	public abstract void applyParalysis();
	public abstract void applyBleeding();
	public abstract void applySlowDown();
}
