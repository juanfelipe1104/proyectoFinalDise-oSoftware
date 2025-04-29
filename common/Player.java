package com.utad.ds.proyectoFinal.common;

import java.util.ArrayList;
import java.util.List;

import com.utad.ds.proyectoFinal.state.DeadState;

public class Player extends GameCharacter {
	private List<Item> inventory;
	public Player(String name) {
		this(new CharacterStats(name, 10000, 10000, 50, 50, 50, 100, 100));
	}
	public Player(CharacterStats characterStats) {
		super(characterStats);
		this.inventory = new ArrayList<Item>();
	}
	@Override
	public void performAction(Character target) {
		try {
			super.currentAction.performActionFirst(this, target);
		}catch(ActionException actionException) {
			System.out.println(actionException.getMessage());
		}
	}
	@Override
	public void playTurn(Character target) {
		super.characterStats.setReflecting(false);
		super.characterStats.setGuarding(false);
		super.characterStats.setCanAttack(true);
		super.performEffect();
		if(super.characterStats.getCanAttack() && !(super.currentState instanceof DeadState)){
			System.out.println(super.characterStats.getName() + " realiza la accion " + super.currentAction.getDescription());
			this.performAction(target);
		}
	}
	@Override
	public String toString() {
		return super.toString() + "Player []";
	}
	public List<Item> getInventory() { return this.inventory; }
}
