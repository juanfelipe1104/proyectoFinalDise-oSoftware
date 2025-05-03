package com.utad.ds.proyectoFinal.abstractFactory;

import java.util.Random;

import com.utad.ds.proyectoFinal.abstractFactory.arcaneAbomination.ArcaneAbomination;
import com.utad.ds.proyectoFinal.abstractFactory.boss.Boss;
import com.utad.ds.proyectoFinal.abstractFactory.infernalExecutioner.InfernalExecutioner;
import com.utad.ds.proyectoFinal.abstractFactory.ironcladBrute.IroncladBrute;
import com.utad.ds.proyectoFinal.common.Enemy;

public class EnemyFactoryContext {
	private static EnemyFactoryContext enemyFactoryContext = new EnemyFactoryContext(new MeadowAbstractFactory());
	public static EnemyFactoryContext getInstance() {
		return EnemyFactoryContext.enemyFactoryContext;
	}
	private EnemyAbstractFactory enemyAbstractFactory;
	private EnemyFactoryContext(EnemyAbstractFactory enemyAbstractFactory) {
		this.enemyAbstractFactory = enemyAbstractFactory;
	}
	public ArcaneAbomination createArcaneAbomination() {
		return this.enemyAbstractFactory.createArcaneAbomination();
	}
	public InfernalExecutioner createInfernalExecutioner() {
		return this.enemyAbstractFactory.createInfernalExecutioner();
	}
	public IroncladBrute createIroncladBrute() {
		return this.enemyAbstractFactory.createIroncladBrute();
	}
	public Boss createBoss(){
		return this.enemyAbstractFactory.createBoss();
	}
	public void setEnemyAbstractFactory(EnemyAbstractFactory enemyAbstractFactory) {
		this.enemyAbstractFactory = enemyAbstractFactory;
	}
	public Enemy createRandomEnemy() {
		Random random = new Random();
		Integer randomNumber = random.nextInt(0,99);
		Enemy randomEnemy = null;
		if(randomNumber < 30) {
			 randomEnemy = (Enemy) this.createArcaneAbomination();
		}
		else if(randomNumber < 60) {
			randomEnemy = (Enemy) this.createInfernalExecutioner();
		}
		else {
			randomEnemy = (Enemy) this.createIroncladBrute();
		}
		return randomEnemy;
	}
	public void increaseStats(Integer run) {
		MeadowAbstractFactory.INCREASE_STATS *= (2*run);
		MagicForestAbstractFactory.INCREASE_STATS *= (2*run);
		LandOfDragonsAbstractFactory.INCREASE_STATS *= (2*run);
		MostolesAbstractFactory.INCREASE_STATS *= (2*run);
	}
}
