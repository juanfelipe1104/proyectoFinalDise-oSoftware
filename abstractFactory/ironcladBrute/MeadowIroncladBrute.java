package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MeadowIroncladBrute extends Enemy implements IroncladBrute{
	public MeadowIroncladBrute(){
		this(new CharacterStats("Infernal Executioner",20,0,50,50,5,200,0));
	}
	public MeadowIroncladBrute(CharacterStats characterStats){
		super(characterStats);
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MeadowAbstractFactory.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MeadowAbstractFactory.INCREASE_STATS));
	}
	
	@Override
	public void useSkill(Character target) {	
		this.increasePhysicalDefense();
	}
	@Override
	public void increasePhysicalDefense() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MeadowAbstractFactory.INCREASE_STATS));
	}
}
