package com.utad.ds.proyectoFinal;

public class MagicForestAbstractFactory implements EnemyAbstractFactory
{

	@Override
	public ArcaneAbomination createArcaneAbomination() 
	{
		return new MagicForestArcaneAbomination();
	}

	@Override
	public InfernalExecutioner createInfernalExecutioner() 
	{	
		return new MagicForestInfernalExecutioner();
	}

	@Override
	public IroncladBrute createIroncladBrute() 
	{
		return new MagicForestIroncladBrute();
	}

	@Override
	public Boss createBoss() 
	{
		return new MagicForestBoss();
	}
	

}
