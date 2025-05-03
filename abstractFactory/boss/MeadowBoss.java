package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.state.DeadState;

public class MeadowBoss extends Enemy implements Boss{
	public static Double INCREASE_STATS = 2.0;
	private Boolean revive;
	public MeadowBoss(){
		this(new CharacterStats("Brr Brr Patapim",30,30,30,30,150,100,100));
	}
	public MeadowBoss(CharacterStats characterStats){
		super(characterStats);
		this.increaseStats();
		this.revive = false;
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
		super.characterStats.increaseStats(MeadowBoss.INCREASE_STATS*MeadowAbstractFactory.INCREASE_STATS);
	}
}
