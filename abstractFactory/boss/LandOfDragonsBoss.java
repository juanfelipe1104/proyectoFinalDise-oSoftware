package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.SkillBoostComponentDecorator;
import com.utad.ds.proyectoFinal.state.DeadState;

public class LandOfDragonsBoss extends Enemy implements Boss{
	private static Integer boostIncrease = 2;
	public static Double INCREASE_STATS = 4.0;
	private Boolean revive;
	public LandOfDragonsBoss(){
		this(new CharacterStats("Dragon anciano",30,30,30,30,150,300,100));
	}
	public LandOfDragonsBoss(CharacterStats characterStats){
		super(characterStats);
		this.increaseStats();
		this.revive = false;
		super.magicAttackAction = new SkillBoostComponentDecorator(super.magicAttackAction,LandOfDragonsBoss.boostIncrease++);
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
	@Override
	public void increaseStats() {
		super.characterStats.increaseStats(LandOfDragonsBoss.INCREASE_STATS*LandOfDragonsAbstractFactory.INCREASE_STATS);
	}
}
