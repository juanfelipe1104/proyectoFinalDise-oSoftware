package com.utad.ds.proyectoFinal.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.utad.ds.proyectoFinal.abstractFactory.EnemyFactoryContext;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.Enemy;
import com.utad.ds.proyectoFinal.common.ItemDisplay;
import com.utad.ds.proyectoFinal.common.Player;
import com.utad.ds.proyectoFinal.state.DeadState;

public class GameControllerFachade implements GameController{
	public static List<String> GAME_OPTIONS;   //Se usará luego para pedir la acción
	public static List<String> ATK_TYPES;
	public static List<String> VICTORY_OPTIONS;
	static {
		GameControllerFachade.ATK_TYPES = new ArrayList<String>();
		GameControllerFachade.ATK_TYPES.add("Ataque fisico");
		GameControllerFachade.ATK_TYPES.add("Ataque magico");
		GameControllerFachade.GAME_OPTIONS = new ArrayList<String>();
		GameControllerFachade.GAME_OPTIONS.add("Atacar");
		GameControllerFachade.GAME_OPTIONS.add("Defenderse");
		GameControllerFachade.GAME_OPTIONS.add("Curarse");
		GameControllerFachade.GAME_OPTIONS.add("Usar item");
		GameControllerFachade.VICTORY_OPTIONS = new ArrayList<String>();
		GameControllerFachade.VICTORY_OPTIONS.add("Dejar de jugar");
		GameControllerFachade.VICTORY_OPTIONS.add("Jugar otra partida, con enemigos mas dificiles");
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
	private Boolean salir;
	private ItemDisplay itemDisplay;
	public GameControllerFachade() {
		this.createPlayer();
		this.enemy = EnemyFactoryContext.getInstance().createRandomEnemy();
		this.victory = false;
		this.salir=false;
		this.roundNumber=0;
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
			this.choosePlayerAction(GameControllerFachade.pantallaDeSeleccion(GameControllerFachade.GAME_OPTIONS));
			this.playTurn();
			if(this.isCharacterDead(this.enemy)) {
				
				createEnemy();
			}
		}
		if(this.isCharacterDead(this.player))
		{
			System.out.println("Perdiste, buena partida");
		}
		else if(this.victory)
		{
			System.out.println("Ganaste,Tienes dos opciones:");
			this.chooseVictoryOption(GameControllerFachade.pantallaDeSeleccion(VICTORY_OPTIONS)); 
		}
	}
	
	private void chooseVictoryOption(Integer option)
	{
		switch(option)
		{
			case 0:
				System.out.println("Gracias por jugar");
				salir = true;
			break;
			case 1:
				System.out.println("Empieza una nueva partida");
				
			break;
		
		}
			
	}
	
	private void createEnemy()
	{
		this.roundNumber++;
		if(this.roundNumber.equals(4))
		{
			this.enemy = (Enemy) EnemyFactoryContext.getInstance().createBoss();
			System.out.println("Se ha generado un jefe");
		}
		else
		{
			this.enemy = EnemyFactoryContext.getInstance().createRandomEnemy();
			System.out.println("Se ha generado un nuevo enemigo");		
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
			this.victory = true;
		break;
		case 1:
			this.chooseAttackType(GameControllerFachade.pantallaDeSeleccion(GameControllerFachade.ATK_TYPES));
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
		if(!this.victory) {
			
			this.player.playTurn(this.enemy);
			this.enemy.playTurn(this.player);
		}
		
	}
}
