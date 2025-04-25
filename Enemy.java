package com.utad.ds.proyectoFinal;

public abstract class Enemy implements Character
{
	public static final EnemyBehaviorStrategy DEFAULT_STRATEGY;
	protected CharacterStats characterStats;
	protected CharacterState currentState;
	protected BaseState baseState;
	protected BleedingState bleedingState;
	protected ParalysisState paralysisState;
	protected SlowDownState slowDownState;
	protected DeadState deadState;
	
	protected EnemyBehaviorStrategy enemyBehaviorStrategy;
	
	static
	{
		DEFAULT_STRATEGY = new BalancedBehaviorStrategy();
	}
	
	public Enemy(CharacterStats characterStats) 
	{
		this.characterStats = characterStats;
		
		this.baseState = new BaseState(this);
		this.bleedingState = new BleedingState(this);
		this.paralysisState = new ParalysisState(this);
		this.slowDownState = new SlowDownState(this);
		this.deadState = new DeadState(this);
		this.currentState = this.baseState;
	}
	public void playTurn(Character opponent) 
	{
		this.characterStats.setReflecting(false);
		this.characterStats.setGuarding(false);
		this.characterStats.setCanAttack(true);
		this.performEffect();
		if(this.characterStats.getCanAttack())
		{
			this.performAction(opponent);
			this.useSkill();
		}
	}
	public void performEffect() 
	{
		this.currentState.performEffect();
	}
	public void removeSideEffect() 
	{
		this.currentState.removeSideEffect();
	}
	public void applyParalysis() 
	{
		this.currentState.applyParalysis();
	}
	public void applyBleeding() 
	{
		this.currentState.applyBleeding();
	}
	public void applySlowDown() 
	{
		this.currentState.applySlowDown();
	}
	public void killCharacter() 
	{
		this.currentState.killCharacter();
	}
	public abstract void useSkill();
	public abstract void increaseStats();
	
	public void performAction(Character target) 
	{
		this.enemyBehaviorStrategy.chooseBehavior(target);	//Delegacion por agregacion
	}
	public CharacterStats getCharacterStats() 
	{
		return this.characterStats;
	}
	public void setCurrentState(CharacterState characterState) 
	{
		this.currentState = characterState;
	}
	public CharacterState getCurrentState() 
	{
		return this.currentState;
	}
	public BaseState getBaseState() 
	{
		return this.baseState;
	}
	public BleedingState getBleedingState() 
	{
		return this.bleedingState;
	}
	public ParalysisState getParalysisState() 
	{
		return this.paralysisState;
	}
	public SlowDownState getSlowDownState() 
	{
		return this.slowDownState;
	}
	public DeadState getDeadState() 
	{
		return this.deadState;
	}
}
