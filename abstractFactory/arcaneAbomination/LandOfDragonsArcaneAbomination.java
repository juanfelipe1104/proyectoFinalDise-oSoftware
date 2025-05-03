package com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination;

import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.decorator.InflictParalysisComponentDecorator;
import com.utad.ds.proyectoFinal.strategy.MagicOffensiveBehaviorStrategy;

public class LandOfDragonsArcaneAbomination extends Enemy implements ArcaneAbomination {
	private static Integer boostIncrease = 1;
	private Boolean followUpAttack;
	public LandOfDragonsArcaneAbomination() {
		this(new CharacterStats("Dragon de mana",0,60,45,60,20,80,300));
	}
	public LandOfDragonsArcaneAbomination(CharacterStats characterStats) {
		super(characterStats, new MagicOffensiveBehaviorStrategy());
		this.increaseStats();
		this.followUpAttack = false;
		super.magicAttackAction = new InflictParalysisComponentDecorator(super.magicAttackAction,LandOfDragonsArcaneAbomination.boostIncrease++);
	}

	@Override
	public void followUpAttack(Character opponent) {	
		if(!this.followUpAttack){
			this.followUpAttack = true;
			System.out.println(super.characterStats.getName() + " ataca de nuevo");
			this.performAction(opponent);
		}
	}
	@Override
	public void useSkill(Character opponent) {	
		this.followUpAttack(opponent);
	}
	@Override
	public void increaseStats() {
		super.characterStats.increaseStats(LandOfDragonsAbstractFactory.INCREASE_STATS);
	}
}
