package com.utad.ds.proyectoFinal;

public class BaseGuardAction implements BaseActionComponent
{
	public String getDescription() 
	{
		return this.getActionType().getActionName();
	}
	
	public void performAction(Character performer, Character target) throws ActionException
	{
		this.performAction(performer, target, 0);
	}

	public void performAction(Character performer, Character target, Integer boost) throws ActionException
	{
		performer.getCharacterStats().setGuarding(true);
		performer.getCharacterStats().setGuardingPercentage(BattleCalculator.getInstance().calculateGuardingPercentage(boost));
		System.out.println(performer.getCharacterStats().getName() + " se ha protegido.");
	}

	public ActionType getActionType() 
	{
		return ActionType.GUARD;
	}
	
	public ActionComponentDecorator searchComponentDecorator(ActionComponentDecorator decorator)
	{
		//Por debajo de la base no hay nada
		return null;
	}
}
