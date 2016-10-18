/* CRITTERS Main.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4; // cannot be in default package
import java.util.*;
import java.io.*;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console

	public static boolean checkIfInt(String input, int index){
		charLoop:
			for(int i = index; i < input.length(); i++){
				for(char k = '0'; k <= '9'; k++){
	        		if(input.charAt(i) == k){
	        			continue charLoop;
	        		}     	
				}
				return false;
			}
			return true;
	}

    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    
    
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
        
        
        
        //Misc tests, TODO delete before submission
        try{
        	Critter.makeCritter("Craig");
        	Critter.makeCritter("Craig");
        	Critter.makeCritter("Craig");
        	Critter.makeCritter("Craig");
        	Critter.makeCritter("Algae");
        	Critter.makeCritter("Algae");
        }catch(InvalidCritterException e){
        	
        }
        Critter.displayWorld();
        System.out.println("\nGLHF");
        //End of Misc. Tests
        
        //Start controller component
        
        ArrayList<String> commands = new ArrayList<String>(Arrays.asList("quit", "show", "step", "seed", "make", "stats"));
        ArrayList<Character> intChars = new ArrayList<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        System.out.print("critters>");
        
        commandLoop:
        while(kb.hasNext()){
            boolean validInput = false;
        	String current = kb.nextLine();
        	current.trim();
        	
        	
        	String switchString = new String(); 
        	for(int i = 0; i < commands.size(); i++){
        		if(current.contains(commands.get(i))){
        			switchString = commands.get(i);
        			validInput = true;
        			break;
        		}
        	}
        	if (!validInput){
        		System.out.print("DEBUG: invalid input\ncritters>");
        		continue;
        	}
        	
        	switch (switchString){
        		case "quit":
        			break commandLoop;
        		case "show":
        			Critter.displayWorld();
        			break;
        		case "step":
        			if(current.length() < 5){
        				Critter.worldTimeStep();
        			}
        			else{
        				if(!checkIfInt(current, 5)){ // checks if the second part of the current string is solely an integer
        	        		System.out.println("DEBUG: invalid input");
        	        		break;
        				}
        				if(current.charAt(4) != ' '){ // check char between "step" and the number of steps.
        					System.out.println("DEBUG: invalid input");
        	        		break;
        				}
	        			for(int stepper = 0; stepper < Integer.parseInt(current.substring(5, current.length())); stepper++){
	        				Critter.worldTimeStep();
	        			}
        			}
        			break;
        		case "seed":
        			Critter.setSeed(Integer.parseInt(current.substring(5, current.length()-1)));
        			break;
        		case "make":
        			int critterToMake;
        			for(critterToMake = 5; critterToMake < current.length(); critterToMake++){
        				if(current.charAt(critterToMake) == ' '){
        					break;
        				}
        			}
        			if(critterToMake == current.length() - 1){
        				System.out.println("DEBUG: invalid input");
        				break;
        			}
        			String critterClass = current.substring(5, critterToMake);
        			if(!checkIfInt(current, critterToMake+1)){
        				System.out.println("DEBUG: invalid input");
        				break;
        			}
        			for(int stepper = 0; stepper < Integer.parseInt(current.substring(critterToMake+1, current.length())); stepper++){
        				try {
							Critter.makeCritter(critterClass);
						} catch (InvalidCritterException e) {
							System.out.println("DEBUG: invalid input");
							break; // This shouldn't happen
						}
        			}
        			break;
        		case "stats":
					try {
						Critter.runStats(Critter.getInstances(current.substring(6)));
					} catch (InvalidCritterException e) {
						System.out.println("DEBUG: invalid input");
						break;
					}
					break;
        		default:
        			System.out.println("DEBUG: invalid input");
        	}
        	System.out.print("\ncritters>");
        	
        }
        
        
        //End controller component
                
        /* Write your code above */
        System.out.flush();

    }
}
