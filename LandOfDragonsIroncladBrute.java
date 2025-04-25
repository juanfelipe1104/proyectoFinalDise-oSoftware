package com.utad.ds.proyectoFinal;

public class LandOfDragonsIroncladBrute extends Enemy implements IroncladBrute
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",60,0,150,150,15,600,0);
	public static final Double INCREASE_STATS = 1.3;
	
	
	public LandOfDragonsIroncladBrute()
	{
		this(LandOfDragonsIroncladBrute.DEFAULT_STATS);
	}
	
	public LandOfDragonsIroncladBrute(CharacterStats characterStats)
	{
		super(characterStats);
	}

	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=(super.characterStats.getMaxHP())*0.3)
		{
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*LandOfDragonsIroncladBrute.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsIroncladBrute.INCREASE_STATS));
		}
		
	}

	@Override
	public void useSkill() 
	{	
		this.increasePhysicalDef();;
	}
	
	@Override
	public void increasePhysicalDef() 
	{
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*LandOfDragonsIroncladBrute.INCREASE_STATS));
	}


}
