package assignment4;

public class Pony extends Critter{
	@Override
	public String toString() { return "P"; }
	
	

	
	
	
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
	public void doTimeStep() {
			
		
		if (getEnergy() > 2*Params.min_reproduce_energy) {
			Pony child = new Pony();
			reproduce(child, Critter.getRandomInt(8));
		}
		
		
	}

	
}
