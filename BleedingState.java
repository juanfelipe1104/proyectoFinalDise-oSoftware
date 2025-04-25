package com.utad.ds.proyectoFinal;

public class BleedingState implements CharacterState{
	private Character character;
	public BleedingState(Character character) {
		this.character = character;
	}
	@Override
	public void performEffect() {
		this.character.getCharacterStats().setHP((int)(this.character.getCharacterStats().getHP() * 0.95));
	}
	@Override
	public void removeSideEffect() {
		this.character.setCurrentState(this.character.getBaseState());
	}
	@Override
	public void applyParalysis() {
		// Can't
		
	}
	@Override
	public void applyBleeding() {
		// Can't
		
	}
	@Override
	public void applySlowDown() {
		// Can't
		
	}
}
