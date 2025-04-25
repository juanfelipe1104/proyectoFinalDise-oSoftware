package com.utad.ds.proyectoFinal;


public class MagicForestArcaneAbomination extends Enemy implements ArcaneAbomination
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Arcane Abobination",0,40,30,40,20,80,200);
	public static final Double INCREASE_STATS = 1.2;
	public MagicForestArcaneAbomination() 
	{
		this(MagicForestArcaneAbomination.DEFAULT_STATS);
	}
	
	public MagicForestArcaneAbomination(CharacterStats characterStats) 
	{
		super(characterStats);
	}
		
	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP())
		{
			super.characterStats.setMagic((int)(super.characterStats.getMagic()*MagicForestArcaneAbomination.INCREASE_STATS));
		}
	}

	@Override
	public void followUpAttack() 
	{	
		//llamar a realizar otra accion
	}
	
	@Override
	public void useSkill() 
	{
		this.followUpAttack();	
	}
		

}
