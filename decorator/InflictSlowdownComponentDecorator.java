package com.utad.ds.proyectoFinal.decorator;

import java.util.Random;

import com.utad.ds.proyectoFinal.common.ActionException;
import com.utad.ds.proyectoFinal.common.Character;

public class InflictSlowdownComponentDecorator extends AbstractActionComponentDecorator{
	public static final Integer BASE_INFLICT_CHANCE = 40;
	public static final Integer MAX_INFLICT_CHANCE = 100;
	public InflictSlowdownComponentDecorator(ActionComponent actionComponent, Integer level){
		super(actionComponent, level);
	}
	public String getDescription() {
		return super.getActionComponent().getDescription() + " con capacidad de ralentizar de nivel " + this.level;
	}
	//Decidimos si se inflige el estado o no aleatoriamente
	public void decideInflict(Character target){
		Integer numRandom = 0;
		Integer chance = InflictSlowdownComponentDecorator.BASE_INFLICT_CHANCE + (super.level-1)*10;
		if(chance > InflictSlowdownComponentDecorator.MAX_INFLICT_CHANCE){
			chance = InflictSlowdownComponentDecorator.MAX_INFLICT_CHANCE;
		}
		Random random = new Random();
		numRandom = random.nextInt(0, 99)+1;
		if(numRandom <= chance){
			target.removeSideEffect();
			target.applySlowDown();
		}
	}
	public void performAction(Character performer, Character target) throws ActionException{
		this.decideInflict(target);
		super.getActionComponent().performAction(performer, target);
	}
	public void performAction(Character performer, Character target, Integer boost) throws ActionException{
		this.decideInflict(target);
		super.getActionComponent().performAction(performer, target, boost);
	}
	
	public String getName()
	{
		return "Mejora de infligir ralentización";
	}
}
