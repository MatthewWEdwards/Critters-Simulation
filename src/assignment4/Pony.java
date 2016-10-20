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
 *
 */
public class Pony extends Critter{
	@Override
	/**
	 * Pony represented by P in view component
	 */
	public String toString() { return "P"; }
	
	
	/** Behavior of Pony in fight, reproduces and fights if it has twice the energy needed to reproduce
	 * Otherwise tries to flee
	 * @param opponent, name of opponent to fight
	 * @return true if elects to fight, false otherwise
	 */
	public boolean fight(String opponent) {
		if(this.getEnergy() > 2*Params.min_reproduce_energy){
			Pony child = new Pony();
			reproduce(child, Critter.getRandomInt(8));
			return true;
		}
		
		run(Critter.getRandomInt(8));
		return false;
		
	 }

	@Override
	/**
	 * Behavior of Pony, reproduces if it has twice the energy needed to reproduce
	 */
	public void doTimeStep() {
			
		
		if (getEnergy() > 2*Params.min_reproduce_energy) {
			Pony child = new Pony();
			reproduce(child, Critter.getRandomInt(8));
		}
		
		
	}

	
}

