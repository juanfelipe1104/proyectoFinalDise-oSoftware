package com.utad.ds.proyectoFinal;

public interface EnemyBehaviorStrategy 
{
	public void chooseBehavior(Character performer, Character target) throws ActionException;
}
