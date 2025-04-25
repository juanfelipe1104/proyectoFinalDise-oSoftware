package com.utad.ds.proyectoFinal;

public class MagicForestIroncladBrute extends Enemy implements IroncladBrute
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",40,0,100,100,10,400,0);
	public static final Double INCREASE_STATS = 1.2;
	
	
	public MagicForestIroncladBrute()
	{
		this(MagicForestIroncladBrute.DEFAULT_STATS);
	}
	
	public MagicForestIroncladBrute(CharacterStats characterStats)
	{
		super(characterStats);
	}

	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=(super.characterStats.getMaxHP())*0.3)
		{
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MagicForestIroncladBrute.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MagicForestIroncladBrute.INCREASE_STATS));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.increasePhysicalDef();
	}


	@Override
	public void increasePhysicalDef() 
	{
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsIroncladBrute.INCREASE_STATS));
	}

}
