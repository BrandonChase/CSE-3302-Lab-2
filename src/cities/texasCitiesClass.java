/* Brandon Chase 1001132518
 * CSE 3302 Assignment 2
 * 
 * Code for entire class is reused from slide file "texasCitiesClass.java" provided
 *     by Dr. John Robb 
 */
package cities;

public class texasCitiesClass
{
	private String name;
	private String county;
	private int population;

	public texasCitiesClass (String name, String county, int population) 
	{
		this.name=name;
		this.county=county;
		this.population=population;
	}

	public String getName() 
	{return name;}

	public void setName(String name) 
	{this.name = name;}
	
	public String getCounty() 
	{return county;}
	
	public void setCounty(String county) 
	{this.county = county;}
	
	public int getPopulation() 
	{return population;}
	
	public void setPopulation(int population) 
	{this.population = population;}
}
