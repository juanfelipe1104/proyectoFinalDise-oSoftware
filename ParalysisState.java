package com.utad.ds.proyectoFinal;

import java.util.Random;

public class ParalysisState implements CharacterStateTransitions {
	private Character character;
	public ParalysisState(Character character) {
		this.character = character;
	}
	@Override
	public void performEffect() {
		if(new Random().nextInt(0, 99) <= 30) {
			this.character.getCharacterStats().setCanAttack(false);
		}
		else {
			this.character.getCharacterStats().setCanAttack(true);
		}
	}

	@Override
	public void removeSideEffect() {
		this.character.setCharacterState(this.character.getBaseState());
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
