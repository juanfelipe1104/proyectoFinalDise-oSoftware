package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class MeadowIroncladBrute extends Enemy implements IroncladBrute{
	public MeadowIroncladBrute(){
		this(new CharacterStats("Infernal Executioner",20,0,50,50,5,200,0));
	}
	public MeadowIroncladBrute(CharacterStats characterStats){
		super(characterStats);
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=(super.characterStats.getMaxHP())*0.3){
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MeadowAbstractFactory.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MeadowAbstractFactory.INCREASE_STATS));
		}
	}
	@Override
	public void useSkill() {	
		this.increasePhysicalDef();
	}
	@Override
	public void increasePhysicalDef() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MeadowAbstractFactory.INCREASE_STATS));
	}
}
