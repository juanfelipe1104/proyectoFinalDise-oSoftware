package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class MostolesIroncladBrute extends Enemy implements IroncladBrute{
	public MostolesIroncladBrute(){
		this(new CharacterStats("Infernal Executioner",80,0,200,200,20,800,0));
	}
	public MostolesIroncladBrute(CharacterStats characterStats){
		super(characterStats);
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=(super.characterStats.getMaxHP())*0.3){
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MostolesAbstractFactory.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MostolesAbstractFactory.INCREASE_STATS));
		}
	}
	@Override
	public void useSkill() {	
		this.increasePhysicalDef();
	}
	@Override
	public void increasePhysicalDef() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MostolesAbstractFactory.INCREASE_STATS));
	}
}
