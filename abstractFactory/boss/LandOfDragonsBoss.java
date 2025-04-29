package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.SkillBoostComponentDecorator;
import com.utad.ds.proyectoFinal.state.DeadState;

public class LandOfDragonsBoss extends Enemy implements Boss{
	private static Integer boostIncrease = 2;
	public static final Double INCREASE_STATS = 4.0;
	private Boolean revive;
	public LandOfDragonsBoss(){
		this(new CharacterStats("Dragon anciano",30,30,30,30,150,300,100));
	}
	public LandOfDragonsBoss(CharacterStats characterStats){
		super(characterStats);
		this.revive = false;
		super.magicAttackAction = new SkillBoostComponentDecorator(super.magicAttackAction,LandOfDragonsBoss.boostIncrease++);
		super.physicalAttackAction = new SkillBoostComponentDecorator(super.physicalAttackAction, LandOfDragonsBoss.boostIncrease++);
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*LandOfDragonsBoss.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsBoss.INCREASE_STATS));
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*LandOfDragonsBoss.INCREASE_STATS)));
		super.characterStats.setMagic(((int)(super.characterStats.getMagic()*LandOfDragonsBoss.INCREASE_STATS)));
	}
	
	@Override
	public void useSkill(Character target) {	
		this.revive();
	}
	@Override
	public void revive() {	
		if(this.revive.equals(false) && super.getCurrentState() instanceof DeadState){
			this.revive = true;
			System.out.println(super.characterStats.getName() + " ha revivido");
			super.characterStats.setHP(super.characterStats.getMaxHP());
			super.currentState = super.baseState;
		}
	}
}
