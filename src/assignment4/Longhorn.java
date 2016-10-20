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

public class Longhorn extends Critter{
	private int dir;
	
	@Override
	public String toString() { return "L"; }

	@Override 
	public void doTimeStep(){
		int energy = getEnergy();
		dir = (energy*1000%7);
	}
	
	
	@Override
	public boolean fight(String opponent){
	
		walk(dir); //flees from a fight, or at least tries to
		return false;
	}
}
