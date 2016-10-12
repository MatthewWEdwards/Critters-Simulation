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
        }catch(InvalidCritterException e){
        	
        }
        Critter.displayWorld();
        System.out.println("GLHF");
        //End of Misc. Tests
        
        //Start controller component
        
        ArrayList<String> commands = new ArrayList<String>(Arrays.asList("quit", "show", "step", "seed", "make", "stats"));
        while(kb.hasNext()){
            boolean validInput = false;
        	String current = kb.nextLine();
        	current.trim();
        	
        	for(int i = 0; i < commands.size(); i++){
        		if(current.contains(commands.get(i))){
        			validInput = true;
        		}
        	}
        	if (!validInput){
        		System.out.println("DEBUG: invalid input");
        		continue;
        	}
        	
        	switch (current){
        		case "quit":
        			System.exit(0);
        			break;
        		case "show":
        			Critter.displayWorld();
        			break;
        		case "step":
        			if(current.length() < 5){
        				Critter.worldTimeStep();
        			}
        			else{
	        			for(int stepper = 0; stepper < current.charAt(5); stepper++){
	        				Critter.worldTimeStep();
	        			}
        			}
        			break;
        		case "seed":
        			Critter.setSeed(Integer.parseInt(current.substring(5, current.length()-1)));
        			break;
        		case "make":
        			break;
        		case "stats":
        			break;
        		default:
        			System.out.println("DEBUG: invalid input");
        	}
        	
        }
        //End controller component
                
        /* Write your code above */
        System.out.flush();

    }
}
