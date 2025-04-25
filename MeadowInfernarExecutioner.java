package com.utad.ds.proyectoFinal;

public class MeadowInfernarExecutioner extends Enemy implements InfernalExecutioner
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",30,0,20,10,10,50,0);
	public static final Double INCREASE_STATS = 1.1;
	
	
	public MeadowInfernarExecutioner()
	{
		this(MeadowInfernarExecutioner.DEFAULT_STATS);
	}
	
	public MeadowInfernarExecutioner(CharacterStats characterStats)
	{
		super(characterStats);
	}

	@Override
	public void ignoreDefense() 
	{
		//llamar a algo
		
	}

	@Override
	public void increaseStats(CharacterStats characterStats) 
	{
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP())
		{
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MeadowInfernarExecutioner.INCREASE_STATS)));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.ignoreDefense();
	}

}
