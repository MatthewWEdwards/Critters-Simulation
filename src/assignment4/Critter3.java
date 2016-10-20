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
/**
 * 
 * @author rstehle
 * Critter3 class. This Critter does not walk during its time step, but reproduces if it has more than twice
 * the minimum energy needed to do so. During a fight, this critter reproduces and then chooses to fight if
 * its energy is twice the minimum energy needed to reproduce. If not, it tries to run away and chooses not to 
 * fight.Because it does not move during its timeStep, it will successfully flee unless the space it tries to 
 * move into is occupied.
 *
 *
 */

public class Critter3 extends Critter{
	@Override
	/**
	 * Critter 3 represented by P in view component
	 */
	public String toString() { return "P"; }
	
	
	/** Behavior of Critter3 in fight, reproduces and fights if it has twice the energy needed to reproduce
	 * Otherwise tries to flee
	 * @param opponent, name of opponent to fight
	 * @return true if elects to fight, false otherwise
	 */
	public boolean fight(String opponent) {
		if(this.getEnergy() > 2*Params.min_reproduce_energy){
			Critter3 child = new Critter3();
			reproduce(child, Critter.getRandomInt(8));
			return true;
		}
		
		run(Critter.getRandomInt(8));
		return false;
		
	 }

	@Override
	/**
	 * Behavior of Critter3 during timeStep, reproduces if it has twice the energy needed to reproduce
	 */
	public void doTimeStep() {
			
		
		if (getEnergy() > 2*Params.min_reproduce_energy) {
			Critter3 child = new Critter3();
			reproduce(child, Critter.getRandomInt(8));
		}
		
		
	}

	
}
