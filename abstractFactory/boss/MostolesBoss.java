package com.utad.ds.proyectoFinal.abstractFactory.boss;

import com.utad.ds.proyectoFinal.abstractFactory.MostolesAbstractFactory;
import com.utad.ds.proyectoFinal.common.Character;
import com.utad.ds.proyectoFinal.common.CharacterStats;
import com.utad.ds.proyectoFinal.common.Enemy;

public class MostolesBoss extends Enemy implements Boss{
	public static final Double INCREASE_STATS = 5.0;
	private Boolean revive;
	public MostolesBoss(){
		this(new CharacterStats("Boss",120,120,120,120,120,120,120));
	}
	public MostolesBoss(CharacterStats characterStats){
		super(characterStats);
		this.revive = false;
		super.characterStats.setMagicDef((int)(super.characterStats.getMagicDef()*MostolesAbstractFactory.INCREASE_STATS));
		super.characterStats.setPhysicalDef((int)(super.characterStats.getPhysicalDef()*MostolesAbstractFactory.INCREASE_STATS));
		super.characterStats.setStrength(((int)(super.characterStats.getStrength()*MostolesBoss.INCREASE_STATS)));	
	}
	
	@Override
	public void useSkill(Character target) {	
		this.revive();
	}
	@Override
	public void revive() {	
		if(this.revive.equals(false)){
			this.revive = true;
			System.out.println(super.characterStats.getName() + " ha revivido");
			super.characterStats.setHP(super.characterStats.getMaxHP());
		}
	}
}
