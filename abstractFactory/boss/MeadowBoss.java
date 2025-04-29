package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MeadowBoss extends Enemy implements Boss{
	public static final Double INCREASE_STATS = 2.0;
	private Boolean revive;
	public MeadowBoss(){
		this(new CharacterStats("Boss",30,30,30,30,30,30,30));
	}
	public MeadowBoss(CharacterStats characterStats){
		super(characterStats);
		this.revive = false;
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MeadowBoss.INCREASE_STATS)));	
		}
	}
	@Override
	public void useSkill(Character target) {	
		this.revive();
	}
	@Override
	public void revive() {	
		if(this.revive.equals(false)){
			this.revive = true;
			System.out.println(super.characterStats.getName() + " ha revivido");
			super.characterStats.setHP(super.characterStats.getMaxHP());
		}
	}
}
