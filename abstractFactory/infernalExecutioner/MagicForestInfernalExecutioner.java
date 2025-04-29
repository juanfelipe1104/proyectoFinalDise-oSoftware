package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MagicForestInfernalExecutioner extends Enemy implements InfernalExecutioner{
	public MagicForestInfernalExecutioner(){
		this(new CharacterStats("Infernal Executioner",60,0,40,20,20,100,0));
	}
	public MagicForestInfernalExecutioner(CharacterStats characterStats){
		super(characterStats);
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MagicForestAbstractFactory.INCREASE_STATS)));
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
