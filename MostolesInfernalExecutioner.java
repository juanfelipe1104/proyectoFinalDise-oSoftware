package com.utad.ds.proyectoFinal;


public class MostolesInfernalExecutioner extends Enemy implements InfernalExecutioner
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",120,0,80,40,40,200,0);
	public static final Double INCREASE_STATS = 1.3;
	
	
	public MostolesInfernalExecutioner()
	{
		this(MostolesInfernalExecutioner.DEFAULT_STATS);
	}
	
	public MostolesInfernalExecutioner(CharacterStats characterStats)
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
			super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MostolesInfernalExecutioner.INCREASE_STATS)));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.ignoreDefense();
	}

}

