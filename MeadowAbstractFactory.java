package com.utad.ds.proyectoFinal;

public class MeadowAbstractFactory implements EnemyAbstractFactory
{

	@Override
	public ArcaneAbomination createArcaneAbomination() 
	{
		return new MeadowArcaneAbomination();
	}

	@Override
	public InfernalExecutioner createInfernalExecutioner() 
	{	
		return new MeadowInfernalExecutioner();
	}

	@Override
	public IroncladBrute createIroncladBrute() 
	{
		return new MeadowIroncladBrute();
	}

	@Override
	public Boss createBoss() 
	{
		return new MeadowBoss();
	}
	

}
