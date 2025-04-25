package com.utad.ds.proyectoFinal;

public class CharacterStats 
{
	private Integer strength;   //Ataque fisico
	private Integer magic;    //Ataque magico
	private Integer physicalDef;	//Defensa fisica
	private Integer magicDef; 	//Defensa magica
	
	private Integer speed;
	
	private Integer MaxHP;
	private Integer HP;		//Puntos de vida
	private Integer MaxMP;
	private Integer MP;		//Puntos de magia, se consumen al usar ataques magicos
	
	//Mejoras para ataque, magia y la accion de defenderse
	private Integer atkBoost;
	private Integer magicBoost;
	private Integer	guardBoost;
	
	
	public Integer getStrength() {	return this.strength;	}
	public void setStrength(Integer strength) {	this.strength = strength;	}
	
	public Integer getMagic() {	return this.magic;	}
	public void setMagic(Integer magic) {	this.magic = magic;	}
	
	public Integer getPhysicalDef() {	return this.physicalDef;	}
	public void setPhysicalDef(Integer physicalDef) {	this.physicalDef = physicalDef;	}
	
	public Integer getMagicDef() {	return this.magicDef;	}
	public void setMagicDef(Integer magicDef) {	this.magicDef = magicDef;	}
	
	public Integer getSpeed() {	return this.speed;	}
	public void setSpeed(Integer speed) {	this.speed = speed;	}
	
	public Integer getMaxHP() {	return this.MaxHP;	}
	public void setMaxHP(Integer maxHP) {	MaxHP = maxHP;	}
	
	public Integer getHP() {	return this.HP;	}
	public void setHP(Integer HP) {	this.HP = HP;	}
	
	public Integer getMaxMP() {	return this.MaxMP;	}
	public void setMaxMP(Integer maxMP) {	MaxMP = maxMP;	}
	
	public Integer getMP() {	return this.MP;	}
	public void setMP(Integer mP) {	MP = mP;	}
	
	public Integer getAtkBoost() {	return this.atkBoost;	}
	public void setAtkBoost(Integer atkBoost) {	this.atkBoost = atkBoost;	}
	
	public Integer getMagicBoost() {	return this.magicBoost;	}
	public void setMagicBoost(Integer magicBoost) {	this.magicBoost = magicBoost;	}
	
	public Integer getGuardBoost() {	return this.guardBoost;	}
	public void setGuardBoost(Integer guardBoost) {	this.guardBoost = guardBoost;	}
	
	
}
