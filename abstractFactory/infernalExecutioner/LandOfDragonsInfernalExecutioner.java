package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.*;

public class LandOfDragonsInfernalExecutioner extends Enemy implements InfernalExecutioner{
	public LandOfDragonsInfernalExecutioner(){
		this(new CharacterStats("Infernal Executioner",90,0,60,30,30,150,0));
	}
	public LandOfDragonsInfernalExecutioner(CharacterStats characterStats){
		super(characterStats);
	}
	@Override
	public void ignoreDefense() {
		//llamar a algo	
	}
	@Override
	public void increaseStats() {
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP()){
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*LandOfDragonsAbstractFactory.INCREASE_STATS)));
		}
	}
	@Override
	public void useSkill() {	
		this.ignoreDefense();
	}
}
