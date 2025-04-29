package com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.AbsorbDamageComponentDecorator;
import com.utad.ds.proyectoFinal.strategy.OffensiveBehaviorStrategy;

public class LandOfDragonsInfernalExecutioner extends Enemy implements InfernalExecutioner{
	private static Integer boostIncrease = 1;
	public static final Integer MAX_MAGICDEF = 200;
	public LandOfDragonsInfernalExecutioner(){
		this(new CharacterStats("Dragon veloz",90,0,60,30,30,150,0));
	}
	public LandOfDragonsInfernalExecutioner(CharacterStats characterStats){
		super(characterStats, new OffensiveBehaviorStrategy());
		super.physicalAttackAction = new AbsorbDamageComponentDecorator(super.physicalAttackAction, LandOfDragonsInfernalExecutioner.boostIncrease++);
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*LandOfDragonsAbstractFactory.INCREASE_STATS)));
	}
	

	@Override
	public void useSkill(Character target) {	
		this.increaseMagicDefense();
	}
	@Override
	public void increaseMagicDefense() {
		if(super.characterStats.getMagicDef() < LandOfDragonsInfernalExecutioner.MAX_MAGICDEF) {
			super.characterStats.setMagicDef(super.characterStats.getMagicDef()+10);
		}
	}
}
