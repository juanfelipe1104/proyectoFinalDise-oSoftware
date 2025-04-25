package com.utad.ds.proyectoFinal;

public class LandOfDragonsBoss extends Enemy implements Boss
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Boss",90,90,90,90,90,90,90);
	public static final Double INCREASE_STATS = 4.0;
	private Boolean revive;
	
	
	public LandOfDragonsBoss()
	{
		this(LandOfDragonsBoss.DEFAULT_STATS);
	}
	
	public LandOfDragonsBoss(CharacterStats characterStats)
	{
		super(characterStats);
		this.revive = false;
	}


	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP())
		{
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*LandOfDragonsBoss.INCREASE_STATS)));
			
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
