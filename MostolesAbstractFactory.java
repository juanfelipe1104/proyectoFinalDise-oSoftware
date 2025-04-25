package com.utad.ds.proyectoFinal;

public class MostolesAbstractFactory implements EnemyAbstractFactory
{

	@Override
	public ArcaneAbomination createArcaneAbomination() 
	{
		return new MostolesArcaneAbomination();
	}

	@Override
	public InfernalExecutioner createInfernalExecutioner() 
	{	
		return new MostolesInfernalExecutioner();
	}

	@Override
	public IroncladBrute createIroncladBrute() 
	{
		return new MostolesIroncladBrute();
	}

	@Override
	public Boss createBoss() 
	{
		return new MostolesBoss();
	}
	

}
