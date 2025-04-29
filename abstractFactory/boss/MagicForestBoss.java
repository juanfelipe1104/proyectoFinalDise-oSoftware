package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.SkillBoostComponentDecorator;
import com.utad.ds.proyectoFinal.state.DeadState;

public class MagicForestBoss extends Enemy implements Boss{
	private static Integer boostIncrease = 2;
	public static final Double INCREASE_STATS = 3.0;
	private Boolean revive;
	public MagicForestBoss(){
		this(new CharacterStats("Dios del bosque",30,30,30,30,150,200,100));
	}
	public MagicForestBoss(CharacterStats characterStats){
		super(characterStats);
		this.revive = false;
		super.magicAttackAction = new SkillBoostComponentDecorator(super.magicAttackAction,MagicForestBoss.boostIncrease++);
		super.physicalAttackAction = new SkillBoostComponentDecorator(super.physicalAttackAction, MagicForestBoss.boostIncrease++);
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MagicForestBoss.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MagicForestBoss.INCREASE_STATS));
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MagicForestBoss.INCREASE_STATS)));
		super.characterStats.setMagic(((int)(super.characterStats.getMagic()*MagicForestBoss.INCREASE_STATS)));
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
