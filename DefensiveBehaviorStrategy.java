package com.utad.ds.proyectoFinal;

import java.util.Random;

public class DefensiveBehaviorStrategy implements EnemyBehaviorStrategy
{
	//20% atacar, 10% ataque magico, 20% curacion, 50% proteccion
	public void performAction(Character performer, Character target) throws ActionException
	{
		Random random = new Random();
		Integer numRandom = random.nextInt(0, 99) + 1;
			
		//Ataque fisico
		if(numRandom <=20)
		{
			performer.getPhysicalAttackAction().performAction(performer, target);
		}
			
		//Ataque magico
		else if(numRandom > 20 && numRandom <=30)
		{
			if(performer.getCharacterStats().getMP() >= Enemy.MP_COST)
			{
				performer.getMagicAttackAction().performAction(performer, target);
				performer.getCharacterStats().setMP(performer.getCharacterStats().getMP() - Enemy.MP_COST);
			}
				
			//Si no tiene MP, en su lugar hace un ataque fisico
			else
			{
					performer.getPhysicalAttackAction().performAction(performer, target);
			}
		}
			
		//Curarse
		else if(numRandom > 30 && numRandom <=50)
		{
			if(performer.getCharacterStats().getMP() >= Enemy.MP_COST)
			{
				performer.getHealAction().performAction(performer, target);
				performer.getCharacterStats().setMP(performer.getCharacterStats().getMP() - Enemy.MP_COST);
			}
				
			//Si no tiene MP, en su lugar se protege
			else
			{
				performer.getGuardAction().performAction(performer, target);
			}
		}
			
		//Protegerse
		else
		{
			performer.getGuardAction().performAction(performer, target);
		}
	}
}
