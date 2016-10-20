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
 * @author rstehle
 * Critter2 class. This critter changes direction during its timestep, but does not attempt to move or reproduce. 
 * During a fight, this critters tries to flee each time and walk away, it never elects to fight.Because it does
 * not walk during its timeStep, it will successfully flee unless the space it tries to move into is occupied.
 */
public class Critter2 extends Critter{
	private int dir;
	
	@Override
	/**
	 * Represented in world view by L
	 */
	public String toString() { return "2"; }

	@Override 
	/**
	 * Behavior of Critter2, changes direction each time, does not try to walk
	 */
	public void doTimeStep(){
		int energy = getEnergy();
		dir = (energy*1000%7);
	}
	
	
	@Override
	/**
	 * Tries to flee from a fight
	 * @param opponent, name of opponent in fight
	 * @return returns false because does not choose to ever fight
	 */
	public boolean fight(String opponent){
	
		walk(dir); 
		return false;
	}
}
