package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class LandOfDragonsIroncladBrute extends Enemy implements IroncladBrute{
	public LandOfDragonsIroncladBrute(){
		this(new CharacterStats("Infernal Executioner",60,0,150,150,15,600,0));
	}
	public LandOfDragonsIroncladBrute(CharacterStats characterStats){
		super(characterStats);
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*LandOfDragonsAbstractFactory.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsAbstractFactory.INCREASE_STATS));
	}
	
	@Override
	public void useSkill(Character target) {	
		this.increasePhysicalDefense();;
	}
	@Override
	public void increasePhysicalDefense() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsAbstractFactory.INCREASE_STATS));
	}
}
