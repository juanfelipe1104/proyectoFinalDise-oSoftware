package com.utad.ds.proyectoFinal;

public interface EnemyBehaviorStrategy 
{
	public void performAction(Character performer, Character target) throws ActionException;
}
