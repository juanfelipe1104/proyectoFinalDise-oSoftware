package com.utad.ds.proyectoFinal;

import java.util.Random;

public class BalancedBehaviorStrategy implements EnemyBehaviorStrategy
{
	//25% atacar, 25% ataque magico, 25% curacion, 25% proteccion
	public void performAction(Character performer, Character target) throws ActionException
	{
		Random random = new Random();
		Integer numRandom = random.nextInt(0, 99) + 1;
			
		//Ataque fisico
		if(numRandom <=25)
		{
			performer.getPhysicalAttackAction().performAction(performer, target);
		}
			
		//Ataque magico
		else if(numRandom > 25 && numRandom <=50)
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
		else if(numRandom > 50 && numRandom <=75)
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
