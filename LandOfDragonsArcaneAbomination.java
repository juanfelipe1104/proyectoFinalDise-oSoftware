package com.utad.ds.proyectoFinal;

public class LandOfDragonsArcaneAbomination extends Enemy implements ArcaneAbomination
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Arcane Abobination",0,60,45,60,20,80,300);
	public static final Double INCREASE_STATS = 1.3;
	public LandOfDragonsArcaneAbomination() 
	{
		this(LandOfDragonsArcaneAbomination.DEFAULT_STATS);
	}
	
	public LandOfDragonsArcaneAbomination(CharacterStats characterStats) 
	{
		super(characterStats);
	}
		
	@Override
	public void increaseStats() 
	{
		if(super.characterStats.getHP()<=super.characterStats.getMaxHP())
		{
			super.characterStats.setMagic((int)(super.characterStats.getMagic()*LandOfDragonsArcaneAbomination.INCREASE_STATS));
		}
	}

	@Override
	public void followUpAttack() 
	{	
		//llamar a realizar otra accion
	}


	@Override
	public void useSkill() 
	{	
		this.followUpAttack();
	}
		

}
