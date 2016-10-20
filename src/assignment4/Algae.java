/* CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Regan Stehle
 * rms3762
 * 16465
 * Matthew Edwards
 * mwe295
 * 16475
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4;

/*
 * Algae class, food course for other critters
 */
public class Algae extends Critter.TestCritter {

	
	@Override
	/**
	 * Algae represented in worldview by @
	 */
	public String toString() { return "@"; }
	
	@Override
	/**
	 * Behavior of Algae, increases energy by photosynthesis_energy, does not move
	 */
	public void doTimeStep() {
		super.setEnergy(super.getEnergy() + Params.photosynthesis_energy_amount);
		
	}

	@Override
	/**
	 * Behavior in a fight, does not elect to fight, does not try to flee
	 */
	public boolean fight(String opponent) {
		return false;
	}
	
	
}
