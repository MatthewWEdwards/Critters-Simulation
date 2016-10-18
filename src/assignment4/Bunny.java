package assignment4;

/*
 * Bunny class
 */
public class Bunny extends Critter {

	
	@Override
	public String toString() { return "B"; }
	
	@Override
	public void doTimeStep() {
		Bunny babyBunny = new Bunny();
		reproduce(babyBunny, Critter.getRandomInt(8));
		if(Critter.getRandomInt(2) % 2 == 1){
			super.walk(getRandomInt(8));
		}
	}

	@Override
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