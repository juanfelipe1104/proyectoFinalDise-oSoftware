package com.utad.ds.proyectoFinal;

//Excepcion por si hay una incongruencia con las acciones
public class ActionException extends Exception
{
	private String message;
	public ActionException(String message)
	{
		this.message = message;
	}
	
	public String getMessage() { return this.message; }
}
