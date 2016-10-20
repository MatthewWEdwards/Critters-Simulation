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
 * @author MatthewWEdwards
 * Critter1 class. This critter always reproduces during its time step if able to, then walks based on 
 * a randomly generated number 0 or 1, will walk if 1 is generated. This critters always fights algae, but 
 * decides to fight other creatures using the same process as when choosing to walk, will fight if 1 is generated.
 */
public class Critter1 extends Critter {

	
	@Override
	/**
	 *  Representation of Critter1 in worldView, 1
	 */
	public String toString() { return "1"; }
	
	@Override
	/**
	 * Behavior of Critter1 in timeStep, reproduces if able to, changes direction and walks with 50% chance
	 */
	public void doTimeStep() {
		Critter1 babyBunny = new Critter1();
		reproduce(babyBunny, Critter.getRandomInt(8));
		if(Critter.getRandomInt(2) % 2 == 1){
			super.walk(getRandomInt(8));
		}
	}

	@Override
	/**
	 * Behavior of Critter1 in fight,always fights algae, else fights or flees with equal chance
	 * @param opponent, name of other critter this critter is fighting
	 * @return boolean, true if decides to fight, false if not
	 */
	public boolean fight(String opponent) {
		if(opponent.equals("@")){
			return true;
		}
		else{
			if(Critter.getRandomInt(2) % 2 == 1){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	
}
