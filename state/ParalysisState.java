package com.utad.ds.proyectoFinal.state;

import java.util.Random;

import com.utad.ds.proyectoFinal.common.Character;

public class ParalysisState implements CharacterState {
	private Character character;
	public ParalysisState(Character character) {
		this.character = character;
	}
	@Override
	public void performEffect() {
		if(new Random().nextInt(0, 99) <= 30) {
			this.character.getCharacterStats().setCanAttack(false);
			System.out.println(this.character.getCharacterStats().getName() + " esta paralizado. No puede atacar");
		}
		else {
			this.character.getCharacterStats().setCanAttack(true);
		}
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
	@Override
	public void killCharacter() {
		this.character.setCurrentState(this.character.getDeadState());
	}
	@Override
	public String toString() {
		return "ParalysisState";
	}
}
