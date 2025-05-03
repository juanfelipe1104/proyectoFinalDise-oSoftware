package com.utad.ds.proyectoFinal.common;


import com.utad.ds.proyectoFinal.decorator.ActionComponent;
import com.utad.ds.proyectoFinal.state.*;

//Define el comportamiento de los personajes
public interface Character {
	public abstract void performAction(Character opponent);
	public abstract void playTurn(Character opponent);
	public abstract CharacterStats getCharacterStats();
	public abstract void setCurrentState(CharacterState characterState);
	public abstract CharacterState getCurrentState();
	public abstract BaseState getBaseState();
	public abstract BleedingState getBleedingState();
	public abstract ParalysisState getParalysisState();
	public abstract SlowDownState getSlowDownState();
	public abstract DeadState getDeadState();
	public abstract void performEffect();
	public abstract void removeSideEffect();
	public abstract void applyParalysis();
	public abstract void applyBleeding();
	public abstract void applySlowDown();
	public abstract void killCharacter();
	public abstract Boolean isDead();
	public abstract Boolean hasEnoughMP();
	public abstract Boolean isFaster(Character opponent);
	public abstract void setCurrentAction(ActionComponent currentAction);
	public abstract ActionComponent getPhysicalAttackAction();
	public abstract void setPhysicalAttackAction(ActionComponent physicalAttackAction);
	public abstract ActionComponent getMagicAttackAction();
	public abstract void setMagicAttackAction(ActionComponent magicAttackAction);
	public abstract ActionComponent getGuardAction();
	public abstract void setGuardAction(ActionComponent guardAction);
	public abstract ActionComponent getHealAction();
	public abstract void setHealAction(ActionComponent healAction);
}
