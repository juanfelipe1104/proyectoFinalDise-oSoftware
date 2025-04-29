package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.state.DeadState;

public class MeadowBoss extends Enemy implements Boss{
	public static final Double INCREASE_STATS = 2.0;
	private Boolean revive;
	public MeadowBoss(){
		this(new CharacterStats("Brr Brr Patapim",30,30,30,30,150,100,100));
	}
	public MeadowBoss(CharacterStats characterStats){
		super(characterStats);
		this.revive = false;
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MeadowBoss.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MeadowBoss.INCREASE_STATS));
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MeadowBoss.INCREASE_STATS)));	
		super.characterStats.setMagic(((int)(super.characterStats.getMagic()*MeadowBoss.INCREASE_STATS)));	
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
