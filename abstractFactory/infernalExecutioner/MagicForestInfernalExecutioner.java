package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.InflictParalysisComponentDecorator;
import com.utad.ds.proyectoFinal.strategy.DefensiveBehaviorStrategy;

public class MagicForestInfernalExecutioner extends Enemy implements InfernalExecutioner{
	private static Integer boostIncrease = 1;
	public MagicForestInfernalExecutioner(){
		this(new CharacterStats("Arana magica",60,0,40,20,20,100,0));
	}
	public MagicForestInfernalExecutioner(CharacterStats characterStats){
		super(characterStats, new DefensiveBehaviorStrategy());
		this.increaseStats();
		super.physicalAttackAction = new InflictParalysisComponentDecorator(super.physicalAttackAction, MagicForestInfernalExecutioner.boostIncrease++);
	}
	
	@Override
	public void useSkill(Character target) {	
		this.increaseMagicDefense();
	}
	@Override
	public void increaseMagicDefense() {
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*1.1));
	}
	@Override
	public void increaseStats() {
		super.characterStats.increaseStats(MagicForestAbstractFactory.INCREASE_STATS);
	}
}
