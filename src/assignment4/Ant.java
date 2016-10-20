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
 * Bunny class
 */
public class Ant extends Critter {

	
	@Override
	public String toString() { return "A"; }
	
	private String Colony = new String();
	private boolean isQueen;
	
	public Ant(){
		switch(Critter.getRandomInt(4)){
			case 0: 
				Colony = "fire ant";
				break;
			case 1:
				Colony = "carpenter ant";
				break;
			case 2:
				Colony = "tiny ant";
				break;
			case 3:
				Colony = "flying ant";
				break;
		}
		if(Critter.getRandomInt(20) == 19){
			isQueen = true;
		}
		else{
			isQueen = false;
		}
			
	}
	
	@Override
	public void doTimeStep() {
		if(isQueen){
			Ant babyAnt = new Ant();
			reproduce(babyAnt, Critter.getRandomInt(8));
		}
	}

	@Override
	public boolean fight(String opponent) {
		if(!opponent.equals("A")){
			return false;
		}
		return true;
	}
	
	public static void runStats(java.util.List<Critter> ants){
		int fire = 0;
		int carpenter = 0;
		int tiny = 0;
		int flying = 0;
		for(Object obj: ants){
			Ant a = (Ant) obj;
			switch (a.Colony){
				case "fire ant":
					fire++;
					break;
				case "carpenter ant":
					carpenter++;
					break;
				case "tiny ant":
					tiny++;
					break;
				case "flying ant":
					flying++;
					break;
			}
		}
		System.out.println("colony populations: fire - " + fire + ", carpenter - " + carpenter + 
						   ", tiny - " + tiny + ", flying - " + flying);
	}
	
	
}
