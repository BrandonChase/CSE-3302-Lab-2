/* Brandon Chase 1001132518
 * CSE 3302 Assignment 2
 */
package cities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FunctionalTexasCities
{
	static final String INPUT_FILE_NAME = "src/cities/L02a Cityname_wo_headers.csv";
	static final String OUTPUT_FILE_NAME = "L02a_Functional_Output.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		ArrayList<texasCitiesClass> texasCities = new ArrayList<texasCitiesClass>();
		populateListFromFile(texasCities);

		
	}
	
	static void populateListFromFile(ArrayList<texasCitiesClass> texasCities) throws FileNotFoundException, IOException
	{
		String[] values;
		String line = "";
		BufferedReader bReader = new BufferedReader(new FileReader(INPUT_FILE_NAME));
		
		while((line = bReader.readLine()) != null)
		{
			values = line.split(",");
			texasCities.add(new texasCitiesClass(values[0], values[1], Integer.parseInt(values[2])));
		}
		
		bReader.close();
	}
}
