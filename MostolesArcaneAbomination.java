package com.utad.ds.proyectoFinal;

public class MostolesArcaneAbomination extends Enemy implements ArcaneAbomination
{
	public static final CharacterStats DEFAULT_STATS  = new CharacterStats("Arcane Abomination",0,80,60,80,40,160,400);
	public static final Double INCREASE_STATS = 1.4;
	private CharacterStats characterStats;
	public MostolesArcaneAbomination() 
	{
		this(MostolesArcaneAbomination.DEFAULT_STATS);
	}
	
	public MostolesArcaneAbomination(CharacterStats characterStats) 
	{
		super(characterStats);
		
	}
		
	@Override
	public void increaseStats(CharacterStats stats) 
	{
		if(this.characterStats.getHP()<=this.characterStats.getMaxHP())
		{
			this.characterStats.setMagic((int)(this.characterStats.getMagic()*MostolesArcaneAbomination.INCREASE_STATS));
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
