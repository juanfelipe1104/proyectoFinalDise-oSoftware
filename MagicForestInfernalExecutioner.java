package com.utad.ds.proyectoFinal;


public class MagicForestInfernalExecutioner extends Enemy implements InfernalExecutioner
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",60,0,40,20,20,100,0);
	public static final Double INCREASE_STATS = 1.2;
	
	
	public MagicForestInfernalExecutioner()
	{
		this(MagicForestInfernalExecutioner.DEFAULT_STATS);
	}
	

	public MagicForestInfernalExecutioner(CharacterStats characterStats)
	{
		super(characterStats);
	}

	@Override
	public void ignoreDefense() 
	{
		//llamar a algo
		
	}

	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP())
		{
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MagicForestInfernalExecutioner.INCREASE_STATS)));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.ignoreDefense();
	}


}
