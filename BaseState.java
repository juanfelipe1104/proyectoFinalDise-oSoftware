package com.utad.ds.proyectoFinal;

public class BaseState implements CharacterStateTransitions {
	private Character character;
	public BaseState(Character character) {
		this.character = character;
	}
	@Override
	public void performEffect() {
		//None
	}

	@Override
	public void removeSideEffect() {
		//None
	}

	@Override
	public void applyParalysis() {
		this.character.setCharacterState(this.character.getParalysisState());
	}

	@Override
	public void applyBleeding() {
		this.character.setCharacterState(this.character.getBleedingState());
	}

	@Override
	public void applySlowDown() {
		this.character.setCharacterState(this.character.getSlowDownState());
	}

}
