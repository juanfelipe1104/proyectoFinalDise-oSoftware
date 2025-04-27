package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class MeadowInfernalExecutioner extends Enemy implements InfernalExecutioner{
	public MeadowInfernalExecutioner(){
		this(new CharacterStats("Infernal Executioner",30,0,20,10,10,50,0));
	}
	public MeadowInfernalExecutioner(CharacterStats characterStats){
		super(characterStats);
	}
	@Override
	public void ignoreDefense() {
		//llamar a algo	
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MeadowAbstractFactory.INCREASE_STATS)));
		}
	}
	@Override
	public void useSkill() {	
		this.ignoreDefense();
	}
}
