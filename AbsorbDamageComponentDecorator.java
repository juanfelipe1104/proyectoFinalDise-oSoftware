package com.utad.ds.proyectoFinal;

//Para ataques fisicos y magicos, el usuario absorbe una cantidad fija de daño dependiendo del nivel
public class AbsorbDamageComponentDecorator extends AbstractActionComponentDecorator
{
	public static final Integer BASE_DAMAGE_ABSORBED = 20;
	
	public AbsorbDamageComponentDecorator(ActionComponent actionComponent, Integer level)
	{
		super(actionComponent, level);
	}

	public String getDescription() 
	{
		return super.getActionComponent().getDescription() + " con mejora de absorber daño de nivel " + this.level;
	}
	
	
	public void absorbDamage(Character performer)
	{
		CharacterStats performerStats = performer.getCharacterStats();
		//Se cura en base al nivel del boost
		Integer healedDamage = AbsorbDamageComponentDecorator.BASE_DAMAGE_ABSORBED + (super.level-1)*10;
		System.out.println(performerStats.getName() + " ha absorbido " + healedDamage + " de vida.");
		performerStats.setHP(performerStats.getHP() + healedDamage);
		if(performerStats.getHP() > performerStats.getMaxHP())
		{
			performerStats.setHP(performerStats.getMaxHP());
		}
	}

	public void performAction(Character performer, Character target) throws ActionException
	{
		this.absorbDamage(performer);
		super.getActionComponent().performAction(performer, target);
	}

	public void performAction(Character performer, Character target, Integer boost) throws ActionException
	{
		this.absorbDamage(performer);
		super.getActionComponent().performAction(performer, target, boost);
	}
	
}

