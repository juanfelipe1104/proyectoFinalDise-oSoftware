package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.common.*;

public class MostolesBoss extends Enemy implements Boss{
	public static final Double INCREASE_STATS = 5.0;
	private Boolean revive;
	public MostolesBoss(){
		this(new CharacterStats("Boss",120,120,120,120,120,120,120));
	}
	public MostolesBoss(CharacterStats characterStats){
		super(characterStats);
		this.revive = false;
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MostolesBoss.INCREASE_STATS)));	
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
