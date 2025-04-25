package com.utad.ds.proyectoFinal;

public abstract class GameCharacter implements Character
{
	protected CharacterStats characterStats;
	protected CharacterState currentState;
	protected BaseState baseState;
	protected BleedingState bleedingState;
	protected ParalysisState paralysisState;
	protected SlowDownState slowDownState;
	protected DeadState deadState;
	
	protected ActionComponent physicalAttackAction;
	protected ActionComponent magicAttackAction;
	protected ActionComponent guardAction;
	protected ActionComponent healAction;
	
	public GameCharacter(String name) 
	{
		this(new CharacterStats(name, 50, 50, 50, 50, 50, 100, 100));
	}
	
	public GameCharacter(CharacterStats characterStats) 
	{
		this.characterStats = characterStats;
		
		this.baseState = new BaseState(this);
		this.bleedingState = new BleedingState(this);
		this.paralysisState = new ParalysisState(this);
		this.slowDownState = new SlowDownState(this);
		this.deadState = new DeadState(this);
		this.currentState = this.baseState;
		
		//Las acciones al principio son basicas, luego las iremos decorando
		this.physicalAttackAction = new BaseAttackAction();
		this.magicAttackAction = new BaseMagicAction();
		this.healAction = new BaseHealingAction();
		this.guardAction = new BaseGuardAction();
	}
	

	@Override
	public CharacterStats getCharacterStats() 
	{
		return this.characterStats;
	}

	@Override
	public void setCurrentState(CharacterState characterState) 
	{
		this.currentState = characterState;
	}

	@Override
	public BaseState getBaseState() 
	{
		return this.baseState;
	}

	@Override
	public BleedingState getBleedingState() 
	{
		return this.bleedingState;
	}

	@Override
	public ParalysisState getParalysisState() 
	{
		return this.paralysisState;
	}

	@Override
	public SlowDownState getSlowDownState() 
	{
		return this.slowDownState;
	}

	@Override
	public void performEffect() 
	{
		this.currentState.performEffect();
	}

	@Override
	public void removeSideEffect() 
	{
		this.currentState.removeSideEffect();
	}

	@Override
	public void applyParalysis() 
	{
		this.currentState.applyParalysis();
	}

	@Override
	public void applyBleeding() 
	{
		this.currentState.applyBleeding();
	}

	@Override
	public void applySlowDown() 
	{
		this.currentState.applySlowDown();
	}

	@Override
	public DeadState getDeadState() 
	{
		return this.deadState;
	}

	@Override
	public void killCharacter() 
	{
		this.currentState.killCharacter();
	}

	@Override
	public CharacterState getCurrentState() 
	{
		return this.currentState;
	}
	
	public ActionComponent getPhysicalAttackAction() 
	{
		return this.physicalAttackAction;
	}
	public void setPhysicalAttackAction(ActionComponent physicalAttackAction) 
	{
		this.physicalAttackAction = physicalAttackAction;
	}
	public ActionComponent getMagicAttackAction() {
		return this.magicAttackAction;
	}
	public void setMagicAttackAction(ActionComponent magicAttackAction) 
	{
		this.magicAttackAction = magicAttackAction;
	}
	public ActionComponent getGuardAction() 
	{
		return this.guardAction;
	}
	public void setGuardAction(ActionComponent guardAction) 
	{
		this.guardAction = guardAction;
	}
	public ActionComponent getHealAction() 
	{
		return this.healAction;
	}
	public void setHealAction(ActionComponent healAction) 
	{
		this.healAction = healAction;
	}
}
