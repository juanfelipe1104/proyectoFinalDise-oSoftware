package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class LandOfDragonsIroncladBrute extends Enemy implements IroncladBrute{
	public LandOfDragonsIroncladBrute(){
		this(new CharacterStats("Infernal Executioner",60,0,150,150,15,600,0));
	}
	public LandOfDragonsIroncladBrute(CharacterStats characterStats){
		super(characterStats);
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=(super.characterStats.getMaxHP())*0.3){
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*LandOfDragonsAbstractFactory.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsAbstractFactory.INCREASE_STATS));
		}
	}
	@Override
	public void useSkill() {	
		this.increasePhysicalDef();;
	}
	@Override
	public void increasePhysicalDef() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsAbstractFactory.INCREASE_STATS));
	}
}
