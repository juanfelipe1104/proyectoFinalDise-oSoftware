package com.utad.ds.proyectoFinal;

public class GameControllerFachade implements GameController
{
	private EnemyAbstractFactory enemyAbstractFactory;

	public EnemyAbstractFactory getEnemyAbstractFactory() 
	{
		return this.enemyAbstractFactory;
	}

	public void setEnemyAbstractFactory(EnemyAbstractFactory enemyAbstractFactory) 
	{
		this.enemyAbstractFactory = enemyAbstractFactory;
	}
	
	public ArcaneAbomination createArcaneAbomination()
	{
		return this.enemyAbstractFactory.createArcaneAbomination();
	}
	
	public InfernalExecutioner createInfernalExecutioner()
	{
		return this.enemyAbstractFactory.createInfernalExecutioner();
	}
	
	public IroncladBrute createIroncladBrute()
	{
		return this.enemyAbstractFactory.createIroncladBrute();
	}

	@Override
	public void play() 
	{	
		
	}
	
	
	

	
	

}
