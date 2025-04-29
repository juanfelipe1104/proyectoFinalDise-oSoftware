package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MeadowArcaneAbomination extends Enemy implements ArcaneAbomination{
	private Boolean followUpAttack;
	public MeadowArcaneAbomination() {
		this(new CharacterStats("Arcane Abobination",0,20,15,20,10,40,100));
	}
	public MeadowArcaneAbomination(CharacterStats characterStats) {
		super(characterStats);
		this.followUpAttack = false;
		super.characterStats.setMagic((int)(super.characterStats.getMagic()*MeadowAbstractFactory.INCREASE_STATS));
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
