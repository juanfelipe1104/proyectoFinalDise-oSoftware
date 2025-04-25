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
		System.out.println(this.character.getCharacterStats().getName() + " ha sido paralizado.");
	}

	@Override
	public void applyBleeding() {
		this.character.setCurrentState(this.character.getBleedingState());
		System.out.println(this.character.getCharacterStats().getName() + " le han apuñalado");
	}

	@Override
	public void applySlowDown() {
		this.character.setCurrentState(this.character.getSlowDownState());
		System.out.println(this.character.getCharacterStats().getName() + " ha sido ralentizado");
	}
	@Override
	public void killCharacter() {
		this.character.setCurrentState(this.character.getDeadState());
		System.out.println(this.character.getCharacterStats().getName() + " ha muerto");
	}
}
