package com.utad.ds.proyectoFinal.strategy;

import java.util.Random;

import com.utad.ds.proyectoFinal.common.ActionException;
import com.utad.ds.proyectoFinal.common.Character;

public class OffensiveBehaviorStrategy implements EnemyBehaviorStrategy{
	//60% atacar, 20% ataque magico, 10% curacion, 10% proteccion
	public void performAction(Character performer, Character target) throws ActionException{
		Random random = new Random();
		Integer numRandom = random.nextInt(0, 99) + 1;
		//Ataque fisico
		if(numRandom <=60){
			performer.getPhysicalAttackAction().performActionFirst(performer, target);
		}
		//Ataque magico
		else if(numRandom > 60 && numRandom <=80){
			if(performer.hasEnoughMP()){
				performer.getMagicAttackAction().performActionFirst(performer, target);
			}
			//Si no tiene MP, en su lugar hace un ataque fisico
			else{
				performer.getPhysicalAttackAction().performActionFirst(performer, target);
			}
		}
		//Curarse
		else if(numRandom > 80 && numRandom <=90){
			if(performer.hasEnoughMP()){
				performer.getHealAction().performActionFirst(performer, target);
			}
			//Si no tiene MP, en su lugar se protege
			else{
				performer.getGuardAction().performActionFirst(performer, target);
			}
		}
		//Protegerse
		else{
			performer.getGuardAction().performActionFirst(performer, target);
		}
	}
	@Override
	public String toString() {
		return "OffensiveBehaviorStrategy";
	}
}
