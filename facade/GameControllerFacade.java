package com.utad.ds.proyectoFinal.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.utad.ds.proyectoFinal.abstractFactory.EnemyFactoryContext;
import com.utad.ds.proyectoFinal.abstractFactory.LandOfDragonsAbstractFactory;
import com.utad.ds.proyectoFinal.abstractFactory.MagicForestAbstractFactory;
import com.utad.ds.proyectoFinal.abstractFactory.MeadowAbstractFactory;
import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.abstractFactory.boss.Boss;
import com.utad.ds.proyectoFinal.abstractFactory.boss.MostolesBoss;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.common.ItemDisplay;
import com.utad.ds.proyectoFinal.common.Player;
import com.utad.ds.proyectoFinal.state.DeadState;

public class GameControllerFacade implements GameController{
	public static List<String> GAME_OPTIONS;   //Se usará luego para pedir la acción
	public static List<String> ATK_TYPES;
	public static List<String> VICTORY_OPTIONS;
	static {
		GameControllerFacade.ATK_TYPES = new ArrayList<String>();
		GameControllerFacade.ATK_TYPES.add("Ataque fisico");
		GameControllerFacade.ATK_TYPES.add("Ataque magico");
		GameControllerFacade.GAME_OPTIONS = new ArrayList<String>();
		GameControllerFacade.GAME_OPTIONS.add("Atacar");
		GameControllerFacade.GAME_OPTIONS.add("Defenderse");
		GameControllerFacade.GAME_OPTIONS.add("Curarse");
		GameControllerFacade.GAME_OPTIONS.add("Usar item");
		GameControllerFacade.VICTORY_OPTIONS = new ArrayList<String>();
		GameControllerFacade.VICTORY_OPTIONS.add("Dejar de jugar");
		GameControllerFacade.VICTORY_OPTIONS.add("Jugar otra partida, con enemigos mas dificiles");
	}
	//Método para dar a elegir varias opciones de una lista
	public static Integer pantallaDeSeleccion(List<?> lista){
		Scanner scanner = new Scanner(System.in);
		Integer resultado = 0;
		System.out.println("0 - Salir");
		for(int i = 1; i <= lista.size(); i++){
			System.out.println(i + " - " + lista.get(i-1));
		}
		do{
			System.out.println("Elige una opción:");
			resultado = scanner.nextInt();
			if(resultado < 0 || resultado > (lista.size()+1)){
				System.out.println("Error: La opción está fuera del rango");
			}
		}
		while(resultado < 0 || resultado > (lista.size()+1));   //Sigue hasta que elija una opcion valida
		return resultado;
	}
	private Character player;
	private Character enemy;
	private Boolean victory;
	private Integer roundNumber;
	private Integer worldNumber;
	private Boolean salir;
	private ItemDisplay itemDisplay;
	public GameControllerFacade() {
		this.createPlayer();
		this.enemy = EnemyFactoryContext.getInstance().createRandomEnemy();
		this.victory = false;
		this.salir = false;
		this.roundNumber = 0;
	}
	private void createPlayer() {
		Scanner scanner = new Scanner(System.in);
		String nombre = null;
		System.out.println("Ingrese el nombre de jugador");
		nombre = scanner.next();
		this.player = new Player(nombre);
	}
	@Override
	public void play() {
		while(!this.salir && !this.isCharacterDead(this.player)) {
			System.out.println("Jugador: " + this.player);
			System.out.println("Enemigo: " + this.enemy);
			this.choosePlayerAction(GameControllerFacade.pantallaDeSeleccion(GameControllerFacade.GAME_OPTIONS));
			this.playTurn();
			if(this.isCharacterDead(this.enemy)) {
				this.createEnemy();
			}
		}
		if(this.isCharacterDead(this.player)){
			System.out.println("Perdiste, buena partida");
		}
		else if(this.victory){
			System.out.println("Ganaste. Tienes dos opciones:");
			this.chooseVictoryOption(GameControllerFacade.pantallaDeSeleccion(VICTORY_OPTIONS)); 
		}
	}
	
	private void chooseVictoryOption(Integer option){
		switch(option){
			case 0:
				System.out.println("Gracias por jugar");
				this.salir = true;
			break;
			case 1:
				System.out.println("Empieza una nueva partida");
				this.worldNumber = 1;
				this.changeWorld();
			break;
		}	
	}
	
	private void createEnemy(){
		this.roundNumber++;
		if(this.enemy instanceof Boss) {
			this.worldNumber++;
			if(this.enemy instanceof MostolesBoss) {
				this.victory = true;
			}
			this.changeWorld();
		}
		else {
			if(this.roundNumber.equals(4)){
				this.enemy = (Enemy) EnemyFactoryContext.getInstance().createBoss();
				System.out.println("Ha aparecido el jefe " + this.enemy.getCharacterStats().getName());
			}
			else{
				this.enemy = EnemyFactoryContext.getInstance().createRandomEnemy();
				System.out.println("Se ha generado un nuevo enemigo");		
			}
		}
	}
	private void changeWorld() {
		switch(this.worldNumber) {
		case 1:
			EnemyFactoryContext.getInstance().setEnemyAbstractFactory(new MeadowAbstractFactory());
			System.out.println("Has entrado en la pradera");
		break;
		case 2:
			EnemyFactoryContext.getInstance().setEnemyAbstractFactory(new MagicForestAbstractFactory());
			System.out.println("Has entrado al bosque magico");
		break;
		case 3:
			EnemyFactoryContext.getInstance().setEnemyAbstractFactory(new LandOfDragonsAbstractFactory());
			System.out.println("Has entrado a la tierra de los dragones");
		break;
		case 4:
			EnemyFactoryContext.getInstance().setEnemyAbstractFactory(new MostolesAbstractFactory());
			System.out.println("Has entrado en Mostoles. Revisa tus bolsillos.");
			this.worldNumber = 1;
		break;
		}
	}
	private Boolean isCharacterDead(Character character) {
		Boolean isDead = false;
		if(character.getCurrentState() instanceof DeadState) {
			isDead = true;
		}
		return isDead;
	}
	private void choosePlayerAction(Integer option) {
		switch(option) {
		case 0:
			this.salir = true;
		break;
		case 1:
			this.chooseAttackType(GameControllerFacade.pantallaDeSeleccion(GameControllerFacade.ATK_TYPES));
		break;
		case 2:
			this.player.setCurrentAction(this.player.getGuardAction());
		break;
		case 3:
			this.player.setCurrentAction(this.player.getHealAction());
		break;
		case 4:
			this.itemDisplay=new ItemDisplay((Player)this.player);
			this.itemDisplay.selectUpgrade();
		break;
		}
	}
	private void chooseAttackType(Integer option) {
		switch(option) {
		case 1:
			this.player.setCurrentAction(this.player.getPhysicalAttackAction());
		break;
		case 2:
			this.player.setCurrentAction(this.player.getMagicAttackAction());
		break;
		default:
			this.player.setCurrentAction(this.player.getPhysicalAttackAction());
		break;
		}
	}
	private void playTurn() {
		if(!this.salir) {
			this.player.playTurn(this.enemy);
			this.enemy.playTurn(this.player);
		}
		
	}
}
