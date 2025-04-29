package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class LandOfDragonsArcaneAbomination extends Enemy implements ArcaneAbomination {
	private Boolean followUpAttack;
	public LandOfDragonsArcaneAbomination() {
		this(new CharacterStats("Arcane Abobination",0,60,45,60,20,80,300));
	}
	public LandOfDragonsArcaneAbomination(CharacterStats characterStats) {
		super(characterStats);
		this.followUpAttack = false;
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP() <= super.characterStats.getMaxHP()){
			super.characterStats.setMagic((int)(super.characterStats.getMagic()*LandOfDragonsAbstractFactory.INCREASE_STATS));
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
