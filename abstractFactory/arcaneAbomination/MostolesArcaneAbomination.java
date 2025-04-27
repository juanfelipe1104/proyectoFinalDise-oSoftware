package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class MostolesArcaneAbomination extends Enemy implements ArcaneAbomination{
	public MostolesArcaneAbomination() {
		this(new CharacterStats("Arcane Abomination",0,80,60,80,40,160,400));
	}
	public MostolesArcaneAbomination(CharacterStats characterStats) {
		super(characterStats);
		
	}	
	@Override
	public void increaseStats() {
		if(this.characterStats.getHP()<=this.characterStats.getMaxHP()){
			this.characterStats.setMagic((int)(this.characterStats.getMagic()*MostolesAbstractFactory.INCREASE_STATS));
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
