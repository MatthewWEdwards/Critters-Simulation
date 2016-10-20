//* CRITTERS Critter.java
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
public class Longhorn extends Critter{
	private int dir;
	
	@Override
	/**
	 * Represented in world view by L
	 */
	public String toString() { return "L"; }

	@Override 
	/**
	 * Behavior of Longhorn, changes direction each time, does not try to walk
	 */
	public void doTimeStep(){
		int energy = getEnergy();
		dir = (energy*1000%7);
	}
	
	
	@Override
	/**
	 * Tries to flee from a fight
	 * @params opponent, name of opponent in fight
	 * @return returns false because does not choose to ever fight
	 */
	public boolean fight(String opponent){
	
		walk(dir); 
		return false;
	}
}
