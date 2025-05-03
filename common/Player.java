package com.utad.ds.proyectoFinal.common;

import java.util.ArrayList;
import java.util.List;

import com.utad.ds.proyectoFinal.state.DeadState;

public class Player extends GameCharacter {
	private static Double INCREASE_STATS_PORCENTAGE = 1.1d;
	private List<Item> inventory;
	public Player(String name) {
		this(new CharacterStats(name, 100, 100, 50, 50, 50, 100, 100));
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
			this.performAction(target);
		}
	}
	public void increaseStats() {
		super.characterStats.setStrength((int)(super.characterStats.getStrength()*Player.INCREASE_STATS_PORCENTAGE));
		super.characterStats.setMagic((int)(super.characterStats.getMagic()*Player.INCREASE_STATS_PORCENTAGE));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*Player.INCREASE_STATS_PORCENTAGE));
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*Player.INCREASE_STATS_PORCENTAGE));
		super.characterStats.setSpeed((int)(super.characterStats.getSpeed()*Player.INCREASE_STATS_PORCENTAGE));
		super.characterStats.setMaxHP((int)(super.characterStats.getMaxHP()*Player.INCREASE_STATS_PORCENTAGE));
		super.characterStats.setMaxMP((int)(super.characterStats.getMaxMP()*Player.INCREASE_STATS_PORCENTAGE));
	}
	public void restoreMP() {
		super.characterStats.setMP(super.characterStats.getMaxMP());
	}
	public void restoreHP() {
		super.characterStats.setHP(super.characterStats.getMaxHP());
	}
	@Override
	public String toString() {
		return "Player: " + super.toString();
	}
	public List<Item> getInventory() { return this.inventory; }
}
