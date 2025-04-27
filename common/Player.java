package com.utad.ds.proyectoFinal.common;

public class Player extends GameCharacter {
	public Player(String name) {
		this(new CharacterStats(name, 50, 50, 50, 50, 50, 100, 100));
	}
	public Player(CharacterStats characterStats) {
		super(characterStats);
	}
	@Override
	public void performAction(Character target) {
		try {
			super.currentAction.performAction(this, target);
		}catch(ActionException actionException) {
			System.out.println(actionException.getMessage());
		}
	}
	@Override
	public void playTurn(Character target) {
		this.performAction(target);
	}
}
