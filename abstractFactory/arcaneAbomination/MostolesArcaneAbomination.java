package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;

public class MostolesArcaneAbomination extends Enemy implements ArcaneAbomination{
	private Boolean followUpAttack;
	public MostolesArcaneAbomination() {
		this(new CharacterStats("Arcane Abomination",0,80,60,80,40,160,400));
	}
	public MostolesArcaneAbomination(CharacterStats characterStats) {
		super(characterStats);
		this.followUpAttack = false;
		
	}	
	@Override
	public void increaseStats() {
		if(this.characterStats.getHP()<=this.characterStats.getMaxHP()){
			this.characterStats.setMagic((int)(this.characterStats.getMagic()*MostolesAbstractFactory.INCREASE_STATS));
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
