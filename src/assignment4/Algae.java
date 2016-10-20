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
 * Algae class
 */
public class Algae extends Critter {

	
	@Override
	public String toString() { return "@"; }
	
	@Override
	public void doTimeStep() {
		
	}

	@Override
	public boolean fight(String opponent) {
		return false;
	}
	
	
}
