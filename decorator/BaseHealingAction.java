package com.utad.ds.proyectoFinal.decorator;

import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.ActionException;
import com.utad.ds.proyectoFinal.common.Character;

public class BaseHealingAction implements BaseActionComponent{
	public String getDescription() {
		return this.getActionType().getActionName();
	}
	public void healCharacter(Character performer, Integer healing){
		CharacterStats stats = performer.getCharacterStats();
		System.out.println(stats.getName() + " se ha curado " + healing + " de vida.");
		stats.setHP(stats.getHP() + healing);
		if(stats.getHP() > stats.getMaxHP()){
			stats.setHP(stats.getMaxHP());
		}
	}
	public void performAction(Character performer, Character target) throws ActionException{
		this.performAction(performer, target, 0);
	}
	public void performAction(Character performer, Character target, Integer boost) throws ActionException{
		Integer healing = BattleCalculator.getInstance().calculateHealing(performer, boost);
		this.healCharacter(performer, healing);
	}
	public ActionType getActionType() {
		return ActionType.HEAL;
	}
	public ActionComponentDecorator searchComponentDecorator(ActionComponentDecorator decorator){
		//Por debajo de la base no hay nada
		return null;
	}
	@Override
	public BaseActionComponent getBaseAction() {
		return this;
	}
	
	public void performActionFirst(Character performer, Character target) throws ActionException
	{
		this.performAction(performer, target);
	}
}
