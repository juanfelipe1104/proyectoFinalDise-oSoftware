package com.utad.ds.proyectoFinal;

public abstract class Enemy extends GameCharacter
{
	public static final EnemyBehaviorStrategy DEFAULT_STRATEGY;
	public static final Integer MP_COST = 50;
	
	protected EnemyBehaviorStrategy enemyBehaviorStrategy;

	static
	{
		DEFAULT_STRATEGY = new BalancedBehaviorStrategy();
	}
	
	public Enemy(CharacterStats characterStats) 
	{
		this(characterStats, Enemy.DEFAULT_STRATEGY);
	}
	
	public Enemy(CharacterStats characterStats, EnemyBehaviorStrategy enemyBehaviorStrategy)
	{
		super(characterStats);
		this.enemyBehaviorStrategy = enemyBehaviorStrategy;
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
	
	public abstract void useSkill();
	public abstract void increaseStats();
	
	public void performAction(Character target) 
	{
		try
		{
			this.enemyBehaviorStrategy.performAction(this, target);
		}
		
		catch(ActionException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void setEnemyBehaviorStrategy(EnemyBehaviorStrategy enemyBehaviorStrategy)
	{
		this.enemyBehaviorStrategy = enemyBehaviorStrategy;
	}
}
