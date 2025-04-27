package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.common.*;

public class LandOfDragonsBoss extends Enemy implements Boss{
	public static final Double INCREASE_STATS = 4.0;
	private Boolean revive;
	public LandOfDragonsBoss(){
		this(new CharacterStats("Boss",90,90,90,90,90,90,90));
	}
	public LandOfDragonsBoss(CharacterStats characterStats){
		super(characterStats);
		this.revive = false;
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*LandOfDragonsBoss.INCREASE_STATS)));
		}
	}
	@Override
	public void useSkill() {	
		this.revive();
	}
	@Override
	public void revive() {	
		this.revive = true;
	}
}
