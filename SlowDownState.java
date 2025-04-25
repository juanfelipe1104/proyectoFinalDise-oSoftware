package com.utad.ds.proyectoFinal;

public class SlowDownState implements CharacterState {
	public static final Integer BASE_SPEED = 30;
	private Character character;
	public SlowDownState(Character character) {
		this.character = character;
	}
	@Override
	public void performEffect() {
		this.character.getCharacterStats().setSpeed((int)(this.character.getCharacterStats().getSpeed()*0.90));
	}

	@Override
	public void removeSideEffect() {
		this.character.setCurrentState(this.character.getBaseState());
		if(this.character.getCharacterStats().getSpeed() < SlowDownState.BASE_SPEED) {
			this.character.getCharacterStats().setSpeed(SlowDownState.BASE_SPEED);
		}
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
	@Override
	public void killCharacter() {
		this.character.setCurrentState(this.character.getDeadState());
	}
}
