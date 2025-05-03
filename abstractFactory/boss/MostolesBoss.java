package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.SkillBoostComponentDecorator;
import com.utad.ds.proyectoFinal.state.DeadState;

public class MostolesBoss extends Enemy implements Boss{
	private static Integer boostIncrease = 2;
	public static Double INCREASE_STATS = 5.0;
	private Boolean revive;
	public MostolesBoss(){
		this(new CharacterStats("El capo mostoleño",30,30,30,30,150,500,100));
	}
	public MostolesBoss(CharacterStats characterStats){
		super(characterStats);
		this.increaseStats();
		this.revive = false;
		super.magicAttackAction = new SkillBoostComponentDecorator(super.magicAttackAction,MostolesBoss.boostIncrease++);
		super.physicalAttackAction = new SkillBoostComponentDecorator(super.physicalAttackAction, MostolesBoss.boostIncrease++);
		super.healAction = new SkillBoostComponentDecorator(super.healAction, MostolesBoss.boostIncrease++);
		super.guardAction = new SkillBoostComponentDecorator(super.guardAction, MostolesBoss.boostIncrease++);
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
		super.characterStats.increaseStats(MostolesBoss.INCREASE_STATS*MostolesAbstractFactory.INCREASE_STATS);
	}
}
