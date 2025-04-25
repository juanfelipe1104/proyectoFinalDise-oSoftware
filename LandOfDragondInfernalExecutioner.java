package com.utad.ds.proyectoFinal;


public class LandOfDragondInfernalExecutioner extends Enemy implements InfernalExecutioner
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",90,0,60,30,30,150,0);
	public static final Double INCREASE_STATS = 1.3;
	
	
	public LandOfDragondInfernalExecutioner()
	{
		this(LandOfDragondInfernalExecutioner.DEFAULT_STATS);
	}
	
	public LandOfDragondInfernalExecutioner(CharacterStats characterStats)
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
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*LandOfDragondInfernalExecutioner.INCREASE_STATS)));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.ignoreDefense();
	}

}
