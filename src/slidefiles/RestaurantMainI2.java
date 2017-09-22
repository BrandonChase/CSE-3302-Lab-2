package slidefiles;

public class RestaurantMainI2 {

	public static void main(String[] args) {
		RestaurantClass rest = new RestaurantClass();

		for (String name : rest.restaurants)
			System.out.println(name);
	}
}