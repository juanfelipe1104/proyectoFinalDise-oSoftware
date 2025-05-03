package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.SkillBoostComponentDecorator;
import com.utad.ds.proyectoFinal.state.DeadState;

public class MagicForestBoss extends Enemy implements Boss{
	private static Integer boostIncrease = 2;
	public static Double INCREASE_STATS = 3.0;
	private Boolean revive;
	public MagicForestBoss(){
		this(new CharacterStats("Dios del bosque",30,30,30,30,150,200,100));
	}
	public MagicForestBoss(CharacterStats characterStats){
		super(characterStats);
		this.increaseStats();
		this.revive = false;
		super.magicAttackAction = new SkillBoostComponentDecorator(super.magicAttackAction,MagicForestBoss.boostIncrease++);
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
		super.characterStats.increaseStats(MagicForestBoss.INCREASE_STATS*MagicForestAbstractFactory.INCREASE_STATS);
	}
}
