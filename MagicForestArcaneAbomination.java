package com.utad.ds.proyectoFinal;


public class MagicForestArcaneAbomination implements ArcaneAbomination
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Arcane Abobination",0,40,30,40,20,80,200);
	public static final Double INCREASE_STATS = 1.2;
	private CharacterStats characterStats;
	public MagicForestArcaneAbomination() 
	{
		this(MagicForestArcaneAbomination.DEFAULT_STATS);
	}
	
	public MagicForestArcaneAbomination(CharacterStats characterStats) 
	{
		this.characterStats = characterStats;
	}
		
	@Override
	public void increaseStats(CharacterStats stats) 
	{
		if(this.characterStats.getHP()<=this.characterStats.getMaxHP())
		{
			this.characterStats.setMagic((int)(this.characterStats.getMagic()*MagicForestArcaneAbomination.INCREASE_STATS));
		}
	}

	@Override
	public void followUpAttack() 
	{	
		//llamar a realizar otra accion
	}
	
	@Override
	public void usarHabilidad() 
	{
		this.followUpAttack();	
	}
		

}
