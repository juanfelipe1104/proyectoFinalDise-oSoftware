package com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute;

import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.ReflectDamageComponentDecorator;
import com.utad.ds.proyectoFinal.strategy.DefensiveBehaviorStrategy;

public class MostolesIroncladBrute extends Enemy implements IroncladBrute{
	private static Integer boostIncrease = 1;
	public MostolesIroncladBrute(){
		this(new CharacterStats("Guardia de discoteca",80,0,200,200,20,800,0));
	}
	public MostolesIroncladBrute(CharacterStats characterStats){
		super(characterStats, new DefensiveBehaviorStrategy());
		super.guardAction = new ReflectDamageComponentDecorator(super.guardAction, MostolesIroncladBrute.boostIncrease++);
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MostolesAbstractFactory.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MostolesAbstractFactory.INCREASE_STATS));
	}

	@Override
	public void useSkill(Character target) {	
		this.increasePhysicalDefense();
	}
	@Override
	public void increasePhysicalDefense() {
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MostolesAbstractFactory.INCREASE_STATS));
	}
}
