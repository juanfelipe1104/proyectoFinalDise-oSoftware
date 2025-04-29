package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.SkillBoostComponentDecorator;
import com.utad.ds.proyectoFinal.strategy.DefensiveBehaviorStrategy;

public class MagicForestIroncladBrute extends Enemy implements IroncladBrute{
	private static Integer boostIncrease = 1;
	public MagicForestIroncladBrute(){
		this(new CharacterStats("Golem arcano",40,0,100,100,10,400,0));
	}
	public MagicForestIroncladBrute(CharacterStats characterStats){
		super(characterStats, new DefensiveBehaviorStrategy());
		super.guardAction = new SkillBoostComponentDecorator(super.guardAction, MagicForestIroncladBrute.boostIncrease++);
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
