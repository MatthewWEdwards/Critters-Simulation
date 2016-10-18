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