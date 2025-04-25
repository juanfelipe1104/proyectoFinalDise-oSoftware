package com.utad.ds.proyectoFinal;

public class MeadowIroncladBrute extends Enemy implements IroncladBrute
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Infernal Executioner",20,0,50,50,5,200,0);
	public static final Double INCREASE_STATS = 1.1;
	
	
	public MeadowIroncladBrute()
	{
		this(MeadowIroncladBrute.DEFAULT_STATS);
	}
	
	public MeadowIroncladBrute(CharacterStats characterStats)
	{
		super(characterStats);
	}

	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=(super.characterStats.getMaxHP())*0.3)
		{
			super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MeadowIroncladBrute.INCREASE_STATS));
			super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MeadowIroncladBrute.INCREASE_STATS));
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
