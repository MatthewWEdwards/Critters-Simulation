package assignment4;

public class Pony extends Critter{
	@Override
	public String toString() { return "P"; }
	
	

	
	
	
	public boolean fight(String opponent) {
		if(this.getEnergy() > 10){
			return true;
		}
		
		run(Critter.getRandomInt(8));
		return false;
		
		 }

	@Override
	public void doTimeStep() {
		/* take one step forward */
	
		
		if (getEnergy() > 15) {
			Pony child = new Pony();
			reproduce(child, Critter.getRandomInt(8));
		}
		
		
	}

	
}

