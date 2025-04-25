package com.utad.ds.proyectoFinal;

public abstract class Enemy 
{
	protected CharacterStats characterStats;
	public Enemy(CharacterStats characterStats) 
	{
		this.characterStats = characterStats;
	}
	public abstract void increaseStats(CharacterStats stats);
	public abstract void useSkill();
	
}
