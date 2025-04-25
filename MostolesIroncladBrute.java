package com.utad.ds.proyectoFinal;

public class MostolesIroncladBrute extends Enemy implements IroncladBrute
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",80,0,200,200,20,800,0);
	public static final Double INCREASE_STATS = 1.4;
	
	
	public MostolesIroncladBrute()
	{
		this(MostolesIroncladBrute.DEFAULT_STATS);
	}
	
	public MostolesIroncladBrute(CharacterStats characterStats)
	{
		super(characterStats);
	}

	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP())
		{
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MostolesIroncladBrute.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MostolesIroncladBrute.INCREASE_STATS));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.reflect();;
	}


	@Override
	public void reflect() 
	{
		// TODO Auto-generated method stub
		
	}

}
