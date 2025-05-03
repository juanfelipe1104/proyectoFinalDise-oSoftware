package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MeadowIroncladBrute extends Enemy implements IroncladBrute{
	public MeadowIroncladBrute(){
		this(new CharacterStats("Golem de Piedra",20,0,50,50,5,200,0));
	}
	public MeadowIroncladBrute(CharacterStats characterStats){
		super(characterStats);
		this.increaseStats();
	}
	
	@Override
	public void useSkill(Character target) {	
		this.increasePhysicalDefense();
	}
	@Override
	public void increasePhysicalDefense() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*1.1));
	}
	@Override
	public void increaseStats() {
		super.characterStats.increaseStats(MeadowAbstractFactory.INCREASE_STATS);
	}
}
