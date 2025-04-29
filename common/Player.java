package com.utad.ds.proyectoFinal.common;
import java.util.List;
import java.util.ArrayList;

public class Player extends GameCharacter 
{
	private List<Item> inventory;
	public Player(String name) 
	{
		this(new CharacterStats(name, 50, 50, 50, 50, 50, 100, 100));
	}
	public Player(CharacterStats characterStats) 
	{
		super(characterStats);
		this.inventory = new ArrayList<Item>();
	}
	@Override
	public void performAction(Character target) 
	{
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
	
	public List<Item> getInventory()	{ return this.inventory; }
}
