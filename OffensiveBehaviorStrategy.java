package com.utad.ds.proyectoFinal;
import java.util.Random;


public class OffensiveBehaviorStrategy implements EnemyBehaviorStrategy
{
	//60% atacar, 20% ataque magico, 10% curacion, 10% proteccion
	public void performAction(Character performer, Character target) throws ActionException
	{
		Random random = new Random();
		Integer numRandom = random.nextInt(0, 99) + 1;
		
		//Ataque fisico
		if(numRandom <=60)
		{
			performer.getPhysicalAttackAction().performAction(performer, target);
		}
		
		//Ataque magico
		else if(numRandom > 60 && numRandom <=80)
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
		else if(numRandom > 80 && numRandom <=90)
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
