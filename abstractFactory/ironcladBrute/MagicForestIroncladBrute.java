package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class MagicForestIroncladBrute extends Enemy implements IroncladBrute{
	public MagicForestIroncladBrute(){
		this(new CharacterStats("Infernal Executioner",40,0,100,100,10,400,0));
	}
	public MagicForestIroncladBrute(CharacterStats characterStats){
		super(characterStats);
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=(super.characterStats.getMaxHP())*0.3){
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MagicForestAbstractFactory.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MagicForestAbstractFactory.INCREASE_STATS));
		}
	}
	@Override
	public void useSkill() {	
		this.increasePhysicalDef();
	}
	@Override
	public void increasePhysicalDef() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MagicForestAbstractFactory.INCREASE_STATS));
	}
}
