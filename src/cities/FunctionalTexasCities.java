/* Brandon Chase 1001132518
 * CSE 3302 Assignment 2
 */
package cities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

public class FunctionalTexasCities
{
	static final String INPUT_FILE_NAME = "src/cities/L02a Cityname_wo_headers.csv";
	static final String OUTPUT_FILE_NAME = "L02a_Functional_Output.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		ArrayList<texasCitiesClass> texasCities = new ArrayList<>();

		populateListsFromFile(texasCities);
		
		ArrayList<String> counties = texasCities.stream()
				.map(city -> city.getCounty())
				.distinct()
				.sorted()
				.collect(Collectors.toCollection(ArrayList::new));
		
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
		bWriter.write("County name\tNo. Cities\tTotal Pop\tAve Pop\tLargest City\tPopulation");
		bWriter.newLine();
		
		counties.stream()
				.forEach(county -> {
					try {
						bWriter.write(county);
						
						bWriter.write("\t");
						
						bWriter.write(String.valueOf(texasCities.stream()
								.filter(city -> city.getCounty().equals(county))
								.count()));
						
						bWriter.write("\t");
						
						bWriter.write(NumberFormat.getNumberInstance(Locale.US).format(
								texasCities.stream()
								.filter(city -> city.getCounty().equals(county))
								.mapToInt(city -> city.getPopulation())
								.sum()));
						
						bWriter.write("\t");
						
						bWriter.write(NumberFormat.getNumberInstance(Locale.US).format(
								(int) texasCities.stream()
								.filter(city -> city.getCounty().equals(county))
								.mapToInt(city -> city.getPopulation())
								.average()
								.getAsDouble()));
						
						bWriter.write("\t");
						
						bWriter.write(texasCities.stream()
								.filter(city -> city.getCounty().equals(county))
								.max(Comparator.comparing(city -> city.getPopulation()))
								.get()
								.getName());
						
						bWriter.write("\t");
						
						bWriter.write(NumberFormat.getNumberInstance(Locale.US).format(
								texasCities.stream()
								.filter(city -> city.getCounty().equals(county))
								.mapToInt(city -> city.getPopulation())
								.max()
								.getAsInt()));
						
						bWriter.newLine();
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					});
		bWriter.close();
		
	}
	
	static void populateListsFromFile(ArrayList<texasCitiesClass> texasCities) throws FileNotFoundException, IOException
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
