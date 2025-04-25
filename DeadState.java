package com.utad.ds.proyectoFinal;

public class DeadState implements CharacterState {
	private Character character;
	public DeadState(Character character) {
		this.character = character;
	}
	@Override
	public void performEffect() {
		// None
	}

	@Override
	public void removeSideEffect() {
		// None
		
	}

	@Override
	public void applyParalysis() {
		// None
		
	}

	@Override
	public void applyBleeding() {
		// None
		
	}

	@Override
	public void applySlowDown() {
		// None
		
	}

	@Override
	public void killCharacter() {
		// None
		
	}

}
