package com.utad.ds.proyectoFinal.decorator;

public abstract class AbstractActionComponentDecorator implements ActionComponentDecorator
{
	public static final String DEFAULT_NAME = "Acción sin nombre";
	
	//Componente al que decora
	protected ActionComponent actionComponent;
	protected Integer level;
	protected String name;
	
	
	public AbstractActionComponentDecorator(ActionComponent actionComponent, Integer level)
	{
		this(actionComponent, level, AbstractActionComponentDecorator.DEFAULT_NAME);
	}
	
	public AbstractActionComponentDecorator(ActionComponent actionComponent, Integer level, String name)
	{
		this.actionComponent = actionComponent;
		this.level = level;
		this.name = name;
	}
	
	public void levelUp()
	{
		this.level++;
	}	
	//Metodo para buscar un decorador concreto por ejemplo
	public ActionComponentDecorator searchComponentDecorator(ActionComponentDecorator decorator)
	{
		if(this.getClass().equals(decorator.getClass())){
			return this;
		}
		//Si hemos llegado a la base, no lo hemos encontrado
		else if(!(this instanceof ActionComponentDecorator))
		{
			return null;
		}
		else 
		{
			return this.getActionComponent().searchComponentDecorator(decorator);
		}
	}
	public ActionComponent getActionComponent() { return this.actionComponent; }
	public void setLevel(Integer level) { this.level = level; }
	public Integer getLevel() { return this.level; }
	public String getName() { return this.name; }
}
