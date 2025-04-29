package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class LandOfDragonsInfernalExecutioner extends Enemy implements InfernalExecutioner{
	public LandOfDragonsInfernalExecutioner(){
		this(new CharacterStats("Infernal Executioner",90,0,60,30,30,150,0));
	}
	public LandOfDragonsInfernalExecutioner(CharacterStats characterStats){
		super(characterStats);
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*LandOfDragonsAbstractFactory.INCREASE_STATS)));
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
