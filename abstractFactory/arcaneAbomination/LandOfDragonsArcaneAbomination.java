package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class LandOfDragonsArcaneAbomination extends Enemy implements ArcaneAbomination {
	public LandOfDragonsArcaneAbomination() {
		this(new CharacterStats("Arcane Abobination",0,60,45,60,20,80,300));
	}
	public LandOfDragonsArcaneAbomination(CharacterStats characterStats) {
		super(characterStats);
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP() <= super.characterStats.getMaxHP()){
			super.characterStats.setMagic((int)(super.characterStats.getMagic()*LandOfDragonsAbstractFactory.INCREASE_STATS));
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
