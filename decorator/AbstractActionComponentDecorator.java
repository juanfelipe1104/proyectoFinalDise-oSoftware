package com.utad.ds.proyectoFinal.decorator;

public abstract class AbstractActionComponentDecorator implements ActionComponentDecorator{
	//Componente al que decora
	protected ActionComponent actionComponent;
	protected Integer level;
	public AbstractActionComponentDecorator(ActionComponent actionComponent, Integer level){
		this.actionComponent = actionComponent;
		this.level = level;
	}
	public void levelUp(){
		this.level++;
	}	
	//Metodo para buscar un decorador concreto por ejemplo
	public ActionComponentDecorator searchComponentDecorator(ActionComponentDecorator decorator){
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
}
