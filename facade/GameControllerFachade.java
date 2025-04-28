package com.utad.ds.proyectoFinal.facade;

import java.util.Scanner;

import com.utad.ds.proyectoFinal.abstractFactory.EnemyFactoryContext;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.Player;
import com.utad.ds.proyectoFinal.state.DeadState;

public class GameControllerFachade implements GameController{
	private Character player;
	private Character enemy;
	public GameControllerFachade() {
		this.createPlayer();
		this.enemy = EnemyFactoryContext.getInstance().createRandomEnemy();
	}
	private void createPlayer() {
		Scanner scanner = new Scanner(System.in);
		String nombre;
		System.out.println("Ingrese el nombre de jugador");
		nombre = scanner.next();
		this.player = new Player(nombre);
	}
	@Override
	public void play() {
		Scanner scanner = new Scanner(System.in);
		Integer opcion = 0;
		Boolean salir = false;
		while(!salir && !(player.getCurrentState() instanceof DeadState)) {
			System.out.println("Te enfrentas a " + this.enemy);
			System.out.println("1. Atacar enemigo");
			System.out.println("2. Defender");
			System.out.println("3. Curarse");
			System.out.println("4. Salir");
			opcion = scanner.nextInt();
			switch(opcion) {
			case 1:
				opcion = 0;
				System.out.println("Usar ataque fisico o magico");
				System.out.println("1. Fisico");
				System.out.println("2. Magico");
				opcion = scanner.nextInt();
				switch(opcion) {
				case 1:
					this.player.setCurrentAction(this.player.getPhysicalAttackAction());
				break;
				case 2:
					this.player.setCurrentAction(this.player.getMagicAttackAction());
				break;
				}
			break;
			case 2:
				this.player.setCurrentAction(this.player.getGuardAction());
			break;
			case 3:
				this.player.setCurrentAction(this.player.getHealAction());
			break;
			case 4:
				salir = true;
			}
			if(!salir) {
				this.player.playTurn(this.enemy);
				this.enemy.playTurn(this.player);
			}
			if(this.enemy.getCurrentState() instanceof DeadState) {
				this.enemy = EnemyFactoryContext.getInstance().createRandomEnemy();
				System.out.println("Se ha generado un nuevo enemigo");
			}
		}
	}
}
