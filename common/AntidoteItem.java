package com.utad.ds.proyectoFinal.common;

public class AntidoteItem implements Item
{
	public void useItem(Character character) 
	{
		character.removeSideEffect();
	}


	public String getName() 
	{
		return "Antídoto";
	}


	public String getDescription() 
	{

		return "Cura los efectos alterados";
	}

}
