package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MagicForestIroncladBrute extends Enemy implements IroncladBrute{
	public MagicForestIroncladBrute(){
		this(new CharacterStats("Infernal Executioner",40,0,100,100,10,400,0));
	}
	public MagicForestIroncladBrute(CharacterStats characterStats){
		super(characterStats);
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MagicForestAbstractFactory.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MagicForestAbstractFactory.INCREASE_STATS));
	}
	
	@Override
	public void useSkill(Character target) {	
		this.increasePhysicalDefense();
	}
	@Override
	public void increasePhysicalDefense() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MagicForestAbstractFactory.INCREASE_STATS));
	}
}
