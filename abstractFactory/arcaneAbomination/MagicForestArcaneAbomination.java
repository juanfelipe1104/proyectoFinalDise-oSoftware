package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MagicForestArcaneAbomination extends Enemy implements ArcaneAbomination{
	private Boolean followUpAttack;
	public MagicForestArcaneAbomination() {
		this(new CharacterStats("Arcane Abobination",0,40,30,40,20,80,200));
	}
	public MagicForestArcaneAbomination(CharacterStats characterStats) {
		super(characterStats);
		this.followUpAttack = false;
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setMagic((int)(super.characterStats.getMagic()*MagicForestAbstractFactory.INCREASE_STATS));
		}
	}
	@Override
	public void followUpAttack(Character opponent) {	
		if(!this.followUpAttack){
			this.followUpAttack = true;
			System.out.println(super.characterStats.getName() + " ataca de nuevo");
			this.performAction(opponent);
		}
	}
	@Override
	public void useSkill(Character opponent) {	
		this.followUpAttack(opponent);
	}
}
