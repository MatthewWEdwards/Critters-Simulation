package assignment4;

/*
 * Algae class
 */
public class Algae extends Critter.TestCritter {

	public Algae(){
		super.setEnergy(Params.start_energy);
		super.setX_coord(Critter.getRandomInt(Params.world_width));
		super.setY_coord(Critter.getRandomInt(Params.world_height));
	}
	
	@Override
	public void doTimeStep() {
		super.setEnergy(super.getEnergy() + Params.photosynthesis_energy_amount);
		
	}

	@Override
	public boolean fight(String oponent) {
		return false;
	}
	
	
}