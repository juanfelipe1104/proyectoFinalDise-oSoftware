package com.utad.ds.proyectoFinal;

public class LandOfDragonsAbstractFactory implements EnemyAbstractFactory
{

	@Override
	public ArcaneAbomination createArcaneAbomination() 
	{
		return new LandOfDragonsArcaneAbomination();
	}

	@Override
	public InfernalExecutioner createInfernalExecutioner() 
	{	
		return new LandOfDragonsInfernalExecutioner();
	}

	@Override
	public IroncladBrute createIroncladBrute() 
	{
		return new LandOfDragonsIroncladBrute();
	}

	@Override
	public Boss createBoss() 
	{
		return new LandOfDragonsBoss();
	}
	

}
