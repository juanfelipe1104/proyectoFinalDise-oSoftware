package com.utad.ds.proyectoFinal;

public interface CharacterState {
	public abstract void performEffect();
	public abstract void removeSideEffect();
	public abstract void applyParalysis();
	public abstract void applyBleeding();
	public abstract void applySlowDown();
	public abstract void killCharacter();
}
