package com.utad.ds.proyectoFinal;

public class MeadowArcaneAbomination implements ArcaneAbomination
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Arcane Abobination",0,20,15,20,10,40,100);
	public static final Double INCREASE_STATS = 1.1;
	private CharacterStats characterStats;
	public MeadowArcaneAbomination() 
	{
		this(MeadowArcaneAbomination.DEFAULT_STATS);
	}
	
	public MeadowArcaneAbomination(CharacterStats characterStats) 
	{
		this.characterStats = characterStats;
	}
		
	@Override
	public void increaseStats(CharacterStats stats) 
	{
		if(this.characterStats.getHP()<=this.characterStats.getMaxHP())
		{
			this.characterStats.setMagic((int)(this.characterStats.getMagic()*MeadowArcaneAbomination.INCREASE_STATS));
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
