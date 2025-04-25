package com.utad.ds.proyectoFinal;

public interface ActionComponent 
{
	public String getDescription();
	
	//Metodo sobrecargado porque no siempre va a haber boost
	public void performAction(Character performer, Character target) throws ActionException;
	public void performAction(Character performer, Character target, Integer boost) throws ActionException;
	
	public ActionComponentDecorator searchComponentDecorator(ActionComponentDecorator decorator);
}
