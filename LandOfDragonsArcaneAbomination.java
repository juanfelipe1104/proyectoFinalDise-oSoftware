package com.utad.ds.proyectoFinal;

public class LandOfDragonsArcaneAbomination implements ArcaneAbomination
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Arcane Abobination",0,60,45,60,20,80,300);
	public static final Double INCREASE_STATS = 1.3;
	private CharacterStats characterStats;
	public LandOfDragonsArcaneAbomination() 
	{
		this(LandOfDragonsArcaneAbomination.DEFAULT_STATS);
	}
	
	public LandOfDragonsArcaneAbomination(CharacterStats characterStats) 
	{
		this.characterStats = characterStats;
	}
		
	@Override
	public void increaseStats(CharacterStats stats) 
	{
		if(this.characterStats.getHP()<=this.characterStats.getMaxHP())
		{
			this.characterStats.setMagic((int)(this.characterStats.getMagic()*LandOfDragonsArcaneAbomination.INCREASE_STATS));
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
