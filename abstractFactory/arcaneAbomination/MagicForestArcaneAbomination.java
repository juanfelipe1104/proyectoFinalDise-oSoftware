package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class MagicForestArcaneAbomination extends Enemy implements ArcaneAbomination{
	public MagicForestArcaneAbomination() {
		this(new CharacterStats("Arcane Abobination",0,40,30,40,20,80,200));
	}
	public MagicForestArcaneAbomination(CharacterStats characterStats) {
		super(characterStats);
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setMagic((int)(super.characterStats.getMagic()*MagicForestAbstractFactory.INCREASE_STATS));
		}
	}
	@Override
	public void followUpAttack() {	
		//llamar a realizar otra accion
	}
	@Override
	public void useSkill() {
		this.followUpAttack();	
	}
}
