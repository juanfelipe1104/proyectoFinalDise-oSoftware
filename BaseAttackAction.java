package com.utad.ds.proyectoFinal;

public class BaseAttackAction implements BaseActionComponent
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
		CharacterStats performerStats = performer.getCharacterStats();
		CharacterStats targetStats = target.getCharacterStats();
		
		Integer damage = BattleCalculator.getInstance().calculatePhysicalDamage(performer, target, boost);
		
		if(damage <= 0)	//Ataque reflejado
		{
			System.out.println(targetStats.getName() + " ha reflejado el ataque, " + performerStats.getName() + " se ha hecho " + -damage + " de daño.");
			performerStats.setHP(performerStats.getHP() + damage);
			if(performerStats.getHP() <= 0)	//Muere el atacante
			{
				performer.killCharacter();
			}
		}
		
		else	//Ataque exitoso
		{
			System.out.println(performerStats.getName() + " ha atacado a " + targetStats.getName() + " y le ha hecho " + damage + " de daño.");
			targetStats.setHP(targetStats.getHP() - damage);
			if(targetStats.getHP() <= 0)	//Muere el objetivo
			{
				target.killCharacter();
			}
		}
	}

	public ActionType getActionType() 
	{
		return ActionType.ATK;
	}
	
	public ActionComponentDecorator searchComponentDecorator(ActionComponentDecorator decorator)
	{
		//Por debajo de la base no hay nada
		return null;
	}
	
}
