package com.utad.ds.proyectoFinal;

//Para subir la cantidad de daño que se absorbe al protegerse
public class GuardingBoostComponentDecorator extends AbstractActionComponentDecorator
{
	
	public GuardingBoostComponentDecorator(ActionComponent actionComponent, Integer level)
	{
		super(actionComponent, level);
	}

	public String getDescription() 
	{
		return super.getActionComponent().getDescription() + " con mejora de nivel " + this.level;
	}
	

	public void performAction(Character performer, Character target) throws ActionException
	{
		//Vamos a aumentar el daño del que se protege el usuario en base al nivel
		
		
		super.getActionComponent().performAction(performer, target, super.level);
		
	}

	public void performAction(Character performer, Character target, Integer boost) throws ActionException
	{
		throw new ActionException("Error: Incongruencia en las acciones, hay una con doble boost.");
	}
	
}
