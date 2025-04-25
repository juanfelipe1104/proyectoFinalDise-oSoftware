package com.utad.ds.proyectoFinal;

public abstract class AbstractActionComponentDecorator implements ActionComponentDecorator
{
	//Componente al que decora
	protected ActionComponent actionComponent;
	protected Integer level;
	
	public AbstractActionComponentDecorator(ActionComponent actionComponent, Integer level)
	{
		this.actionComponent = actionComponent;
		this.level = level;
	}
	
	public void levelUp()
	{
		this.level++;
	}
	
	//Metodo para buscar un decorador concreto
	public ActionComponentDecorator searchComponentDecorator(ActionComponentDecorator decorator)
	{
		if(this.getClass().equals(decorator.getClass()))
		{
			return this;
		}
		
		else if(this.getActionComponent().getClass().equals(decorator.getClass()))
		{
			return (ActionComponentDecorator)(this.getActionComponent());
		}
		
		//Si hemos llegado a la base, no lo hemos encontrado
		else if(!(this.getActionComponent() instanceof ActionComponentDecorator))
		{
			return null;
		}
		
		else 
		{
			return ((ActionComponentDecorator)(this.getActionComponent())).searchComponentDecorator(decorator);
		}
	}

	public ActionComponent getActionComponent() {	return this.actionComponent;	}
	
	public void setLevel(Integer level) { this.level = level; }
	public Integer getLevel() { return this.level; }
	
	
}
