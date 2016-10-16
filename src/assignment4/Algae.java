package assignment4;

/*
 * Algae class
 */
public class Algae extends Critter.TestCritter {

	
	@Override
	public String toString() { return "@"; }
	
	@Override
	public void doTimeStep() {
		super.setEnergy(super.getEnergy() + Params.photosynthesis_energy_amount);
		
	}

	@Override
	public boolean fight(String opponent) {
		return false;
	}
	
	
}