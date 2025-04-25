package com.utad.ds.proyectoFinal;

public class MagicForestBoss extends Enemy implements Boss
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Boss",60,60,60,60,60,60,60);
	public static final Double INCREASE_STATS = 3.0;
	private Boolean revive;
	
	
	public MagicForestBoss()
	{
		this(MagicForestBoss.DEFAULT_STATS);
	}
	
	public MagicForestBoss(CharacterStats characterStats)
	{
		super(characterStats);
		this.revive = false;
	}


	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP())
		{
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MagicForestBoss.INCREASE_STATS)));
			
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.revive();
	}

	@Override
	public void revive() 
	{	
		this.revive = true;
		
	}
}
