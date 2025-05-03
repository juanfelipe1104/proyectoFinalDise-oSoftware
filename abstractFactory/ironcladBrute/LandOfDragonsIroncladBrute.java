package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.SkillBoostComponentDecorator;
import com.utad.ds.proyectoFinal.strategy.OffensiveBehaviorStrategy;

public class LandOfDragonsIroncladBrute extends Enemy implements IroncladBrute{
	private static Integer boostIncrease = 1;
	public LandOfDragonsIroncladBrute(){
		this(new CharacterStats("Golem igneo",60,0,150,150,15,600,0));
	}
	public LandOfDragonsIroncladBrute(CharacterStats characterStats){
		super(characterStats, new OffensiveBehaviorStrategy());
		this.increaseStats();
		super.physicalAttackAction = new SkillBoostComponentDecorator(super.physicalAttackAction, LandOfDragonsIroncladBrute.boostIncrease++);
	}
	
	@Override
	public void useSkill(Character target) {	
		this.increasePhysicalDefense();;
	}
	@Override
	public void increasePhysicalDefense() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*1.1));
	}
	@Override
	public void increaseStats() {
		super.characterStats.increaseStats(LandOfDragonsAbstractFactory.INCREASE_STATS);
	}
}
