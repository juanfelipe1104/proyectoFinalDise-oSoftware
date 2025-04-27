package com.utad.ds.proyectoFinal.facade;

import com.utad.ds.proyectoFinal.abstractFactory.EnemyAbstractFactory;
import com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination.ArcaneAbomination;
import com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner.InfernalExecutioner;
import com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute.IroncladBrute;

public class GameControllerFachade implements GameController{
	private EnemyAbstractFactory enemyAbstractFactory;
	public EnemyAbstractFactory getEnemyAbstractFactory() {
		return this.enemyAbstractFactory;
	}
	public void setEnemyAbstractFactory(EnemyAbstractFactory enemyAbstractFactory) {
		this.enemyAbstractFactory = enemyAbstractFactory;
	}
	public ArcaneAbomination createArcaneAbomination(){
		return this.enemyAbstractFactory.createArcaneAbomination();
	}
	public InfernalExecutioner createInfernalExecutioner(){
		return this.enemyAbstractFactory.createInfernalExecutioner();
	}
	public IroncladBrute createIroncladBrute(){
		return this.enemyAbstractFactory.createIroncladBrute();
	}
	@Override
	public void play() {	
		
	}
}
