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
 * Critter4 class. This critter has a Colony member which designates it as one of four colonies, as well as 
 * an isQueen member which designates it as a Queen or not. These member variables are set during the 
 * Critter4 constructor. During this critter's timestep, it reproduces if it is a queen, otherwise does nothing.
 * During a fight, this critter will only fight other instances of Critter4. During runstats, this critter will 
 * display how many critter4s of each colony exist in the entire critter world population.
 *
 */
public class Critter4 extends Critter {

	
	@Override
	/**
	 * representation of Critter4 in world view component
	 */
	public String toString() { return "4"; }
	
	private String Colony = new String();
	private boolean isQueen;
	
	/**
	 * Constructor for Critter4. Assigns the critter a Colony and determines the boolean isQueen.
	 */
	public Critter4(){
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
	/**
	 * Behavior of Critter4 during timestep. If isQueen is true, it reproduces.
	 */
	public void doTimeStep() {
		if(isQueen){
			Critter4 babyAnt = new Critter4();
			reproduce(babyAnt, Critter.getRandomInt(8));
		}
	}

	@Override
	/**
	 * Behavior of Critter4 in a fight. It will only fight other instances of critter4.
	 */
	public boolean fight(String opponent) {
		if(!opponent.equals("A")){
			return false;
		}
		return true;
	}
	
	/**
	 * Prints out how many Critter4s of each colony exist in the entire critter population.
	 * @param ants
	 */
	public static void runStats(java.util.List<Critter> ants){
		int fire = 0;
		int carpenter = 0;
		int tiny = 0;
		int flying = 0;
		for(Object obj: ants){
			Critter4 a = (Critter4) obj;
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

