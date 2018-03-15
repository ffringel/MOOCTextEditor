package document;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/** A class for timing the EfficientDocument and BasicDocument classes
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 */

public class DocumentBenchmarking {

	
	public static void main(String [] args) {

	    // Run each test more than once to get bigger numbers and less noise.
	    // You can try playing around with this number.
	    int trials = 30;

	    // The text to test on
	    String textfile = "data/warAndPeace.txt";
		
	    // The amount of characters to increment each step
	    // You can play around with this
		int increment = 50000;

		// The number of steps to run.  
		// You can play around with this.
		int numSteps = 20;
		
		// THe number of characters to start with. 
		// You can play around with this.
		int start = 50000;


		System.out.println("NumberOfChars\tBasicTime\tEfficientTime\t");
		// TODO: Fill in the rest of this method so that it runs two loops
		// and prints out timing results as described in the assignment 
		// instructions and following the pseudocode below.
		for (int numToCheck = start; numToCheck < numSteps*increment + start; 
				numToCheck += increment)
		{
			System.out.printf("%s\t", numToCheck);
			String inputString = getStringFromFile(textfile, numToCheck);

			long basicStart = System.nanoTime();
			for (int i = 0; i < trials; i++) {
				BasicDocument basicDocument = new BasicDocument(inputString);
				basicDocument.getFleschScore();
			}
			double basicTime = (double)(System.nanoTime() - basicStart) /  1000000000;
			System.out.printf("%s\t", basicTime);

			long efficientStart = System.nanoTime();
			for (int i = 0; i < trials; i++) {
				EfficientDocument efficientDocument = new EfficientDocument(inputString);
				efficientDocument.getFleschScore();
			}
			double efficientTime = (double)(System.nanoTime() - efficientStart) /  1000000000;
			System.out.printf("%s\t", efficientTime);

			System.out.println();
		}
	
	}
	
	/** Get a specified number of characters from a text file
	 * 
	 * @param filename The file to read from
	 * @param numChars The number of characters to read
	 * @return The text string from the file with the appropriate number of characters
	 */
	public static String getStringFromFile(String filename, int numChars) {
		
		StringBuffer s = new StringBuffer();
		try {
			FileInputStream inputFile= new FileInputStream(filename);
			InputStreamReader inputStream = new InputStreamReader(inputFile);
			BufferedReader bis = new BufferedReader(inputStream);
			int val;
			int count = 0;
			while ((val = bis.read()) != -1 && count < numChars) {
				s.append((char)val);
				count++;
			}
			if (count < numChars) {
				System.out.println("Warning: End of file reached at " + count + " characters.");
			}
			bis.close();
		}
		catch(Exception e)
		{
		  System.out.println(e);
		  System.exit(0);
		}
		
		
		return s.toString();
	}
	
}
