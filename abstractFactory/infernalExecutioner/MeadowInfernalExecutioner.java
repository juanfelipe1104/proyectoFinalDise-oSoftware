package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MeadowInfernalExecutioner extends Enemy implements InfernalExecutioner{
	public MeadowInfernalExecutioner(){
		this(new CharacterStats("Bicho palo",30,0,20,10,10,50,0));
	}
	public MeadowInfernalExecutioner(CharacterStats characterStats){
		super(characterStats);
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MeadowAbstractFactory.INCREASE_STATS)));
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
