package com.utad.ds.proyectoFinal;

public class BaseState implements CharacterState {
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
		this.character.setCurrentState(this.character.getParalysisState());
	}

	@Override
	public void applyBleeding() {
		this.character.setCurrentState(this.character.getBleedingState());
	}

	@Override
	public void applySlowDown() {
		this.character.setCurrentState(this.character.getSlowDownState());
	}
	@Override
	public void killCharacter() {
		this.character.setCurrentState(this.character.getDeadState());
	}
}
