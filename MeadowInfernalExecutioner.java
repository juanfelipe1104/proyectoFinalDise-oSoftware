package com.utad.ds.proyectoFinal;

public class MeadowInfernalExecutioner extends Enemy implements InfernalExecutioner
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",30,0,20,10,10,50,0);
	public static final Double INCREASE_STATS = 1.1;
	
	
	public MeadowInfernalExecutioner()
	{
		this(MeadowInfernalExecutioner.DEFAULT_STATS);
	}
	
	public MeadowInfernalExecutioner(CharacterStats characterStats)
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
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MeadowInfernalExecutioner.INCREASE_STATS)));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.ignoreDefense();
	}

}
