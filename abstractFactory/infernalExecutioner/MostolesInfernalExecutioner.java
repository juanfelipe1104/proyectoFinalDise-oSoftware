package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MostolesInfernalExecutioner extends Enemy implements InfernalExecutioner{
	public MostolesInfernalExecutioner(){
		this(new CharacterStats("Infernal Executioner",120,0,80,40,40,200,0));
	}
	public MostolesInfernalExecutioner(CharacterStats characterStats){
		super(characterStats);
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MostolesAbstractFactory.INCREASE_STATS)));
		}
	}
	@Override
	public void useSkill(Character target) {	
		this.increaseMagicDefense();
	}
	@Override
	public void increaseMagicDefense() {
		super.characterStats.setMagicDef(super.characterStats.getMagicDef()+10);
	}
}

