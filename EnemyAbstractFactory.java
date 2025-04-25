package com.utad.ds.proyectoFinal;

public interface EnemyAbstractFactory 
{
	public ArcaneAbomination createArcaneAbomination();
	public InfernalExecutioner createInfernalExecutioner();
	public IroncladBrute createIroncladBrute();
	public Boss createBoss();
}
